package com.example.andriod.habittraker.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.andriod.habittraker.Data.HabitContract.HabitsEntry;

import java.util.*;

public class HabitDbHelper extends SQLiteOpenHelper {

    public HabitDbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "habits.db";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + HabitsEntry.TABLE_NAME + " ("
                + HabitsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitsEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitsEntry.COLUMN_HABIT_DATE + " INTEGER NOT NULL, "
                + HabitsEntry.COLUMN_HABIT_STATUS + " INTEGER NOT NULL);";

        sqLiteDatabase.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertHabits() {

        Date currentTime = Calendar.getInstance().getTime();

        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitsEntry.COLUMN_HABIT_NAME, "Jogging");
        values.put(HabitsEntry.COLUMN_HABIT_DATE, String.valueOf(currentTime));
        values.put(HabitsEntry.COLUMN_HABIT_STATUS, HabitsEntry.STATUS_YES);

        long newRowId = db.insert(HabitsEntry.TABLE_NAME, null, values);
        if (newRowId == -1) {
            Log.v("error inserting", "not inserted");
        }
    }

    public Cursor readHabits() {

        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {HabitsEntry._ID, HabitsEntry.COLUMN_HABIT_NAME, HabitsEntry.COLUMN_HABIT_DATE, HabitsEntry.COLUMN_HABIT_STATUS};
        Cursor cursor = db.query(HabitsEntry.TABLE_NAME, projection, null, null, null, null, null);


        return cursor;
    }
}

