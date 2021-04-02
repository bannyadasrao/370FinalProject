package edu.qc.seclass.glm;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelperForList extends SQLiteOpenHelper {
    public static final String USER_LIST = "USER_LIST";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_LIST_NAME = "LIST_NAME";
    private Context context;

    public DBHelperForList(Context context) {
        super(context, "GroceryList.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        String createTableStatement = "CREATE TABLE IF NOT EXISTS " + USER_LIST + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_LIST_NAME + " TEXT)";
        DB.execSQL(createTableStatement);
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists " + USER_LIST);
        onCreate(DB);
    }

    public void insertUserList (String ListName){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_LIST_NAME, ListName);
        long result =  DB.insert(USER_LIST , null, contentValues);
        if (result == -1){
            Toast.makeText(context,"Failed!",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"Added Successfully!",Toast.LENGTH_SHORT).show();
        }
    }

    public void UpdateListName(String oldListName, String newListName){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_LIST_NAME, newListName);
        long result =   DB.update(USER_LIST, contentValues, COLUMN_LIST_NAME + "=?", new String[]{oldListName});
        if (result == -1){
            Toast.makeText(context,"Failed!",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"Updated Successfully!",Toast.LENGTH_SHORT).show();
        }

        return;
    }

    public void DeleteList (String listName){
        SQLiteDatabase DB = this.getWritableDatabase();
        String queryString = " DELETE FROM " + USER_LIST + " WHERE " + COLUMN_LIST_NAME + " = " + listName;
        Cursor cursor = DB.rawQuery(queryString, null);
        return;
    }
    public void DeleteAllList (){
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.execSQL("delete from "+ USER_LIST);
        DB.close();
        return;
    }

    public List<String> getAllList(){
        List<String> returnList = new ArrayList<String>();
        String queryString = "SELECT * FROM " + USER_LIST;
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            do{
                String listName = cursor.getString(1);
                returnList.add(listName);
            }while(cursor.moveToNext());

        }else{
        }

        cursor.close();
        DB.close();
        return returnList;

    }
}
// parameter of the constructor list name,



