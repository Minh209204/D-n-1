package com.example.duan1.Model;

public class Model_DonHang {
    private int MaDH, MaKH, MaSP;
    private String TenKH, DiaChiKH, AnhSP, TenSP, TrangThai, MaGH, SoLuongSP;
    private int SDT, GiaSP, TongTien;

    public Model_DonHang(int maDH, String maGH, int maKH, int maSP, String tenKH, String diaChiKH, String anhSP, String tenSP, String trangThai, int SDT, String soLuongSP, int giaSP, int tongTien) {
        MaDH = maDH;
        MaGH = maGH;
        MaKH = maKH;
        MaSP = maSP;
        TenKH = tenKH;
        DiaChiKH = diaChiKH;
        AnhSP = anhSP;
        TenSP = tenSP;
        TrangThai = trangThai;
        this.SDT = SDT;
        SoLuongSP = soLuongSP;
        GiaSP = giaSP;
        TongTien = tongTien;
    }

    public String getSoLuongSP() {
        return SoLuongSP;
    }

    public void setSoLuongSP(String soLuongSP) {
        SoLuongSP = soLuongSP;
    }

    public String getMaGH() {
        return MaGH;
    }

    public void setMaGH(String maGH) {
        MaGH = maGH;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public int getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(int giaSP) {
        GiaSP = giaSP;
    }

    public Model_DonHang() {
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


    public int getMaDH() {
        return MaDH;
    }

    public void setMaDH(int maDH) {
        MaDH = maDH;
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



    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int tongTien) {
        TongTien = tongTien;
    }
}
