package com.example.duan1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.DataHelper.DataHelper;
import com.example.duan1.Model.Model_GioHang;
import com.example.duan1.Model.Model_HoaDon;

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
        values.put("MASP", gioHang.getMaSP());
        values.put("ANHSP", gioHang.getAnhSP());
        values.put("TENSP", gioHang.getTenSP());
        values.put("GIASP", gioHang.getGiaSP());
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
        values.put("MASP", gioHang.getMaSP());
        values.put("ANHSP", gioHang.getAnhSP());
        values.put("TENSP", gioHang.getTenSP());
        values.put("GIASP", gioHang.getGiaSP());
        values.put("CHECKBOX", gioHang.getCheckBox());
        values.put("SOLUONGSP", gioHang.getSoLuongSP());

        long result = db.update("GIOHANG", values, "MAGH=?", dieukien);
        return result != -1;
    }

    public List<Model_GioHang> getAll(){
        List<Model_GioHang> list = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM GIOHANG", null);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                Model_GioHang gioHang = new Model_GioHang();
                int magh = c.getInt(0);
                int masp = c.getInt(1);
                String tensp = c.getString(2);
                String anhsp = c.getString(3);
                int giasp = c.getInt(4);
                int checkbox = c.getInt(5);
                int soluong = c.getInt(6);

                gioHang.setMaGH(magh);
                gioHang.setMaSP(masp);
                gioHang.setTenSP(tensp);
                gioHang.setAnhSP(anhsp);
                gioHang.setGiaSP(giasp);
                gioHang.setCheckBox(checkbox);
                gioHang.setSoLuongSP(soluong);

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
                int masp = c.getInt(1);
                String tensp = c.getString(2);
                String anhsp = c.getString(3);
                int giasp = c.getInt(4);
                int checkbox = c.getInt(5);
                int soluong = c.getInt(6);

                gioHang.setMaGH(magh);
                gioHang.setMaSP(masp);
                gioHang.setTenSP(tensp);
                gioHang.setAnhSP(anhsp);
                gioHang.setGiaSP(giasp);
                gioHang.setCheckBox(checkbox);
                gioHang.setSoLuongSP(soluong);

                list.add(gioHang);
            }while (c.moveToNext());
        }
        return list;
    }
}
