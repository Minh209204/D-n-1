package com.example.duan1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.duan1.DataHelper.DataHelper;
import com.example.duan1.Model.Model_SanPham;

import java.util.ArrayList;
import java.util.List;

public class Table_SanPham {

    SQLiteDatabase db;
    DataHelper dataHelper;

    public Table_SanPham(Context context){
        dataHelper = new DataHelper(context);
        db = dataHelper.getReadableDatabase();
    }

    public boolean insert(Model_SanPham sanPham){
        ContentValues values = new ContentValues();
        values.put("MATL", sanPham.getMaTL());
        values.put("TENTL", sanPham.getTenTL());
        values.put("TENSP", sanPham.getTenSP());
        values.put("GIATIENSP", sanPham.getGiaTienSP());
        values.put("ANHSP", sanPham.getAnhSP());
        values.put("LUOTMUASP", sanPham.getLuotMuaSP());
        values.put("GIOITHIEUSP", sanPham.getGioiThieuSP());
        values.put("SOLUONGSP", sanPham.getSoLuong());

        long result = db.insert("SANPHAM", null, values);

        return result != -1;
    }

    public boolean delete(Model_SanPham sanPham){
        String dieukien[] = new String[]{String.valueOf(sanPham.getMaSP())};

        long result = db.delete("SANPHAM", "MASP=?", dieukien);
        return result != -1;
    }

    public boolean update(Model_SanPham sanPham){
        String dieukien[] = new String[]{String.valueOf(sanPham.getMaSP())};
        ContentValues values = new ContentValues();
        values.put("MATL", sanPham.getMaTL());
        values.put("TENTL", sanPham.getTenTL());
        values.put("TENSP", sanPham.getTenSP());
        values.put("GIATIENSP", sanPham.getGiaTienSP());
        values.put("ANHSP", sanPham.getAnhSP());
        values.put("LUOTMUASP", sanPham.getLuotMuaSP());
        values.put("GIOITHIEUSP", sanPham.getGioiThieuSP());
        values.put("SOLUONGSP", sanPham.getSoLuong());

        long result = db.update("SANPHAM", values, "MASP=?", dieukien);

        return result != -1;
    }

    public List<Model_SanPham> getAll(){
        List<Model_SanPham> list = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM SANPHAM", null);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                Model_SanPham pham = new Model_SanPham();
                int masp = c.getInt(0);
                int matl = c.getInt(1);
                String tentl = c.getString(2);
                String tensp = c.getString(3);
                int giatien = c.getInt(4);
                String img = c.getString(5);
                String luotmua = c.getString(6);
                String gioithieu = c.getString(7);
                int soluongsp = c.getInt(8);

                pham.setMaSP(masp);
                pham.setMaTL(matl);
                pham.setTenTL(tentl);
                pham.setTenSP(tensp);
                pham.setGiaTienSP(giatien);
                pham.setAnhSP(img);
                pham.setLuotMuaSP(Integer.parseInt(luotmua));
                pham.setGioiThieuSP(gioithieu);
                pham.setSoLuong(soluongsp);

                list.add(pham);
            }while (c.moveToNext());
        }
        return list;
    }

    // lay san pham theo ma the loai
    public List<Model_SanPham> getTheLoai(Model_SanPham pham){
        List<Model_SanPham> list = new ArrayList<>();

        String dieukien[] = new String[]{String.valueOf(pham.getMaTL())};
        Cursor c = db.rawQuery("SELECT * FROM SANPHAM WHERE MATL = ?", dieukien);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                pham = new Model_SanPham();
                int masp = c.getInt(0);
                int matl = c.getInt(1);
                String tentl = c.getString(2);
                String tensp = c.getString(3);
                int giatien = c.getInt(4);
                String img = c.getString(5);
                String luotmua = c.getString(6);
                String gioithieu = c.getString(7);
                int soluongsp = c.getInt(8);

                pham.setMaSP(masp);
                pham.setMaTL(matl);
                pham.setTenTL(tentl);
                pham.setTenSP(tensp);
                pham.setGiaTienSP(giatien);
                pham.setAnhSP(img);
                pham.setLuotMuaSP(Integer.parseInt(luotmua));
                pham.setGioiThieuSP(gioithieu);
                pham.setSoLuong(soluongsp);

                list.add(pham);
            }while (c.moveToNext());
        }
        return list;
    }

    // lay san pham theo ma san pham
    public List<Model_SanPham> getMASP(Model_SanPham pham){
        List<Model_SanPham> list = new ArrayList<>();

        String dieukien[] = new String[]{String.valueOf(pham.getMaSP())};
        Cursor c = db.rawQuery("SELECT * FROM SANPHAM WHERE MASP = ?", dieukien);
        c.moveToFirst();

        if (c != null && c.getCount() > 0){
            do {
                pham = new Model_SanPham();
                int masp = c.getInt(0);
                int matl = c.getInt(1);
                String tentl = c.getString(2);
                String tensp = c.getString(3);
                int giatien = c.getInt(4);
                String img = c.getString(5);
                String luotmua = c.getString(6);
                String gioithieu = c.getString(7);
                int soluongsp = c.getInt(8);

                pham.setMaSP(masp);
                pham.setMaTL(matl);
                pham.setTenTL(tentl);
                pham.setTenSP(tensp);
                pham.setGiaTienSP(giatien);
                pham.setAnhSP(img);
                pham.setLuotMuaSP(Integer.parseInt(luotmua));
                pham.setGioiThieuSP(gioithieu);
                pham.setSoLuong(soluongsp);

                list.add(pham);
            }while (c.moveToNext());
        }
        return list;
    }

}
