package com.example.duan1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.DataHelper.DataHelper;
import com.example.duan1.Model.Model_TheLoai;

import java.util.ArrayList;
import java.util.List;

public class Table_TheLoai {
    SQLiteDatabase db;
    DataHelper dataHelper;

    public Table_TheLoai(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }

    public boolean insert(Model_TheLoai theLoai){
        ContentValues values = new ContentValues();
        values.put("MATL", theLoai.getMaTL());
        values.put("TENTL", theLoai.getTenTL());

        long result = db.insert("THELOAI", null, values);

        return result != -1;
    }

    public boolean delete(Model_TheLoai theLoai){
        String dieukien[] = new String[]{String.valueOf(theLoai.getMaTL())};

        long result = db.delete("THELOAI", "MATL=?", dieukien);
        return result != -1;
    }

    public boolean update(Model_TheLoai theLoai){
        String dieukien[] = new String[]{String.valueOf(theLoai.getMaTL())};
        ContentValues values = new ContentValues();
        values.put("MATL", theLoai.getMaTL());
        values.put("TENTL", theLoai.getTenTL());

        long result = db.update("THELOAI", values, "MATL=?", dieukien);

        return result != -1;
    }

    public List<Model_TheLoai> getAll(){
        List<Model_TheLoai> list = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM THELOAI", null);
        c.moveToFirst();

        if (c.getCount() > 0){
            do {
                Model_TheLoai loai = new Model_TheLoai();
                int id = c.getInt(0);
                String tentl = c.getString(1);

                loai.setMaTL(id);
                loai.setTenTL(tentl);

                list.add(loai);

            }while (c.moveToNext());
        }
        return list;
    }

}
