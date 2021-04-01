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

public class DBHelper extends SQLiteOpenHelper {

    public static final String GROCERY_ITEMS_TABLE = "Grocery_Items_Table";
    public static final String COLUMN_ITEM = "Item";
    public static final String COLUMN_ITEM_CATEGORY = "ItemCategory";
    private Context context;
    //IF NOT EXISTS
    public DBHelper(Context context) {
        super(context, "GroceryItems.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        String createTableStatement = "CREATE TABLE IF NOT EXISTS " + GROCERY_ITEMS_TABLE + " (" + COLUMN_ITEM + " TEXT primary key, " + COLUMN_ITEM_CATEGORY + " Text)";
        DB.execSQL(createTableStatement);

        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Coca Cola', 'Beverages')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Tropicana Orange juice', 'Beverages')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Pepsi', 'Beverages')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Fiji water', 'Beverages')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Snapple', 'Beverages')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Cereals', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Lucky Charms', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Black Beans', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Red Beans', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Goya Beans', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Shell Pasta', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Bowtie Pasta', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('penne pasta', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Rotini Pasta', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Coffeee', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Tea', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Lipton Tea', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Green Tea,', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Travis Scott Reesses Puffs', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Instant Noodles', 'Dry Goods')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Chicken', 'Meat/ Poultry/ Fish/ Egg')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Egg', 'Meat/ Poultry/ Fish/ Egg')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Salmon', 'Meat/ Poultry/ Fish/ Egg')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Sausage', 'Meat/ Poultry/ Fish/ Egg')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Pork', 'Meat/ Poultry/ Fish/ Egg')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Beef', 'Meat/ Poultry/ Fish/ Egg')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Crossiant', 'Bakery')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Cake', 'Bakery')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Oreos', 'Bakery')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Baguette', 'Bakery')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Donuts', 'Bakery')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('UTZ', 'Snacks')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Takis', 'Snacks')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Flamin hot Cheetos', 'Snacks')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Doritos', 'Snacks')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Nuts', 'Snacks')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Hershey', 'Snacks')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Ferrero Rocher', 'Snacks')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Tomatoes', 'Produce')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Oranges', 'Produce')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Carrots', 'Produce')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Apples', 'Produce')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Potatos', 'Produce')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Cherries', 'Produce')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Papaya', 'Produce')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Cheese', 'Dairy')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Milk', 'Dairy')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Yogurt', 'Dairy')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Cream', 'Dairy')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Butter', 'Dairy')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Whipped Cream ', 'Dairy')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Wine', 'Alcohol')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Soju', 'Alcohol')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Clorox', 'Cleaning Products')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Bounty', 'Cleaning Products')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Paper Towels', 'Cleaning Products')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Windex', 'Cleaning Products')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Dish Washing Soap', 'Cleaning Products')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Shampoo', 'Personal Care')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Conditoner', 'Personal Care')");
        DB.execSQL("INSERT INTO " + GROCERY_ITEMS_TABLE + "(" + COLUMN_ITEM + "," + COLUMN_ITEM_CATEGORY + ") values('Soap', 'Personal Care')");


    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists GROCERY_ITEMS_TABLE");
        onCreate(DB);
    }

    public void insertGroceryItem (String itemName, String CategoryName){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ITEM, itemName);
        contentValues.put(COLUMN_ITEM_CATEGORY, CategoryName);
        DB.insert(GROCERY_ITEMS_TABLE , null, contentValues);
        long result = DB.insert(GROCERY_ITEMS_TABLE,null,contentValues);
        if (result == -1){
            Toast.makeText(context,"Failed!",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"Added Successfully!",Toast.LENGTH_SHORT).show();
        }
    }
     /*
    public void insertGroceryItem(String itemName, String itemCategory){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ITEM,itemName);
        contentValues.put(COLUMN_ITEM_CATEGORY,itemCategory);

        long result = DB.insert(GROCERY_ITEMS_TABLE,null,contentValues);
        if (result == -1){
            Toast.makeText(context,"Failed!",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"Added Successfully!",Toast.LENGTH_SHORT).show();
        }
    }

      */
    public void UpdateCategory (String itemName, String CategoryName){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ITEM_CATEGORY, CategoryName);
       DB.update(GROCERY_ITEMS_TABLE, contentValues, "Item=?", new String[]{itemName});
       // long result =   DB.update(GROCERY_ITEMS_TABLE, contentValues, COLUMN_ITEM, new String[]{itemName});
        return;
    }
    public void DeleteGroceryItem (String itemName){
        SQLiteDatabase DB = this.getWritableDatabase();
        String queryString = " DELETE FROM " + GROCERY_ITEMS_TABLE + " WHERE " + COLUMN_ITEM + " = " + itemName;
       Cursor cursor = DB.rawQuery(queryString, null);
        return;
    }
    public List<String> getItemsForCategory(String CategoryName){
        List<String> returnList = new ArrayList<String>();
        String queryString = "SELECT * FROM " + GROCERY_ITEMS_TABLE + " WHERE " + COLUMN_ITEM_CATEGORY + " = " + CategoryName;
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            // if there are results loop through the results
            do{
                String itemName = cursor.getString(0);
                String itemCategory = cursor.getString(1);
                String result = itemName + " " + itemCategory + " ";
                returnList.add(result);
            }while(cursor.moveToNext());

        }else{
            // No item found under the category return nothing.
        }
        return returnList;
    }

    public List<String> getEveryone(){
        List<String> returnList = new ArrayList<String>();
        String queryString = "SELECT * FROM " + GROCERY_ITEMS_TABLE;
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            // if there are results loop through the results
            do{
                String itemName = cursor.getString(0);
                String itemCategory = cursor.getString(1);
                String result = itemName + " " + itemCategory + " ";
                returnList.add(result);
            }while(cursor.moveToNext());

        }else{
            // No item found under the category return nothing.
        }
        return returnList;
    }
}