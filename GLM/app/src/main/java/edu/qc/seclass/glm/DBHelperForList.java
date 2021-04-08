package edu.qc.seclass.glm;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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
        DB.insert(USER_LIST , null, contentValues);
    }

    public void UpdateListName(String oldListName, String newListName){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_LIST_NAME, newListName);
        long result =   DB.update(USER_LIST, contentValues, COLUMN_LIST_NAME + "=?", new String[]{oldListName});

        return;
    }

    public void DeleteList (String listName){
        SQLiteDatabase DB = this.getWritableDatabase();
         int result = DB.delete(USER_LIST, COLUMN_LIST_NAME + "=?", new String[]{listName});
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

