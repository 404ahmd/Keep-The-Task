package com.ahmadibrahim.keepthetask.Operations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ahmadibrahim.keepthetask.Database.DatabaseHelper;
import com.ahmadibrahim.keepthetask.Model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskOperations {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public TaskOperations(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    // create Task function
    public Task addTask(Task task){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_DATE, task.getDate());
        values.put(DatabaseHelper.COLUMN_COURSE, task.getCourse());
        values.put(DatabaseHelper.COLUMN_MEEETING, task.getMeeting());
        values.put(DatabaseHelper.COLUMN_DEADLINE, task.getDeadline());
        values.put(DatabaseHelper.COLUMN_STATUS, task.getStatus());

        long id = database.insert(DatabaseHelper.TABLE_NAME, null, values);
        task.setId((int) id);
        return task;
    }

    // read all task
    public List<Task> getTask(){
        List<Task> taskList = new ArrayList<>();
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                Task task = new Task();
                task.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID)));
                task.setDate(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DATE)));
                task.setCourse(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_COURSE)));
                task.setMeeting(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_MEEETING)));
                task.setDeadline(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DEADLINE)));
                task.setStatus(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_STATUS)));
                taskList.add(task);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return taskList;
    }

    // update task
    public int updateTask(Task task){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_DATE, task.getDate());
        values.put(DatabaseHelper.COLUMN_COURSE, task.getCourse());
        values.put(DatabaseHelper.COLUMN_MEEETING, task.getMeeting());
        values.put(DatabaseHelper.COLUMN_DEADLINE, task.getDeadline());
        values.put(DatabaseHelper.COLUMN_STATUS, task.getStatus());

        return database.update(
                DatabaseHelper.TABLE_NAME,
                values,
                DatabaseHelper.COLUMN_ID + " = ?",
                new String[]{String.valueOf(task.getId())}
        );
    }
}
