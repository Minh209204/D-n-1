package com.example.duan1.Model;

public class GioHang {
    private int MaGH, MaSP, soLuong, giaTien;

    public GioHang(int maGH, int maSP, int soLuong, int giaTien) {
        MaGH = maGH;
        MaSP = maSP;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public GioHang() {
    }

    public int getMaGH() {
        return MaGH;
    }

    public void setMaGH(int maGH) {
        MaGH = maGH;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }
}
