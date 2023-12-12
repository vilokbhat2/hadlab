import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button myButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton=findViewById(R.id.my_btn);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show the dialog
                Toast.makeText(MainActivity.this, "Clicked button", Toast.LENGTH_LONG).show();
                AlertDialog dialog=createDialog();
                dialog.show();
            }
        });
    }
    AlertDialog createDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Yes or No ??");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Clicked Yes", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Clicked No", Toast.LENGTH_LONG).show();
            }
        });
        return builder.create();
    }
}
