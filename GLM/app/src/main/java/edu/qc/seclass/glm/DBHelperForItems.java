package edu.qc.seclass.glm;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelperForItems extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    private static  final String TABLE_NAME = "GROCERY_ITEM_TABLE";
    private static  final String COL_ID = "ID";
    private static  final String COL_ITEM = "ITEM";
    private static  final String COL_ITEM_CATEGORY = "ITEMCATEGORY";
    private static final String  COL_STATUS = "STATUS";

    public DBHelperForItems(@Nullable Context context ) {
        super(context, "GroceryItems.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , ITEM TEXT , CATEGORY TEXT,  STATUS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertItem(ToDoModel model){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ITEM , model.getItem());
        values.put(COL_STATUS , 0);
        db.insert(TABLE_NAME , null , values);
    }

    public void insertCategory(ToDoModel model){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_CATEGORY, model.getCategory());
        values.put(COL_STATUS , 0);
        db.insert(TABLE_NAME , null , values);
    }

    public void updateItem(int id , String item){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ITEM , item);
        db.update(TABLE_NAME , values , "ID=?" , new String[]{String.valueOf(id)});
    }

    public void updateCategory(int id , String category){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_CATEGORY , category);
        db.update(TABLE_NAME , values , "ID=?" , new String[]{String.valueOf(id)});
    }

    public void updateStatus(int id , int status){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_STATUS , status);
        db.update(TABLE_NAME , values , "ID=?" , new String[]{String.valueOf(id)});
    }

    public void deleteITEM(int id ){
        db = this.getWritableDatabase();
        db.delete(TABLE_NAME , "ID=?" , new String[]{String.valueOf(id)});
    }

    public List<ToDoModel> getAllITEMS(){

        db = this.getWritableDatabase();
        Cursor cursor = null;
        List<ToDoModel> modelList = new ArrayList<>();

        db.beginTransaction();
        try {
            cursor = db.query(TABLE_NAME , null , null , null , null , null , null);
            if (cursor !=null){
                if (cursor.moveToFirst()){
                    do {
                        ToDoModel task = new ToDoModel();
                        task.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
                        task.setItem(cursor.getString(cursor.getColumnIndex(COL_ITEM)));
                        task.setCategory(cursor.getString(cursor.getColumnIndex(COL_ITEM_CATEGORY)));
                        task.setStatus(cursor.getInt(cursor.getColumnIndex(COL_STATUS)));
                        modelList.add(task);

                    }while (cursor.moveToNext());
                }
            }
        }finally {
            db.endTransaction();
            cursor.close();
        }
        return modelList;
    }

    public void DeleteAllItems (){
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.execSQL("delete from "+ "GroceryItems.db");
        DB.close();
        return;
    }

}