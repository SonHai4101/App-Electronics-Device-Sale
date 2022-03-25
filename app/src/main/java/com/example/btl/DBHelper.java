package com.example.btl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;
    public static final String DATABASE_NAME = "Electronics Device Sale";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "product";
    public static final String COLUMN_ID = "p_id";
    public static final String COLUMN_NAME = "p_name";
    public static final String COLUMN_DESCRIBE = "p_describe";
    public static final String COLUMN_QUANTITY = "p_quantity";
    private HashMap hp;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME +
                "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + "TEXT, " +
                COLUMN_DESCRIBE + "TEXT, " +
                COLUMN_QUANTITY + "INTEGER" + ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PRODUCT");
        onCreate(sqLiteDatabase);
    }

    public boolean insertProduct(String name, String describe, int quantity) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p_name", name);
        contentValues.put("p_describe", describe);
        contentValues.put("p_quantity", quantity);
        sqLiteDatabase.insert("product", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from product where id =" + id + "", null);
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(sqLiteDatabase, "product");
        return numRows;
    }

    public boolean updateProduct(Integer id, String name, String describe, int quantity) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p_id", id);
        contentValues.put("p_name", name);
        contentValues.put("p_describe", describe);
        contentValues.put("p_quantity", quantity);
        sqLiteDatabase.update("product", contentValues, "id = ?", new String[]{Integer.toString(id)});
        return true;
    }

    public Integer delete(Integer id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete("product", "id = ?", new String[]{Integer.toString(id)});
    }

    public ArrayList<String> getAllProduct() {
        ArrayList<String> products = new ArrayList<String>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from product", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            products.add(res.getString(res.getColumnIndex(COLUMN_NAME)));
            res.moveToNext();
        }
        return products;
    }
}
