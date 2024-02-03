package com.firstapp.citybusmanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminDashboard extends AppCompatActivity {
    EditText Location, Destination, BusNumber;
    Button insert, delete;
    DatabaseAccess myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        myDb = new DatabaseAccess(getApplicationContext());

        Location = findViewById(R.id.admin_location_text);
        Destination = findViewById(R.id.admin_destination_text);
        BusNumber = findViewById(R.id.bus_number_text);

        insert = findViewById(R.id.insert_data);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Location.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please input location!", Toast.LENGTH_SHORT).show();
                }else {
                String editText1 = Location.getText().toString();
                if (Destination.getText().toString().length() == 0) {
                        Toast.makeText(getApplicationContext(), "Please input destination!", Toast.LENGTH_SHORT).show();
                }else {
                String editText2 = Destination.getText().toString();
                if (BusNumber.getText().toString().length() == 0) {
                            Toast.makeText(getApplicationContext(), "Please input bus number!", Toast.LENGTH_SHORT).show();
                }else {
                            String editText3 = BusNumber.getText().toString();
                            myDb.insert(editText1, editText2, editText3);
                            Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
                        }
            }
        }
            }
                                  });

        delete = findViewById(R.id.delete_data);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Location.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please input location to be deleted!",
                            Toast.LENGTH_SHORT).show();
                }else {
                    String editText1 = Location.getText().toString();
                    if (Destination.getText().toString().length() == 0) {
                        Toast.makeText(getApplicationContext(), "Please input destination to be deleted!",
                                Toast.LENGTH_SHORT).show();
                    }else {
                        String editText2 = Destination.getText().toString();
                        if (BusNumber.getText().toString().length() == 0) {
                            Toast.makeText(getApplicationContext(), "Please input bus number to be deleted!",
                                    Toast.LENGTH_SHORT).show();
                        }else {
                            String editText3 = BusNumber.getText().toString();
                            myDb.delete(editText1, editText2, editText3);
                            Toast.makeText(getApplicationContext(), "Data Deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}