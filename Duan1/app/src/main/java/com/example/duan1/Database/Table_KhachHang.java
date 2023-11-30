package com.example.duan1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.DataHelper.DataHelper;
import com.example.duan1.Model.Model_KhachHang;

import java.util.ArrayList;
import java.util.List;

public class Table_KhachHang {
    SQLiteDatabase db;
    DataHelper dataHelper;
    public Table_KhachHang(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }
    public boolean insert(Model_KhachHang model_khachHang){
        ContentValues values = new ContentValues();
        values.put("TAIKHOAN", model_khachHang.getTaiKhoan());
        values.put("MATKHAU", model_khachHang.getMatKhau());
        values.put("TENKH", model_khachHang.getTenKH());
        values.put("SDTKH", model_khachHang.getSDTKH());
        values.put("ANHKH", model_khachHang.getAnhKH());
        values.put("DIACHIKH", model_khachHang.getDiaChiKH());

        long result = db.insert("KHACHHANG", null, values);
        Log.d("TAG", "insert: " + result);

        return result != -1;
    }

    public boolean delete(Model_KhachHang model_khachHang){
        String dieukien[] = new String[]{String.valueOf(model_khachHang.getMaKH())};

        long result = db.delete("KHACHHANG", "MAKH=?", dieukien);
        return result != -1;
    }

    public boolean update(Model_KhachHang model_khachHang){
        String dieukien[] = new String[]{String.valueOf(model_khachHang.getMaKH())};
        ContentValues values = new ContentValues();
        values.put("MAKH", model_khachHang.getMaKH());
        values.put("TAIKHOAN", model_khachHang.getTaiKhoan());
        values.put("MATKHAU", model_khachHang.getMatKhau());
        values.put("TENKH", model_khachHang.getTenKH());
        values.put("ANHKH", model_khachHang.getAnhKH());
        values.put("SDTKH", model_khachHang.getSDTKH());
        values.put("DIACHIKH", model_khachHang.getDiaChiKH());

        long result = db.update("KHACHHANG", values, "MAKH=?", dieukien);

        return result != -1;
    }

    public List<Model_KhachHang> getAll(){
        List<Model_KhachHang> list = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM KHACHHANG", null);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                Model_KhachHang khoan = new Model_KhachHang();

                int id = c.getInt(0);
                String taikhoan = c.getString(1);
                String matkhau = c.getString(2);
                String ten = c.getString(3);
                String anh = c.getString(4);
                String sdt = c.getString(5);
                String diachi = c.getString(6);

                khoan.setMaKH(id);
                khoan.setTaiKhoan(taikhoan);
                khoan.setMatKhau(matkhau);
                khoan.setTenKH(ten);
                khoan.setAnhKH(anh);
                khoan.setSDTKH(sdt);
                khoan.setDiaChiKH(diachi);

                list.add(khoan);
            }while (c.moveToNext());
        }
        return list;
    }

    public boolean checkAccount(Model_KhachHang model_khachHang){
        String dieukien[] = new String[]{model_khachHang.getTaiKhoan(), model_khachHang.getMatKhau()};

        Cursor c = db.rawQuery("SELECT * FROM KHACHHANG WHERE TAIKHOAN = ? AND MATKHAU = ?", dieukien);
        if (c.getCount() > 0){
            return true;
        }else {
            return false;
        }
    }

    public List<Model_KhachHang> checkID(Model_KhachHang model_khachHang){
        String dieukien[] = new String[]{model_khachHang.getTaiKhoan(), model_khachHang.getMatKhau()};
        List<Model_KhachHang> list = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM KHACHHANG WHERE TAIKHOAN = ? AND MATKHAU = ?", dieukien);
        c.moveToFirst();
        if (c.getCount() > 0){
            Model_KhachHang khoan = new Model_KhachHang();
            int id = c.getInt(0);
            String taikhoan = c.getString(1);
            String matkhau = c.getString(2);
            String ten = c.getString(3);

            khoan.setMaKH(id);
            khoan.setTaiKhoan(taikhoan);
            khoan.setMatKhau(matkhau);
            khoan.setTenKH(ten);

            list.add(khoan);
        }
        return list;
    }

}
