package com.example.duan1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.DataHelper.DataHelper;
import com.example.duan1.Model.Model_DonHang;

import java.util.ArrayList;
import java.util.List;

public class Table_DonHang {

    DataHelper dataHelper;
    SQLiteDatabase db;

    public Table_DonHang(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }

    public boolean insert(Model_DonHang model_donHang){
        ContentValues values = new ContentValues();
        values.put("MAGH", model_donHang.getMaGH());
        values.put("MAKH", model_donHang.getMaKH());
        values.put("MASP", model_donHang.getMaSP());
        values.put("TENKH", model_donHang.getTenKH());
        values.put("SDTKH", model_donHang.getSDT());
        values.put("ANHSP", model_donHang.getAnhSP());
        values.put("TENSP", model_donHang.getTenSP());
        values.put("GIASP", model_donHang.getGiaSP());
        values.put("SOLUONG", model_donHang.getSoLuongSP());
        values.put("TONGTIEN", model_donHang.getTongTien());
        values.put("DIACHIKH", model_donHang.getDiaChiKH());
        values.put("TRANGTHAI", model_donHang.getTrangThai());

        long result = db.insert("DONHANG", null, values);

        return result != -1;
    }

    public boolean delete(Model_DonHang hoaDon){
        String dieukien[] = new String[]{String.valueOf(hoaDon.getMaDH())};

        long result = db.delete("DONHANG", "MADH=?", dieukien);
        return result != -1;
    }

    public boolean update(Model_DonHang model_donHang){
        String dieukien[] = new String[]{String.valueOf(model_donHang.getMaDH())};
        ContentValues values = new ContentValues();
        values.put("MASP", model_donHang.getMaSP());
        values.put("TENKH", model_donHang.getTenKH());
        values.put("SDTKH", model_donHang.getSDT());
        values.put("ANHSP", model_donHang.getAnhSP());
        values.put("TENSP", model_donHang.getTenSP());
        values.put("GIASP", model_donHang.getGiaSP());
        values.put("SOLUONG", model_donHang.getSoLuongSP());
        values.put("TONGTIEN", model_donHang.getTongTien());
        values.put("DIACHIKH", model_donHang.getDiaChiKH());
        values.put("TRANGTHAI", model_donHang.getTrangThai());

        long result = db.update("DONHANG", values, "MADH=?", dieukien);
        return result != -1;
    }

    public List<Model_DonHang> getAll(){
        List<Model_DonHang> list = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM DONHANG", null);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                Model_DonHang model_donHang = new Model_DonHang();

                int madh = c.getInt(0);
                int magh = c.getInt(1);
                int masp = c.getInt(2);
                int makh = c.getInt(2);
                String tenkh = c.getString(4);
                int sdt = c.getInt(5);
                String anhsp = c.getString(6);
                String tensp = c.getString(7);
                int giasp = c.getInt(8);
                int soluong = c.getInt(9);
                int tongtien = c.getInt(10);
                String diachi = c.getString(11);
                String trangthai = c.getString(12);

                model_donHang.setMaDH(madh);
                model_donHang.setMaGH(magh);
                model_donHang.setMaSP(masp);
                model_donHang.setMaKH(makh);
                model_donHang.setTenKH(tenkh);
                model_donHang.setSDT(sdt);
                model_donHang.setTenSP(tensp);
                model_donHang.setAnhSP(anhsp);
                model_donHang.setGiaSP(giasp);
                model_donHang.setSoLuongSP(soluong);
                model_donHang.setTongTien(tongtien);
                model_donHang.setDiaChiKH(diachi);
                model_donHang.setTrangThai(trangthai);

                list.add(model_donHang);
            }while (c.moveToNext());
        }
        return list;
    }
    public List<Model_DonHang> getSanPHamKhachHang(Model_DonHang model_donHang){
        List<Model_DonHang> list = new ArrayList<>();

        String dieukien[] = new String[]{String.valueOf(model_donHang.getMaKH())};
        Cursor c = db.rawQuery("SELECT * FROM DONHANG WHERE MAKH = ?", dieukien);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                model_donHang = new Model_DonHang();
                int madh = c.getInt(0);
                int magh = c.getInt(1);
                int masp = c.getInt(2);
                int makh = c.getInt(2);
                String tenkh = c.getString(4);
                int sdt = c.getInt(5);
                String anhsp = c.getString(6);
                String tensp = c.getString(7);
                int giasp = c.getInt(8);
                int soluong = c.getInt(9);
                int tongtien = c.getInt(10);
                String diachi = c.getString(11);
                String trangthai = c.getString(12);

                model_donHang.setMaDH(madh);
                model_donHang.setMaGH(magh);
                model_donHang.setMaSP(masp);
                model_donHang.setMaKH(makh);
                model_donHang.setTenKH(tenkh);
                model_donHang.setSDT(sdt);
                model_donHang.setTenSP(tensp);
                model_donHang.setAnhSP(anhsp);
                model_donHang.setGiaSP(giasp);
                model_donHang.setSoLuongSP(soluong);
                model_donHang.setTongTien(tongtien);
                model_donHang.setDiaChiKH(diachi);
                model_donHang.setTrangThai(trangthai);

                list.add(model_donHang);
            }while (c.moveToNext());
        }
        return list;
    }

    public List<Model_DonHang> getThongKe(Model_DonHang model_donHang){
        List<Model_DonHang> list = new ArrayList<>();

        String dieukien[] = new String[]{String.valueOf(model_donHang.getTrangThai())};
        Cursor c = db.rawQuery("SELECT * FROM DONHANG WHERE TRANGTHAI = ?", dieukien);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                model_donHang = new Model_DonHang();
                int madh = c.getInt(0);
                int magh = c.getInt(1);
                int masp = c.getInt(2);
                int makh = c.getInt(2);
                String tenkh = c.getString(4);
                int sdt = c.getInt(5);
                String anhsp = c.getString(6);
                String tensp = c.getString(7);
                int giasp = c.getInt(8);
                int soluong = c.getInt(9);
                int tongtien = c.getInt(10);
                String diachi = c.getString(11);
                String trangthai = c.getString(12);

                model_donHang.setMaDH(madh);
                model_donHang.setMaGH(magh);
                model_donHang.setMaSP(masp);
                model_donHang.setMaKH(makh);
                model_donHang.setTenKH(tenkh);
                model_donHang.setSDT(sdt);
                model_donHang.setTenSP(tensp);
                model_donHang.setAnhSP(anhsp);
                model_donHang.setGiaSP(giasp);
                model_donHang.setSoLuongSP(soluong);
                model_donHang.setTongTien(tongtien);
                model_donHang.setDiaChiKH(diachi);
                model_donHang.setTrangThai(trangthai);

                list.add(model_donHang);
            }while (c.moveToNext());
        }
        return list;
    }
}
