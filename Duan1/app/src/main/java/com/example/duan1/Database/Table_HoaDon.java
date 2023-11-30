package com.example.duan1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.DataHelper.DataHelper;
import com.example.duan1.Model.Model_HoaDon;
import com.example.duan1.Model.Model_SanPham;

import java.util.ArrayList;
import java.util.List;

public class Table_HoaDon {

    DataHelper dataHelper;
    SQLiteDatabase db;

    public Table_HoaDon(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }

    public boolean insert(Model_HoaDon hoaDon){
        ContentValues values = new ContentValues();
        values.put("MAKH", hoaDon.getMaKH());
        values.put("MASP", hoaDon.getMaSP());
        values.put("TENKH", hoaDon.getTenKH());
        values.put("SDTKH", hoaDon.getSDT());
        values.put("ANHSP", hoaDon.getAnhSP());
        values.put("TENSP", hoaDon.getTenSP());
        values.put("GIASP", hoaDon.getGiaSP());
        values.put("SOLUONGSP", hoaDon.getSoLuongSP());
        values.put("TONGTIEN", hoaDon.getTongTien());
        values.put("DIACHIKH", hoaDon.getDiaChiKH());

        long result = db.insert("HOADON", null, values);

        return result != -1;
    }

    public boolean delete(Model_HoaDon hoaDon){
        String dieukien[] = new String[]{String.valueOf(hoaDon.getMaHD())};

        long result = db.delete("HOADON", "MAHD=?", dieukien);
        return result != -1;
    }

    public boolean update(Model_HoaDon hoaDon){
        String dieukien[] = new String[]{String.valueOf(hoaDon.getMaHD())};
        ContentValues values = new ContentValues();
        values.put("MAKH", hoaDon.getMaKH());
        values.put("MASP", hoaDon.getMaSP());
        values.put("TENKH", hoaDon.getTenKH());
        values.put("SDTKH", hoaDon.getSDT());
        values.put("ANHSP", hoaDon.getAnhSP());
        values.put("TENSP", hoaDon.getTenSP());
        values.put("GIASP", hoaDon.getGiaSP());
        values.put("SOLUONGSP", hoaDon.getSoLuongSP());
        values.put("TONGTIEN", hoaDon.getTongTien());
        values.put("DIACHIKH", hoaDon.getDiaChiKH());

        long result = db.update("HOADON", values, "MAHD=?", dieukien);
        return result != -1;
    }

    public List<Model_HoaDon> getAll(){
        List<Model_HoaDon> list = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM HOADON", null);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                Model_HoaDon hoaDon = new Model_HoaDon();
                int mahd = c.getInt(0);
                int magh = c.getInt(1);
                int makh = c.getInt(2);
                int masp = c.getInt(3);
                String tenkh = c.getString(4);
                int sdt = c.getInt(5);
                String anhsp = c.getString(6);
                String tensp = c.getString(7);
                int giasp = c.getInt(8);
                int soluong = c.getInt(9);
                int tongtien = c.getInt(10);
                String diachi = c.getString(11);

                hoaDon.setMaHD(mahd);
                hoaDon.setMaGH(magh);
                hoaDon.setMaSP(masp);
                hoaDon.setMaKH(makh);
                hoaDon.setTenKH(tenkh);
                hoaDon.setSDT(sdt);
                hoaDon.setTenSP(tensp);
                hoaDon.setAnhSP(anhsp);
                hoaDon.setGiaSP(giasp);
                hoaDon.setSoLuongSP(soluong);
                hoaDon.setTongTien(tongtien);
                hoaDon.setDiaChiKH(diachi);

                list.add(hoaDon);
            }while (c.moveToNext());
        }
        return list;
    }


}
