package com.example.duan1.Model;

public class KhachHang {
    private int MaKH, MaTK;
    private String tenKh;
    private int SDT;
    private String address;

    public KhachHang(int maKH, int maTK, String tenKh, int SDT, String address) {
        MaKH = maKH;
        MaTK = maTK;
        this.tenKh = tenKh;
        this.SDT = SDT;
        this.address = address;
    }

    public KhachHang() {
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int maTK) {
        MaTK = maTK;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
