package com.example.duan1.Model;

public class HoaDon {
    private int MaHD, MaKH, MaSP, soLuong, STK, giaTien;
    private String address;

    public HoaDon(int maHD, int maKH, int maSP, int soLuong, int STK, int giaTien, String address) {
        MaHD = maHD;
        MaKH = maKH;
        MaSP = maSP;
        this.soLuong = soLuong;
        this.STK = STK;
        this.giaTien = giaTien;
        this.address = address;
    }

    public HoaDon() {
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int maHD) {
        MaHD = maHD;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
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

    public int getSTK() {
        return STK;
    }

    public void setSTK(int STK) {
        this.STK = STK;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
