package com.example.duan1.Model;

public class SanPham {
    private int MaSP, MaTL;
    private String tenSp;
    private int img, giaTien, soLuong, gioiThieu;

    public SanPham(int maSP, int maTL, String tenSp, int img, int giaTien, int soLuong, int gioiThieu) {
        this.MaSP = maSP;
        this.MaTL = maTL;
        this.tenSp = tenSp;
        this.img = img;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
        this.gioiThieu = gioiThieu;
    }

    public SanPham(int anh, String tenSp, int giaTien) {
        this.tenSp = tenSp;
        this.img = anh;
        this.giaTien = giaTien;
    }

    public SanPham() {
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        MaSP = maSP;
    }

    public int getMaTL() {
        return MaTL;
    }

    public void setMaTL(int maTL) {
        MaTL = maTL;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
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
