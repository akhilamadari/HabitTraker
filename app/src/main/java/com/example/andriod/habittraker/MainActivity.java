package com.example.andriod.habittraker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.andriod.habittraker.Data.HabitContract.HabitsEntry;
import com.example.andriod.habittraker.Data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {
    HabitDbHelper habitDbHelper = new HabitDbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       habitDbHelper.insertHabits();
       Cursor cursor = habitDbHelper.readHabits();
        try {

            int idColumnIndex     = cursor.getColumnIndex(HabitsEntry._ID);
            int nameColumnIndex   = cursor.getColumnIndex(HabitsEntry.COLUMN_HABIT_NAME);
            int dateColumnIndex  = cursor.getColumnIndex(HabitsEntry.COLUMN_HABIT_DATE);
            int statusColumnIndex = cursor.getColumnIndex(HabitsEntry.COLUMN_HABIT_STATUS);

             while (cursor.moveToNext()) {

            int currentID = cursor.getInt(idColumnIndex);
            String currentName = cursor.getString(nameColumnIndex);
            String currentdate = cursor.getString(dateColumnIndex);
            int currentstatus = cursor.getInt(statusColumnIndex);

            String st = "\n" + currentID + " - " + currentName + "-" + currentdate + "-" + currentstatus;
            Log.v("Database record", st);
             }

        } finally {

            cursor.close();
        }
    }

    }





