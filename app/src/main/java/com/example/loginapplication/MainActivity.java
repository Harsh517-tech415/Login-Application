 package com.example.loginapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

 public class MainActivity extends AppCompatActivity{
int counter=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView username=(TextView) findViewById(R.id.username);
        TextView password=(TextView) findViewById(R.id.password);
        MaterialButton loginbtn=(MaterialButton) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(v -> {
            if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
            //correct
            {
                Toast.makeText(getApplicationContext(),
                        "Redirecting...", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                finish();
            }

            else{
                if(username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_SHORT).show();}
                else {counter--;
                    if (counter == 0) {
                        loginbtn.setEnabled(false);
                        finish();
                    }
                    else {
                        String s = "Invalid Username/Password you have only" + "  " + counter + "  chance";
                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                    }}
            }
            }
        );

    }
}