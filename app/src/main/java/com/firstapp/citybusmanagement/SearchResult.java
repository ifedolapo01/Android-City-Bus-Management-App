package com.firstapp.citybusmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchResult extends AppCompatActivity {

    public TextView BusNumberOutput;
    public Button searchagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        searchagain = findViewById(R.id.searchAgain);
        searchagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This will take you to the Dashboard page in response to the search again button click
                Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                startActivity(intent);
            }
        });

        BusNumberOutput = findViewById(R.id.busNumberOutput);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        // Use location and destination from the dashboard activity
        String bus_number = databaseAccess.getbus_number(
                this.getIntent().getStringExtra(Dashboard.INTENT_EXTRA_DASHBOARD_LOCATION),
                this.getIntent().getStringExtra(Dashboard.INTENT_EXTRA_DASHBOARD_DESTINATION)
        );
        // display the string into textView
        BusNumberOutput.setText(bus_number);
    }
}