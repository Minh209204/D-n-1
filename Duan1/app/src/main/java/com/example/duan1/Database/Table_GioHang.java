package com.example.duan1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.DataHelper.DataHelper;
import com.example.duan1.Model.Model_GioHang;
import com.example.duan1.Model.Model_KhachHang;

import java.util.ArrayList;
import java.util.List;

public class Table_GioHang {
    DataHelper dataHelper;
    SQLiteDatabase db;

    public Table_GioHang(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }

    public boolean insert(Model_GioHang gioHang){
        ContentValues values = new ContentValues();
        values.put("MAKH", gioHang.getMaKH());
        values.put("MASP", gioHang.getMaSP());
        values.put("ANHSP", gioHang.getAnhSP());
        values.put("TENSP", gioHang.getTenSP());
        values.put("GIASP", gioHang.getGiaSP());
        values.put("SOLUONG", gioHang.getSoLuong());
        values.put("SOLUONGSP", gioHang.getSoLuongSP());

        long result = db.insert("GIOHANG", null, values);

        return result != -1;
    }

    public boolean delete(Model_GioHang gioHang){
        String dieukien[] = new String[]{String.valueOf(gioHang.getMaGH())};

        long result = db.delete("GIOHANG", "MAGH=?", dieukien);
        return result != -1;
    }

    public boolean update(Model_GioHang gioHang){
        String dieukien[] = new String[]{String.valueOf(gioHang.getMaGH())};
        ContentValues values = new ContentValues();
        values.put("MAKH", gioHang.getMaKH());
        values.put("MASP", gioHang.getMaSP());
        values.put("TENSP", gioHang.getTenSP());
        values.put("ANHSP", gioHang.getAnhSP());
        values.put("GIASP", gioHang.getGiaSP());
        values.put("CHECKBOX", gioHang.getCheckBox());
        values.put("SOLUONG", gioHang.getSoLuong());
        values.put("SOLUONGSP", gioHang.getSoLuongSP());

        long result = db.update("GIOHANG", values, "MAGH=?", dieukien);
        return result != -1;
    }

    public List<Model_GioHang> getAll(Model_KhachHang model_khachHang){
        List<Model_GioHang> list = new ArrayList<>();
        String dieukien[] = new String[]{String.valueOf(model_khachHang.getMaKH())};

        Cursor c = db.rawQuery("SELECT * FROM GIOHANG JOIN KHACHHANG ON KHACHHANG.MAKH = GIOHANG.MAKH WHERE GIOHANG.MAKH = ? ", dieukien);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                Model_GioHang gioHang = new Model_GioHang();
                int magh = c.getInt(0);
                int makh = c.getInt(1);
                int masp = c.getInt(2);
                String tensp = c.getString(3);
                String anhsp = c.getString(4);
                int giasp = c.getInt(5);
                int checkbox = c.getInt(6);
                int soluongsp = c.getInt(7);
                int soluong = c.getInt(8);

                gioHang.setMaGH(magh);
                gioHang.setMaKH(makh);
                gioHang.setMaSP(masp);
                gioHang.setTenSP(tensp);
                gioHang.setAnhSP(anhsp);
                gioHang.setGiaSP(giasp);
                gioHang.setCheckBox(checkbox);
                gioHang.setSoLuongSP(soluongsp);
                gioHang.setSoLuong(soluong);

                list.add(gioHang);
            }while (c.moveToNext());
        }
        return list;
    }

    public List<Model_GioHang> getSanPham(Model_GioHang model_gioHang){
        List<Model_GioHang> list = new ArrayList<>();

        String dieukien[] = new String[]{String.valueOf(model_gioHang.getCheckBox())};
        Cursor c = db.rawQuery("SELECT * FROM GIOHANG WHERE CHECKBOX = ?", dieukien);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                Model_GioHang gioHang = new Model_GioHang();
                int magh = c.getInt(0);
                int makh = c.getInt(1);
                int masp = c.getInt(2);
                String tensp = c.getString(3);
                String anhsp = c.getString(4);
                int giasp = c.getInt(5);
                int checkbox = c.getInt(6);
                int soluongsp = c.getInt(7);
                int soluong = c.getInt(8);

                gioHang.setMaGH(magh);
                gioHang.setMaKH(makh);
                gioHang.setMaSP(masp);
                gioHang.setTenSP(tensp);
                gioHang.setAnhSP(anhsp);
                gioHang.setGiaSP(giasp);
                gioHang.setCheckBox(checkbox);
                gioHang.setSoLuongSP(soluongsp);
                gioHang.setSoLuong(soluong);

                list.add(gioHang);
            }while (c.moveToNext());
        }
        return list;
    }


    public List<Model_GioHang> MuaSanPham(Model_GioHang model_gioHang){
        List<Model_GioHang> list = new ArrayList<>();

        String dieukien[] = new String[]{String.valueOf(model_gioHang.getCheckBox()), String.valueOf(model_gioHang.getMaKH())};
        Cursor c = db.rawQuery("SELECT * FROM GIOHANG JOIN KHACHHANG ON KHACHHANG.MAKH = GIOHANG.MAKH WHERE GIOHANG.CHECKBOX = ? AND GIOHANG.MAKH = ?", dieukien);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                Model_GioHang gioHang = new Model_GioHang();
                int magh = c.getInt(0);
                int makh = c.getInt(1);
                int masp = c.getInt(2);
                String tensp = c.getString(3);
                String anhsp = c.getString(4);
                int giasp = c.getInt(5);
                int checkbox = c.getInt(6);
                int soluongsp = c.getInt(7);
                int soluong = c.getInt(8);

                gioHang.setMaGH(magh);
                gioHang.setMaKH(makh);
                gioHang.setMaSP(masp);
                gioHang.setTenSP(tensp);
                gioHang.setAnhSP(anhsp);
                gioHang.setGiaSP(giasp);
                gioHang.setCheckBox(checkbox);
                gioHang.setSoLuongSP(soluongsp);
                gioHang.setSoLuong(soluong);

                list.add(gioHang);
            }while (c.moveToNext());
        }
        return list;
    }
}
