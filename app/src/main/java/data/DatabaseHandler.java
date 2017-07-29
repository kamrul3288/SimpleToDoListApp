package data;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.NavUtils;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper{

    //------ TODO DATA HOLDING ARRAY LIST
    private ArrayList<ToDoList> toDoLists = new ArrayList<>();

    public DatabaseHandler(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO: create table
        String CREATE_DATABASE = " CREATE TABLE " + Constants.TABLE_NAME + " ( "+ Constants.TASK_NAME + " TEXT, "
                + Constants.TASK_DESCRIPTION + " TEXT, " + Constants.TASK_DATE_TIME + " TEXT, " + Constants.KEY_ID + " TEXT);";
        db.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*--- don't create database if exit*/
        db.execSQL(" DROP TABLE IF EXIT " + Constants.TABLE_NAME);
        onCreate(db);
    }

    // ---- ADD DATA IN DATABASE
    public void addTaskOnDb(ToDoList list){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.TASK_NAME,list.getTaskName());
        values.put(Constants.TASK_DESCRIPTION,list.getTaskDescription());
        values.put(Constants.TASK_DATE_TIME,list.getTimeAndDateText());

        sqLiteDatabase.insert(Constants.TABLE_NAME,null,values);
        sqLiteDatabase.close();
    }

    //------ GET DATA FROM DATABASE-----
    public ArrayList<ToDoList> getToDoData(){

        toDoLists.clear();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        /*---- navigate to cursor like mouse cursor----*/
        Cursor cursor = sqLiteDatabase.query(Constants.TABLE_NAME, new String[]{Constants.TASK_NAME, Constants.TASK_DESCRIPTION, Constants.TASK_DATE_TIME, Constants.KEY_ID}, null,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                ToDoList list = new ToDoList();
                list.setTaskName(cursor.getString(cursor.getColumnIndex(Constants.TASK_NAME)));
                list.setTaskDescription(cursor.getString(cursor.getColumnIndex(Constants.TASK_DESCRIPTION)));
                list.setTimeAndDateText(cursor.getString(cursor.getColumnIndex(Constants.TASK_DATE_TIME)));
                toDoLists.add(list);
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        cursor.close();
        return toDoLists;
    }
}
