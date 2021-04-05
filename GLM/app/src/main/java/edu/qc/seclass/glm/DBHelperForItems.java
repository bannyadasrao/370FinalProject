package edu.qc.seclass.glm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperForItems extends SQLiteOpenHelper {

    public static final String DB_TABLE = "ITEM_LIST";
    public static final String ID = "ID";
    public static final String NAME = "ITEM_NAME";
    public static final String CATEGORY = "ITEM_CATEGORY";

    private Context context;



    public DBHelperForItems(Context context){
        super(context, "Grocery" + NAME + "s.db", null, 1);
        this.context = context;

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + DB_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + CATEGORY + " TEXT)";
        //String createTableStatement = "CREATE TABLE ITEM_LIST (ID INTEGER PRIMARY KEY AUTOINCREMENT, ITEM_NAME TEXT, ITEM_CATEGORY TEXT)"
        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE);
        onCreate(db);
    }

   /* public boolean insertData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);

        long result = db.insert(DB_TABLE,null,contentValues);
        return result != -1; // if return -1, data won't insert.
    }*/
    public boolean insertData(String name, String category){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(CATEGORY, category);

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
