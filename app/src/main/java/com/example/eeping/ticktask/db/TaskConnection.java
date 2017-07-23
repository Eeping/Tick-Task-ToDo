package com.example.eeping.ticktask.db;

import android.provider.BaseColumns;

/**
 * Created by Ee Ping on 7/21/2017.
 */

public class TaskConnection {
    public static final String DB_NAME = "com.example.eeping.ticktask.db";
    public static final int DB_VERSION = 1;

    public class TaskRecord implements BaseColumns {
        public static final String TABLE = "tasks";

        public static final String COL_TASK_TITLE = "title";
    }
}

