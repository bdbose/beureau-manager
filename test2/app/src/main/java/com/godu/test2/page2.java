package com.godu.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class page2 extends AppCompatActivity {

    Button register,login;
    EditText email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        login=findViewById(R.id.login);
        register=findViewById(R.id.register);
        pass=findViewById(R.id.pass);
        email=findViewById(R.id.email);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),page3.class);
                startActivity(i);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_app();
            }
        });
    }
    public void login_app(){
        if(email.getText().toString()=="admin" || pass.getText().toString()=="admin") {
            Toast.makeText(this,"Invalid",Toast.LENGTH_SHORT).show();
        }
        else if(email.getText().toString().trim().isEmpty() || pass.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Empty",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(getBaseContext(), page1.class);
            startActivity(i);
            finish();
        }
    }

}
