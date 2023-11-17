package com.example.duan1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.DataHelper.DataHelper;
import com.example.duan1.Model.TaiKhoan;

import java.util.ArrayList;
import java.util.List;

public class Table_TaiKhoan {

    SQLiteDatabase db;
    DataHelper dataHelper;

    public Table_TaiKhoan(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }

    public boolean insert(TaiKhoan taiKhoan){
        ContentValues values = new ContentValues();
        values.put("MATK", taiKhoan.getMaTK());
        values.put("TAIKHOAN", taiKhoan.getTaiKhoan());
        values.put("MATKHAU", taiKhoan.getMatKhau());
        values.put("SDT", taiKhoan.getSDT());

        long result = db.insert("TAIKHOAN", null, values);
        return result != -1;
    }

    public boolean delete(TaiKhoan taiKhoan){
        String dieukien[] = new String[]{String.valueOf(taiKhoan.getMaTK())};

        long result = db.delete("TAIKHOAN", "MATK = ?", dieukien);
        return result != -1;
    }

    public boolean update(TaiKhoan taiKhoan){
        String dieukien[] = new String[]{String.valueOf(taiKhoan.getMaTK())};
        ContentValues values = new ContentValues();
        values.put("MATK", taiKhoan.getMaTK());
        values.put("TAIKHOAN", taiKhoan.getTaiKhoan());
        values.put("MATKHAU", taiKhoan.getMatKhau());
        values.put("SDT", taiKhoan.getSDT());

        long result = db.update("TAIKHOAN", values, "MATK = ?", dieukien);

        return result != -1;
    }

    public List<TaiKhoan> getAll(){
        List<TaiKhoan> list = new ArrayList<>();
        TaiKhoan khoan = new TaiKhoan();

        Cursor c = db.rawQuery("SELECT * FROM TAIKHOAN", null);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                int id = c.getInt(0);
                String taikhoan = c.getString(1);
                String matkhau = c.getString(2);
                String sdt = c.getString(3);

                khoan.setMaTK(id);
                khoan.setTaiKhoan(taikhoan);
                khoan.setMatKhau(matkhau);
                khoan.setSDT(sdt);

                list.add(khoan);
            }while (c.moveToNext());
        }
        return list;
    }

}
