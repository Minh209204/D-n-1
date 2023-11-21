package com.example.duan1.DataHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {
    private static String name = "Duan01.db";
    private static int version = 2 ;
    public DataHelper(Context context){
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TAIKHOAN = "CREATE TABLE \"TAIKHOAN\" (\n" +
                "\t\"MATK\"\tINTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "\t\"TAIKHOAN\"\tTEXT,\n" +
                "\t\"MATKHAU\"\tTEXT,\n" +
                "\t\"SDT\"\tINTEGER\n" +
                ");";

        String KHACHHANG = "CREATE TABLE \"KHACHHANG\" (\n" +
                "\t\"MAKH\"\tINTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "\t\"MATK\"\tINTEGER,\n" +
                "\t\"TENKH\"\tTEXT,\n" +
                "\t\"ANHKH\"\tTEXT,\n" +
                "\t\"SDTKH\"\tINTEGER,\n" +
                "\t\"DIACHIKH\"\tTEXT,\n" +
                "\tFOREIGN KEY(\"MATK\") REFERENCES \"TAIKHOAN\"(\"MATK\")\n" +
                ");";

        String QLKHACHHANG = "CREATE TABLE \"QLKHACHHANG\" (\n" +
                "\t\"MAQLKH\"\tINTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "\t\"MAKH\"\tINTEGER,\n" +
                "\t\"TENKH\"\tTEXT,\n" +
                "\t\"ANHKH\"\tTEXT,\n" +
                "\tFOREIGN KEY(\"MAKH\") REFERENCES \"KHACHHANG\"(\"MAKH\")\n" + ");";


        String THELOAI = "CREATE TABLE \"THELOAI\" (\n" +
                "\t\"MATL\"\tINTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "\t\"TENTL\"\tTEXT\n" +
                ");";

        String SANPHAM = "CREATE TABLE \"SANPHAM\" (\n" +
                "\t\"MASP\"\tINTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "\t\"MATL\"\tINTEGER,\n" +
                "\t\"TENSP\"\tTEXT,\n" +
                "\t\"GIATIENSP\"\tINTEGER,\n" +
                "\t\"ANHSP\"\tTEXT,\n" +
                "\t\"LUOTMUASP\"\tINTEGER,\n" +
                "\t\"GIOITHIEUSP\"\tTEXT,\n" +
                "\t\"TONTAI\"\tINTEGER,\n" +
                "\tFOREIGN KEY(\"MATL\") REFERENCES \"THELOAI\"(\"MATL\")\n" +
                ");";

        String GIOHANG = "CREATE TABLE \"GIOHANG\" (\n" +
                "\t\"MAGH\"\tINTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "\t\"MASP\"\tINTEGER,\n" +
                "\t\"TENSP\"\tTEXT,\n" +
                "\t\"ANHSP\"\tTEXT,\n" +
                "\t\"GIASP\"\tINTEGER,\n" +
                "\t\"SOLUONGSP\"\tINTEGER,\n" +
                "\t\"TONGTIEN\"\tINTEGER,\n" +
                "\tFOREIGN KEY(\"MASP\") REFERENCES \"SANPHAM\"(\"MASP\")\n" +
                ");";

        String HOADON = "CREATE TABLE \"HOADON\" (\n" +
                "\t\"MAHD\"\tINTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "\t\"MAKH\"\tINTEGER,\n" +
                "\t\"MAGH\"\tINTEGER,\n" +
                "\t\"TENKH\"\tTEXT,\n" +
                "\t\"SDTKH\"\tINTEGER,\n" +
                "\t\"SOLUONGSP\"\tINTEGER,\n" +
                "\t\"TONGTIEN\"\tINTEGER,\n" +
                "\t\"DIACHIKH\"\tTEXT,\n" +
                "\tFOREIGN KEY(\"MAKH\") REFERENCES \"KHACHHANG\"(\"MAKH\"),\n" +
                "\tFOREIGN KEY(\"MAGH\") REFERENCES \"GIOHANG\"(\"MAGH\")\n" +
                ");";

        String THONGKE = "CREATE TABLE \"THONGKE\" (\n" +
                "\t\"MATK\"\tINTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "\t\"MAHD\"\tINTEGER,\n" +
                "\t\"MASP\"\tINTEGER,\n" +
                "\t\"TENSP\"\tTEXT,\n" +
                "\t\"ANHSP\"\tTEXT,\n" +
                "\t\"GIASP\"\tINTEGER,\n" +
                "\t\"LUOTMUA\"\tINTEGER,\n" +
                "\tFOREIGN KEY(\"MAHD\") REFERENCES \"HOADON\"(\"MAHD\")\n" +
                ");";
        db.execSQL(TAIKHOAN);
        db.execSQL(KHACHHANG);
        db.execSQL(QLKHACHHANG);

        db.execSQL(THELOAI);
        db.execSQL(SANPHAM);
        db.execSQL(GIOHANG);
        db.execSQL(HOADON);
        db.execSQL(THONGKE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE TAIKHOAN");
        db.execSQL("DROP TABLE KHACHHANG");
        db.execSQL("DROP TABLE THELOAI");
        db.execSQL("DROP TABLE SANPHAM");
    }
}
