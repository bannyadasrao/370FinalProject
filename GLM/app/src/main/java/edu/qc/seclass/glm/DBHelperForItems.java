package edu.qc.seclass.glm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelperForItems extends SQLiteOpenHelper {

    public static final String DB_NAME = "GroceryItem.db";
    public static final String DB_TABLE = "ITEM_LIST";
    public static final String ID = "ID";
    public static final String NAME = "ITEM_NAME";
    public static final String CATEGORY = "ITEM_CATEGORY";
    //private SQLiteDatabase db = this.getReadableDatabase();
     //db = this.getReadableDatabase();
    private Context context;

    public DBHelperForItems(Context context){
        super(context, DB_NAME, null, 1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + DB_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + CATEGORY + " TEXT)";
        db.execSQL(createTableStatement);

        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Strawberries','Fruits')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Blueberries','Fruits')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Papaya','Fruits')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Watermelon','Fruits')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Cherries','Fruits')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Oranges','Fruits')");

        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Chicken', 'Meat')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Sausage','Meat')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Beef','Meat')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Pork','Meat')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Duck','Meat')");

        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Cheese','Dairy')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Milk','Dairy')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Yogurt','Dairy')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Cream','Dairy')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Butter','Dairy')");

        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Tomatoes','Vegetable')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Carrots','Vegetable')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Potatos','Vegetable')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Broccoli','Vegetable')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Cucumber','Vegetable')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Eggplant','Vegetable')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Spring Onions','Vegetable')");

        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Crossiant','Bakery')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Cake','Bakery')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Oreos','Bakery')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Donuts','Bakery')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Baguette','Bakery')");

        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('UTZ','Snack')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Takis','Snack')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Flamin hot Cheetos','Snack')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Doritos','Snack')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Nuts','Snack')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Hershey','Snack')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Ferrero Rocher','Snack')");

        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Coca Cola','Beverage')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Tropicana Orange juice','Beverage')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Pepsi','Beverage')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Fiji water','Beverage')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Snapple','Beverage')");

        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Clorox','Cleaning')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Bounty','Cleaning')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Paper Towels','Cleaning')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Dish Washing Soap','Cleaning')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Windex','Cleaning')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Tissues','Cleaning')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Charmin','Cleaning')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Garbage Bags','Cleaning')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Broom','Cleaning')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Dustpan','Cleaning')");

        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Shampoo','Hygiene')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Body Wash','Hygiene')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Soap','Hygiene')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Conditioner','Hygiene')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Face Wash','Hygiene')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Mouth Wash','Hygiene')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Toothpaste','Hygiene')");

        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Baby Powder','Others')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Shoes','Others')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Fork','Others')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Ipad','Others')");
        db.execSQL("INSERT INTO " + DB_TABLE + "(" + NAME + "," + CATEGORY + ") VALUES ('Cup','Others')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE);
        onCreate(db);
    }

    public boolean insertData(String name, String category){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(CATEGORY, category);

        long result = db.insert(DB_TABLE,null,contentValues);
        return result != -1;
    }

    public List<String> getAllItems(){
        List<String> returnList = new ArrayList<String>();
        String queryString = "SELECT * FROM " + DB_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            do{
                String item = cursor.getString(1);
                returnList.add(item);
            }while(cursor.moveToNext());

        }else{

        }
        cursor.close();
        db.close();
        return returnList;
    }

    public ArrayList<String> getItemsForMeat() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + DB_TABLE + " WHERE " + CATEGORY + " = 'Meat'" ;
        Cursor c = db.rawQuery(selectQuery, null);
        ArrayList<String> groceryListItems = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                String item = c.getString(1);

                groceryListItems.add(item);
            } while(c.moveToNext());
        }
        c.close();
        return groceryListItems;
    }

    public ArrayList<String> getItemsForVegetable() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + DB_TABLE + " WHERE " + CATEGORY + " = 'Vegetable'" ;
        Cursor c = db.rawQuery(selectQuery, null);
        ArrayList<String> groceryListItems = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                String item = c.getString(1);

                groceryListItems.add(item);
            } while(c.moveToNext());
        }
        c.close();
        return groceryListItems;
    }

    public ArrayList<String> getItemsForBakery() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + DB_TABLE + " WHERE " + CATEGORY + " = 'Bakery'" ;
        Cursor c = db.rawQuery(selectQuery, null);
        ArrayList<String> groceryListItems = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                String item = c.getString(1);

                groceryListItems.add(item);
            } while(c.moveToNext());
        }
        c.close();
        return groceryListItems;
    }

    public ArrayList<String> getItemsForDairy() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + DB_TABLE + " WHERE " + CATEGORY + " = 'Dairy'" ;
        Cursor c = db.rawQuery(selectQuery, null);
        ArrayList<String> groceryListItems = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                String item = c.getString(1);

                groceryListItems.add(item);
            } while(c.moveToNext());
        }
        c.close();
        return groceryListItems;
    }

    public ArrayList<String> getItemsForFruit() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + DB_TABLE + " WHERE " + CATEGORY + " = 'Fruits'" ;
        Cursor c = db.rawQuery(selectQuery, null);
        ArrayList<String> groceryListItems = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                String item = c.getString(1);

                groceryListItems.add(item);
            } while(c.moveToNext());
        }
        c.close();
        return groceryListItems;
    }

    public ArrayList<String> getItemsForSnack() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + DB_TABLE + " WHERE " + CATEGORY + " = 'Snack'" ;
        Cursor c = db.rawQuery(selectQuery, null);
        ArrayList<String> groceryListItems = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                String item = c.getString(1);

                groceryListItems.add(item);
            } while(c.moveToNext());
        }
        c.close();
        return groceryListItems;
    }

    public ArrayList<String> getItemsForBeverage() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + DB_TABLE + " WHERE " + CATEGORY + " = 'Beverage'" ;
        Cursor c = db.rawQuery(selectQuery, null);
        ArrayList<String> groceryListItems = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                String item = c.getString(1);

                groceryListItems.add(item);
            } while(c.moveToNext());
        }
        c.close();
        return groceryListItems;
    }

    public ArrayList<String> getItemsForCleaning() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + DB_TABLE + " WHERE " + CATEGORY + " = 'Cleaning'" ;
        Cursor c = db.rawQuery(selectQuery, null);
        ArrayList<String> groceryListItems = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                String item = c.getString(1);

                groceryListItems.add(item);
            } while(c.moveToNext());
        }
        c.close();
        return groceryListItems;
    }

    public ArrayList<String> getItemsForHygiene() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + DB_TABLE + " WHERE " + CATEGORY + " = 'Hygiene'" ;
        Cursor c = db.rawQuery(selectQuery, null);
        ArrayList<String> groceryListItems = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                String item = c.getString(1);

                groceryListItems.add(item);
            } while(c.moveToNext());
        }
        c.close();
        return groceryListItems;
    }

    public ArrayList<String> getItemsForOthers() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + DB_TABLE + " WHERE " + CATEGORY + " = 'Others'" ;
        Cursor c = db.rawQuery(selectQuery, null);
        ArrayList<String> groceryListItems = new ArrayList<>();
        if (c.moveToFirst()){
            do {
                String item = c.getString(1);

                groceryListItems.add(item);
            } while(c.moveToNext());
        }
        c.close();
        return groceryListItems;
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


    public boolean isItemAleadyExists(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+DB_TABLE+" WHERE "+NAME+"=?" , new String[] {name});
        boolean exists = c.getCount() > 0;
        c.close();
        return exists;
    }
}
