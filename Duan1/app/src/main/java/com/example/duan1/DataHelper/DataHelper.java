package com.example.duan1.DataHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {
    private static String name = "Duan1.db";
    private static int version = 1;

    public DataHelper(Context context){
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String taikhoan = "CREATE TABLE TAIKHOAN(MATK INTEGER NOT NULL, TAIKHOAN TEXT, SDT INTEGER, PRIMARY KEY(MATK));";
        String khachhang = "CREATE TABLE KHACHHANG(MAKH INTEGER NOT NULL, MATK INTEGER, TENKH TEXT ,SDT INTEGER,ADDRESS TEXT,FOREIGN KEY(MATK) REFERENCES TAIKHOAN(MATK),PRIMARY KEY(MAKH));";
        String qltaikhoan = "CREATE TABLE QLKHACHHANG(MAQLKH INTEGER NOT NULL, MAKH INTEGER, PRIMARY KEY(MAQLKH), FOREIGN KEY(MAKH) REFERENCES KHACHHANG (MAKH));";
        String theloai = "CREATE TABLE THELOAI(MATL INTEGER NOT NULL, TENTL TEXT, PRIMARY KEY(MATL));";
        String sanpham = "CREATE TABLE SANPHAM(MASP INTEGER NOT NULL, TENSP TEXT, MATL INTEGER, GIATIEN INTEGER, SOLUONG INTEGER, GIOITHIEU TEXT, FOREIGN KEY(MATL) REFERENCES HELOAI(MATL), PRIMARY KEY(MASP));";
        String qlsanpham = "CREATE TABLE QLSANPHAM(MAQLSP INTEGER NOT NULL, MASP INTEGER, FOREIGN KEY(MASP) REFERENCES SANPHAM(MASP), PRIMARY KEY(MAQLSP));";
        String giohang = "CREATE TABLE GIOHANG (MAGH INTEGER NOT NULL, MASP INTEGER, SOLUONG INTEGER, GIATIEN INTEGER, FOREIGN KEY(MASP) REFERENCES SANPHAM(MASP), PRIMARY KEY(MAGH));";
        String hoadon = "CREATE TABLE HOADON(MAHD INTEGER NOT NULL, MAKH INTEGER, MASP INTEGER, SOLUONG INTEGER, STK INTEGER, GIATIEN INTEGER, ADDRESS INTEGER, FOREIGN KEY(MAKH) REFERENCES KHACHHANG(MAKH), FOREIGN KEY(MASP) REFERENCES GIOHANG(MASP), PRIMARY KEY(MAHD));";
        String thongke = "CREATE TABLE THONGKE (MATKINTEGER NOT NULL, MAHDINTEGER, MASP INTEGER, SOLUONGINTEGER, PRIMARY KEY(MATK), FOREIGN KEY(MAHD) REFERENCES HOADON(MAHD));";

        db.execSQL(taikhoan);
        db.execSQL(khachhang);
        db.execSQL(qltaikhoan);
        db.execSQL(theloai);
        db.execSQL(sanpham);
        db.execSQL(qlsanpham);
        db.execSQL(giohang);
        db.execSQL(hoadon);
        db.execSQL(thongke);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table taikhoan");
        db.execSQL("Drop table khachhang");
        db.execSQL("Drop table qltaikhoan");
        db.execSQL("Drop table theloai");
        db.execSQL("Drop table sanpham");
        db.execSQL("Drop table qlsanpham");
        db.execSQL("Drop table giohang");
        db.execSQL("Drop table hoadon");
        db.execSQL("Drop table thongke");
    }
}
