package com.example.eeping.ticktask.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ee Ping on 7/21/2017.
 */

public class TaskDBHelper extends SQLiteOpenHelper {

    public TaskDBHelper(Context context) {
        super(context, TaskConnection.DB_NAME, null, TaskConnection.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TaskConnection.TaskRecord.TABLE + " ( " +
                TaskConnection.TaskRecord._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TaskConnection.TaskRecord.COL_TASK_TITLE + " TEXT NOT NULL);";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TaskConnection.TaskRecord.TABLE);
        onCreate(db);
    }
}
