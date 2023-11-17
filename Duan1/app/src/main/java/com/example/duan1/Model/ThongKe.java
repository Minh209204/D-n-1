package com.example.duan1.Model;

public class ThongKe {
    private int MaTK, MaHD, MaSP, soLuong;

    public ThongKe(int maTK, int maHD, int maSP, int soLuong) {
        MaTK = maTK;
        MaHD = maHD;
        MaSP = maSP;
        this.soLuong = soLuong;
    }

    public ThongKe() {
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int maTK) {
        MaTK = maTK;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int maHD) {
        MaHD = maHD;
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
}
