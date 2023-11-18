package com.example.duan1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1.DataHelper.DataHelper;
import com.example.duan1.Model.SanPham;
import com.example.duan1.Model.TaiKhoan;

import java.util.ArrayList;
import java.util.List;

public class Table_SanPham {

    SQLiteDatabase db;
    DataHelper dataHelper;

    public Table_SanPham(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }

    public boolean insert(SanPham sanPham){
        ContentValues values = new ContentValues();
        values.put("MATL", sanPham.getMaTL());
        values.put("TENSP", sanPham.getTenSp());
        values.put("GIATIEN", sanPham.getGiaTien());
        values.put("IMG", sanPham.getImg());
        values.put("SOLUONG", sanPham.getSoLuong());
        values.put("GIOITHIEU", sanPham.getGioiThieu());

        long result = db.insert("SANPHAM", null, values);

        return result != -1;
    }

    public boolean delete(SanPham sanPham){
        String dieukien[] = new String[]{String.valueOf(sanPham.getMaSP())};

        long result = db.delete("SANPHAM", "MASP=?", dieukien);
        return result != -1;
    }

    public boolean update(SanPham sanPham){
        String dieukien[] = new String[]{String.valueOf(sanPham.getMaSP())};
        ContentValues values = new ContentValues();
        values.put("MATL", sanPham.getMaTL());
        values.put("TENSP", sanPham.getTenSp());
        values.put("GIATIEN", sanPham.getGiaTien());
        values.put("IMG", sanPham.getImg());
        values.put("SOLUONG", sanPham.getSoLuong());
        values.put("GIOITHIEU", sanPham.getGioiThieu());

        long result = db.update("SANPHAM", values, "MASP=?", dieukien);

        return result != -1;
    }

    public List<SanPham> getAll(){
        List<SanPham> list = new ArrayList<>();
        SanPham pham = new SanPham();

        Cursor c = db.rawQuery("SELECT * FROM TAIKHOAN", null);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
//                int id = c.getInt(0);
//                int matl = c.getInt(1);
                String tensp = c.getString(2);
                int giatien = c.getInt(3);
//                int img = c.getInt(4);
//                int soluong = c.getInt(5);
//                String gioithieu = c.getString(6);

                pham.setTenSp(tensp);
                pham.setGiaTien(giatien);

                list.add(pham);
            }while (c.moveToNext());
        }
        return list;
    }




}
