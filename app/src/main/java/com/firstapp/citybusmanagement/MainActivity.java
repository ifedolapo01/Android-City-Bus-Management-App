package com.firstapp.citybusmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn;

        btn = findViewById(R.id.getStarted);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This will take you to the second Splash Screen page in response to the getstarted button click
                Intent intent = new Intent(getApplicationContext(),SecondSplashScreen.class);
                startActivity(intent);
            }
        });
    }
}