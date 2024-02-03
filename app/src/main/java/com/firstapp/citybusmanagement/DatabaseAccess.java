package com.firstapp.citybusmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    //Table Column Names
    public static final String INTENT_EXTRA_DASHBOARD_LOCATION = "IEDASHBOARDLOCATION";
    public static final String INTENT_EXTRA_DASHBOARD_DESTINATION = "IEDASHBOARDDESTINATION";
    public static final String INTENT_EXTRA_DASHBOARD_BUS_NUMBER = "IEDASHBOARDBUSNUMBER";
    private static final String DATABASE_TABLE = "abuja";
    private static final String TAG = "DatabaseAccess";

    // private constructor so that object creation from outside the class is avoided
    // Database should be distinct from UI so no need for UI classes being passed to constructors
    DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    // to return the single instance of database
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    // to open the database
    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    //---insert a row into the database---
    public long insert(String location, String destination, String bus_number) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("location",location);
        contentValues.put("destination",destination);
        contentValues.put("bus_number",bus_number);
        return instance.openHelper.getWritableDatabase().insert("abuja",null,contentValues);
    }

    //delete a row in the database
    public long delete(String location, String destination, String bus_number) {
            return instance.openHelper.getWritableDatabase().delete("abuja","bus_number=?",
                    new String[]{bus_number});
        }

    // closing the database connection
    public void close() {
        if (db != null) {
            this.db.close();
        }
    }

    //to get the bus_number when location and destination are inputted and the search button is clicked
    public String getbus_number(String location, String destination) {
        // column names should be specifically location and destination not variables location and destination resolved
        c = db.rawQuery("Select bus_number from abuja where location =? AND destination =?",
                             new String[]{location, destination});

        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            String bus_number = c.getString(0);
            buffer.append(""+bus_number);
        }
        // Should always close the cursor
        c.close();
        return buffer.toString();
    }
}
