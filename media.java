import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
  Button play, forward, rewind, pause, stop, reset;
  MediaPlayer mediaPlayer ;
  int starttime = 0 ; // startime is 0s
  int stopttime = 0; // stoptime is 0s by default
  int forwardtime = 5000 ; // 5s for forward
  int backwardtime = 5000 ; // 5s for backwardtime
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    play= findViewById(R.id.play);
    pause= findViewById(R.id.pause);
    stop= findViewById(R.id.stop);
    forward= findViewById(R.id.forward);
    rewind= findViewById(R.id.rewind);
    reset= findViewById(R.id.restart);
    play.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(MainActivity.this, "Playing Media Now",Toast.LENGTH_SHORT).show();
        mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.charlie);
        mediaPlayer.start();
      }
    });
    pause.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mediaPlayer.pause();
      }
    });
    reset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      mediaPlayer.seekTo(starttime);
      mediaPlayer.start();
    }
  });
  forward.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      int currpos=mediaPlayer.getCurrentPosition();
      if((currpos+forwardtime)<=(stopttime=mediaPlayer.getDuration())){
        mediaPlayer.seekTo(currpos+forwardtime);
      }
    }
  });
  rewind.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
    int currpos=mediaPlayer.getCurrentPosition();
    if((currpos-backwardtime)<=(starttime)){
      mediaPlayer.seekTo(currpos-backwardtime);
    }
  }
  });
  stop.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      mediaPlayer.stop();
    }
  });
}
}
