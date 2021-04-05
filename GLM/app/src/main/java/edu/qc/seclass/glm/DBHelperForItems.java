package edu.qc.seclass.glm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperForItems extends SQLiteOpenHelper {

    private static final String DB_NAME = "GroceryItem.db";
    private static final String DB_TABLE = "ITEM_LIST";

    private static final String ID = "ID";
    private static final String NAME = "ITEM_NAME";
//    private static final String CATEGORY = "ITEM_CATEGORY";

    private static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE+" ("+
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NAME+ " TEXT "+ ")";

    public DBHelperForItems(Context context){
        super(context,DB_NAME,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE);
        onCreate(db);
    }

    public boolean insertData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);

        long result = db.insert(DB_TABLE,null,contentValues);
        return result != -1; // if return -1, data won't insert.
    }

    public  Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from " + DB_TABLE;
        Cursor cursor =  db.rawQuery(query,null);

        return cursor;
    }

    public Cursor searchItems(String items){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from " + DB_TABLE+" WHERE "+NAME+" Like '%"+items+"%'";
        Cursor cursor = db.rawQuery(query,null);

        return cursor;
    }
}
