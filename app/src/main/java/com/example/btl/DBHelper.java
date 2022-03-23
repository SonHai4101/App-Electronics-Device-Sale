package com.example.btl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;
    public static final String DATABASE_NAME = "Electronics Device Sale";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "product";
    public static final String COLUMN_ID = "p_id";
    public static final String COLUMN_NAME = "p_name";
    public static final String COLUMN_PARAMETER = "p_parameter";
    public static final String COLUMN_QUANTITY = "p_quantity";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE" + TABLE_NAME +
                "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + "TEXT, " +
                COLUMN_PARAMETER + "TEXT, " +
                COLUMN_QUANTITY + "INTEGER";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int newVersion) {

    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from product where id =" + id + "", null);
        return  res;
    }
}
