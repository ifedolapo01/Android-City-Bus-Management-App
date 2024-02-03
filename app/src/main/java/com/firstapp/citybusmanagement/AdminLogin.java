package com.firstapp.citybusmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);


        Button btn;
        btn = findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = (EditText) findViewById(R.id.username_text);
                EditText password= (EditText) findViewById(R.id.password_text);

                /*If a person does not know that the username is set to Admin and the password is set to admin, they
                  would not be able to login to the admin dashboard*/
                if (!username.getText().toString().equals ("Admin") || !password.getText().toString().equals ("admin")) {
                    Toast.makeText(getApplicationContext(), "Wrong username/password!", Toast.LENGTH_SHORT).show();

                }else{
                    Intent intent = new Intent(getApplicationContext(), AdminDashboard.class);
                    startActivity(intent);
                }
            }
        });
    }
}