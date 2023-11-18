package com.example.duan1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.DataHelper.DataHelper;
import com.example.duan1.Model.SanPham;
import com.example.duan1.Model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class Table_TheLoai {
    SQLiteDatabase db;
    DataHelper dataHelper;

    public Table_TheLoai(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }

    public boolean insert(TheLoai theLoai){
        ContentValues values = new ContentValues();
        values.put("MATL", theLoai.getMaTL());
        values.put("TENTL", theLoai.getTenTl());

        long result = db.insert("THELOAI", null, values);

        return result != -1;
    }

    public boolean delete(TheLoai theLoai){
        String dieukien[] = new String[]{String.valueOf(theLoai.getMaTL())};

        long result = db.delete("THELOAI", "MATL=?", dieukien);
        return result != -1;
    }

    public boolean update(TheLoai theLoai){
        String dieukien[] = new String[]{String.valueOf(theLoai.getMaTL())};
        ContentValues values = new ContentValues();
        values.put("MATL", theLoai.getMaTL());
        values.put("TENTL", theLoai.getTenTl());

        long result = db.update("THELOAI", values, "MATL=?", dieukien);

        return result != -1;
    }

    public List<TheLoai> getAll(){
        List<TheLoai> list = new ArrayList<>();
        TheLoai loai = new TheLoai();

        Cursor c = db.rawQuery("SELECT * FROM TAIKHOAN", null);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                int id = c.getInt(0);


                list.add(loai);
            }while (c.moveToNext());
        }
        return list;
    }

}
