import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button register,delete,update,display;
    DBHelper dbHelper;
    TextView res;
    private static final String dbName="studentdb";
    private static final String tbName="student" ;
    private static final int dbVersion = 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.username);
        pass=findViewById(R.id.password);
        register=findViewById(R.id.register);
        delete=findViewById(R.id.delete);
        update=findViewById(R.id.update);
        display=findViewById(R.id.display);
        res=findViewById(R.id.result);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper=new DBHelper(MainActivity.this, dbName,null,dbVersion);
                long val = dbHelper.adduser(user.getText().toString(), pass.getText().toString()) ;
                if(val == -1)
                    Toast.makeText(MainActivity.this, "Error in adding user",
                            Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(MainActivity.this, "USER REGISTERED",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(MainActivity.this, dbName, null, dbVersion) ;
                dbHelper.update(user.getText().toString(), pass.getText().toString());

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(MainActivity.this, dbName,null, dbVersion) ;
                dbHelper.delete(user.getText().toString());
            }
        });
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper = new DBHelper(MainActivity.this, dbName, null, dbVersion);
                String out= dbHelper.display(MainActivity.this);
                res.setText(out);
            }
        });

    }
}
