package com.e.management.ui.addexpence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class SqliteHelper extends SQLiteOpenHelper {

    public SqliteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String type, String expense, String quantity, String time, String date) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "INSERT INTO Expense VALUES (?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1, type);
        sqLiteStatement.bindString(2, expense);
        sqLiteStatement.bindString(3, quantity);
        sqLiteStatement.bindString(4, time);
        sqLiteStatement.bindString(5, date);

        sqLiteStatement.executeInsert();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
