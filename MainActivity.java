package com.example.app_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText Password;
    private TextView Info;
    private Button login;
   // private TextView demo1;

    private int counter = 5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= (EditText)findViewById(R.id.etname);
        Password= (EditText)findViewById(R.id.etpassword);
        Info=(TextView)findViewById(R.id.tvinfo);
       // demo1=(TextView)findViewById(R.id.DEMO);
        login=(Button)findViewById(R.id.btnlogin);
        Info.setText("No.of attempts remaining : 5");

        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(),Password.getText().toString());
            }
        });


    }

    private void validate(String username, String userpass){
        if((username.equals("admin")) && (userpass.equals("1234")))

        {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

        else
        {
          counter--;
          Info.setText("No. of attempts remaining : "+String.valueOf(counter));

          if(counter==0)
          {
              login.setEnabled(false);
          }
        }
    }
}
