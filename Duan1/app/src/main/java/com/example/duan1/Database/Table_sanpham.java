package com.example.duan1.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.DataHelper.DataHelper;

public class Table_SanPham {

    SQLiteDatabase db;
    DataHelper dataHelper;

    public Table_SanPham(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }






}
