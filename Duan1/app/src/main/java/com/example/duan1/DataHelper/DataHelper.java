package com.example.duan1.DataHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {
    private static String name = "Duan01.db";
    private static int version = 1;

    public DataHelper(Context context){
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TAIKHOAN = "CREATE TABLE \"TAIKHOAN\" (\n" +
                "\t\"MATK\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"TAIKHOAN\"\tTEXT,\n" +
                "\t\"MATKHAU\"\tTEXT,\n" +
                "\t\"SDT\"\tINTEGER\n" +
                ");";

        String KHACHHANG = "CREATE TABLE \"KHACHHANG\" (\n" +
                "\t\"MAKH\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"MATK\"\tINTEGER,\n" +
                "\t\"TENKH\"\tTEXT,\n" +
                "\t\"SDT\"\tINTEGER,\n" +
                "\t\"ADDRESS\"\tTEXT,\n" +
                "\tFOREIGN KEY(\"MATK\") REFERENCES \"TAIKHOAN\"(\"MATK\")\n" +
                ");";

        String THELOAI = "CREATE TABLE \"THELOAI\" (\n" +
                "\t\"MATL\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"TENTL\"\tTEXT\n" +
                ");";

        String SANPHAM = "CREATE TABLE \"SANPHAM\" (\n" +
                "\t\"MASP\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"MATL\"\tINTEGER,\n" +
                "\t\"TENSP\"\tTEXT,\n" +
                "\t\"GIATIEN\"\tINTEGER,\n" +
                "\t\"IMG\"\tINTEGER,\n" +
                "\t\"SOLUONG\"\tINTEGER,\n" +
                "\t\"GIOITHIEU\"\tTEXT,\n" +
                "\tFOREIGN KEY(\"MATL\") REFERENCES \"THELOAI\"(\"MATL\")\n" +
                ");";

        db.execSQL(TAIKHOAN);
        db.execSQL(KHACHHANG);
        db.execSQL(THELOAI);
        db.execSQL(SANPHAM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE TAIKHOAN");
        db.execSQL("DROP TABLE KHACHHANG");
        db.execSQL("DROP TABLE THELOAI");
        db.execSQL("DROP TABLE SANPHAM");
    }
}
