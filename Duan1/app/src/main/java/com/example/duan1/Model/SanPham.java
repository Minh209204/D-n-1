package com.example.duan1.Model;

public class SanPham {
    private int MaSP, MaTL;
    private String tenSp;
    private int giaTien, soLuong, gioiThieu;

    public SanPham(int maSP, int maTL, String tenSp, int giaTien, int soLuong, int gioiThieu) {
        MaSP = maSP;
        MaTL = maTL;
        this.tenSp = tenSp;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
        this.gioiThieu = gioiThieu;
    }

    public SanPham() {
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        tenSp = tenSp;
    }

    public int getMaTl() {
        return MaTL;
    }

    public void setMaTl(int maTl) {
        MaTL = maTl;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(int gioiThieu) {
        this.gioiThieu = gioiThieu;
    }
}
