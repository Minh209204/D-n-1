package com.example.duan1.Model;

public class Model_HoaDon {
    private int MaHD, MaKH, MaSP;
    private String TenKH, DiaChiKH, AnhSP, TenSP;
    private int SDT, SoLuongSP, GiaSP, TongTien;

    public Model_HoaDon(int maKH, int maSP, String tenKH, String diaChiKH, String anhSP, String tenSP, int SDT, int soLuongSP, int giaSP, int tongTien) {
        MaKH = maKH;
        MaSP = maSP;
        TenKH = tenKH;
        DiaChiKH = diaChiKH;
        AnhSP = anhSP;
        TenSP = tenSP;
        this.SDT = SDT;
        SoLuongSP = soLuongSP;
        GiaSP = giaSP;
        TongTien = tongTien;
    }

    public int getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(int giaSP) {
        GiaSP = giaSP;
    }

    public Model_HoaDon() {
    }

    public String getAnhSP() {
        return AnhSP;
    }

    public void setAnhSP(String anhSP) {
        AnhSP = anhSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
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

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getDiaChiKH() {
        return DiaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        DiaChiKH = diaChiKH;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public int getSoLuongSP() {
        return SoLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        SoLuongSP = soLuongSP;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int tongTien) {
        TongTien = tongTien;
    }
}
