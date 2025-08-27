package com.ahmadibrahim.keepthetask.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_tugas";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "tugas";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_COURSE = "course";
    public static final String COLUMN_MEEETING = "meeting";
    public static final String COLUMN_DEADLINE = "deadline";
    public static final String COLUMN_STATUS = "status";

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_DATE + " TEXT NOT NULL, " +
            COLUMN_COURSE + " TEXT NOT NULL, " +
            COLUMN_MEEETING + " TEXT NOT NULL, " +
            COLUMN_DEADLINE + " TEXT NOT NULL, " +
            COLUMN_STATUS + " TEXT NOT NULL )";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
