package com.example.todsapon.sellproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by todsapon on 3/18/2016 AD.
 */
public class MyDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "this_way";
    public static final int DB_VERSION = 1;
    public static final String TABLE_PRODUCT = "table_product";
    public static final String COL_PRODUCT_ID = "product_id";
    public static final String COL_PRODUCT_NAME = "product_name";
    public static final String COL_PRICE = "price";


    public static final String TABLE_ODER = "table_oder";
    public static final String COL_ODER_ID = "oder_id";
    public static final String COL_ODER_NUMBER = "oder_number";





    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_PRODUCT
                + " (" + COL_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_PRODUCT_NAME + " TEXT(50) NOT NULL, "
                + COL_PRICE + " INTEGER NOT NULL);");


        db.execSQL("CREATE TABLE " + TABLE_ODER
                + " (" + COL_ODER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_PRODUCT_NAME + " TEXT(50) NOT NULL, "
                + COL_ODER_NUMBER + " TEXT(50) NOT NULL, "
                + COL_PRODUCT_NAME + " TEXT(50) NOT NULL, "
                + COL_PRICE + " INTEGER NOT NULL);");

        db.execSQL("INSERT INTO " + TABLE_PRODUCT + " ("
                + COL_PRODUCT_NAME + ", "
                + COL_PRICE + ") VALUES ("
                + "'Lemonade',"
                + "500);");

        db.execSQL("INSERT INTO " + TABLE_PRODUCT + " ("
                + COL_PRODUCT_NAME + ", "
                + COL_PRICE + ") VALUES ("
                + "'Orange juice',"
                + "500);");

        db.execSQL("INSERT INTO " + TABLE_PRODUCT + " ("
                + COL_PRODUCT_NAME + ", "
                + COL_PRICE + ") VALUES ("
                + "'Coconut juice',"
                + "650);");

        db.execSQL("INSERT INTO " + TABLE_PRODUCT + " ("
                + COL_PRODUCT_NAME + ", "
                + COL_PRICE + ") VALUES ("
                + "'Watermelon juice',"
                + "600);");

        db.execSQL("INSERT INTO " + TABLE_PRODUCT + " ("
                + COL_PRODUCT_NAME + ", "
                + COL_PRICE + ") VALUES ("
                + "'Pineapple juice',"
                + "500);");

        db.execSQL("INSERT INTO " + TABLE_PRODUCT + " ("
                + COL_PRODUCT_NAME + ", "
                + COL_PRICE + ") VALUES ("
                + "'Grape juice',"
                + "550);");

        db.execSQL("INSERT INTO " + TABLE_PRODUCT + " ("
                + COL_PRODUCT_NAME + ", "
                + COL_PRICE + ") VALUES ("
                + "'Tomato juice',"
                + "600);");

        db.execSQL("INSERT INTO " + TABLE_PRODUCT + " ("
                + COL_PRODUCT_NAME + ", "
                + COL_PRICE + ") VALUES ("
                + "'Melon juice',"
                + "600);");

        db.execSQL("INSERT INTO " + TABLE_PRODUCT + " ("
                + COL_PRODUCT_NAME + ", "
                + COL_PRICE + ") VALUES ("
                + "'Spinach juice',"
                + "450);");

        db.execSQL("INSERT INTO " + TABLE_PRODUCT + " ("
                + COL_PRODUCT_NAME + ", "
                + COL_PRICE + ") VALUES ("
                + "'Lychee Juice',"
                + "500);");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        onCreate(db);
    }
}
