package edu.qc.seclass.glm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelpeForCheckboxAndQuantity extends SQLiteOpenHelper {

    Context context;

    private static final String DB_NAME = "checkboxQuantity";
    private static final String TABLE_NAME = "CheckboxAndQuantity";
    private static final int DB_VERSION = 1;

    private SQLiteDatabase sqLiteDatabase;

    //Table columns
    public static  final String ID = "id";
    public static  final String NAME = "name";
    public static  final String QUANTITY = "quantity";
    public static  final String LISTNAME = "listname";

    public DBHelpeForCheckboxAndQuantity(@Nullable Context context) {
        super(context, "checkboxQuantity.db" , null, DB_VERSION);
    }

    private static final String createforcheckboxandquantity = "create table " +
            TABLE_NAME +"("+
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            NAME + " TEXT NOT NULL," +
            QUANTITY +" TEXT NOT NULL," +
            LISTNAME +" TEXT NOT NULL);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createforcheckboxandquantity);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add item name and quantity to Database
    public void addNameAndQuantity(ItemsModal itemsModal){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelpeForCheckboxAndQuantity.NAME,itemsModal.getItemName());
        contentValues.put(DBHelpeForCheckboxAndQuantity.QUANTITY,itemsModal.getAmountOfQuantity());
        contentValues.put(DBHelpeForCheckboxAndQuantity.LISTNAME,itemsModal.getList());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DBHelpeForCheckboxAndQuantity.TABLE_NAME,null,contentValues);
    }

    public void updateQuantity(int id, String quantity){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUANTITY, quantity);
        DB.update(TABLE_NAME, contentValues, ID + " = ? " ,
                new String[]{String.valueOf(id)});
        return;
    }


    public List<ItemsModal> getAllItemWithQuantity(String listName){

        sqLiteDatabase =  this.getReadableDatabase();
        List<ItemsModal> storeItems = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from CheckboxAndQuantity where listname = ?",new String[]{listName});
       // Cursor cursor = sqLiteDatabase.rawQuery(result,null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String itemName = cursor.getString(1);
                String amountOfQuantity = cursor.getString(2);
                storeItems.add(new ItemsModal(id,itemName,amountOfQuantity));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return storeItems;
    }


    public void DeleteAllListItems (String nameOfListToDeleteItemsOf){
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.execSQL("delete from CheckboxAndQuantity where listname = ?",new String[]{nameOfListToDeleteItemsOf});
        DB.close();
        return;
    }

    public void DeleteAllEntry (){
        SQLiteDatabase DB = this.getWritableDatabase();
       DB.delete(TABLE_NAME, null, null);
      DB.close();

    }

    public void UpdateListNameAfterRename(String oldListName, String newListName){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LISTNAME, newListName);
        long result = DB.update(TABLE_NAME, contentValues, LISTNAME + "=?", new String[]{oldListName});
        return;

    }

    public void deleteOneRow(int row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, " id=?", new String[]{String.valueOf(row_id)});
        if(result == -1){
            Toast.makeText(context,"Failed to delete.",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Successfully deleted.",Toast.LENGTH_SHORT).show();
        }
    }

}











