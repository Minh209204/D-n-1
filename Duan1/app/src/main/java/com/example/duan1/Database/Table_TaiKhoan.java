package com.example.duan1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.DataHelper.DataHelper;
import com.example.duan1.Model.Model_TaiKhoan;

import java.util.ArrayList;
import java.util.List;

public class Table_TaiKhoan {
    SQLiteDatabase db;
    DataHelper dataHelper;
    public Table_TaiKhoan(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }
    public boolean insert(Model_TaiKhoan taiKhoan){
        ContentValues values = new ContentValues();
        values.put("TAIKHOAN", taiKhoan.getTaiKhoan());
        values.put("MATKHAU", taiKhoan.getMatKhau());
        values.put("SDT", taiKhoan.getSDT());

        long result = db.insert("TAIKHOAN", null, values);
        Log.d("TAG", "insert: " + result);

        return result != -1;
    }

    public boolean delete(Model_TaiKhoan taiKhoan){
        String dieukien[] = new String[]{String.valueOf(taiKhoan.getMaTK())};

        long result = db.delete("TAIKHOAN", "MATK=?", dieukien);
        return result != -1;
    }

    public boolean update(Model_TaiKhoan taiKhoan){
        String dieukien[] = new String[]{String.valueOf(taiKhoan.getMaTK())};
        ContentValues values = new ContentValues();
        values.put("MATK", taiKhoan.getMaTK());
        values.put("TAIKHOAN", taiKhoan.getTaiKhoan());
        values.put("MATKHAU", taiKhoan.getMatKhau());
        values.put("SDT", taiKhoan.getSDT());

        long result = db.update("TAIKHOAN", values, "MATK=?", dieukien);

        return result != -1;
    }

    public List<Model_TaiKhoan> getAll(){
        List<Model_TaiKhoan> list = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM TAIKHOAN", null);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                Model_TaiKhoan khoan = new Model_TaiKhoan();

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

    public boolean checkAccount(Model_TaiKhoan khoan){
        String dieukien[] = new String[]{khoan.getTaiKhoan(), khoan.getMatKhau()};

        Cursor c = db.rawQuery("SELECT * FROM TAIKHOAN WHERE TAIKHOAN = ? AND MATKHAU = ?", dieukien);
        if (c.getCount() > 0){
            return true;
        }else {
            return false;
        }
    }

}
