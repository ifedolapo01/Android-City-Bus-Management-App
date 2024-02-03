package com.firstapp.citybusmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    public EditText Location;
    public EditText GoToInput;
    public Button Search;

    //Table Column Names
    public static final String INTENT_EXTRA_DASHBOARD_LOCATION = "IEDASHBOARDLOCATION";
    public static final String INTENT_EXTRA_DASHBOARD_DESTINATION = "IEDASHBOARDDESTINATION";
    public static final String INTENT_EXTRA_DASHBOARD_BUS_NUMBER = "IEDASHBOARDBUSNUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Location = findViewById(R.id.location_text);
        GoToInput = findViewById(R.id.goToInput_text);

        Search = findViewById(R.id.search);

        Search.setOnClickListener(v -> {
            if (Location.getText().toString().length() == 0) {
                Toast.makeText(this, "Please input location!", Toast.LENGTH_SHORT).show();
                }else {
                // prepare an intent to start the searchresult activity
                Intent intent = new Intent(getApplicationContext(), SearchResult.class);

                // Prepare to invoke the SearchResult passing the values to search results
                // store the location input in an intent extra
                intent.putExtra(INTENT_EXTRA_DASHBOARD_LOCATION, Location.getText().toString().replace(" ", ""));
                if (GoToInput.getText().toString().length() == 0) {
                    Toast.makeText(this, "Please input destination!", Toast.LENGTH_SHORT).show();
                } else {
                    // store the destination input in an intent extra
                    intent.putExtra(INTENT_EXTRA_DASHBOARD_DESTINATION, GoToInput.getText().toString().replace(" ", ""));

                    startActivity(intent); // Start the SearchResult Activity that can then get the extras from the intent

                }
            }

        });
    }
}
