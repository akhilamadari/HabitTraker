package com.example.andriod.habittraker.Data;

import android.provider.BaseColumns;

/**
 * Created by akhilamadari on 1/29/18.
 */

public class HabitContract {
    public static abstract class HabitsEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_DATE = "date";
        public static final String COLUMN_HABIT_STATUS = "status";

        /**
         * Possible values for the tracking habit which is done on the date or not
         */
        public static final int STATUS_NO = 0;
        public static final int STATUS_YES = 1;


    }
}
