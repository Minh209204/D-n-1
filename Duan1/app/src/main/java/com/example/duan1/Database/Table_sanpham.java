package com.example.duan1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.DataHelper.DataHelper;

import java.util.ArrayList;
import java.util.List;

public class Table_sanpham{

    SQLiteDatabase db;
    DataHelper dataHelper;

    public Table_sanpham(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }






}
