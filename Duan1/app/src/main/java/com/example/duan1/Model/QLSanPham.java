package com.example.duan1.Model;

public class QLSanPham {
    private int MaQLSP;
    private String MaSP;

    public QLSanPham(int maQLSP, String maSP) {
        MaQLSP = maQLSP;
        MaSP = maSP;
    }

    public QLSanPham() {
    }

    public int getMaQLSP() {
        return MaQLSP;
    }

    public void setMaQLSP(int maQLSP) {
        MaQLSP = maQLSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }
}
