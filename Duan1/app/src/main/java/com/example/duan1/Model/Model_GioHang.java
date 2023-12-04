package com.example.duan1.Model;

public class Model_GioHang {
    private int MaGH, MaSP, MaKH;
    private String TenSP, AnhSP;
    private int GiaSP, CheckBox, SoLuongSP, SoLuong;

    public Model_GioHang(int maSP, String tenSP, String anhSP, int giaSP, int checkBox, int soLuongSP) {
        MaSP = maSP;
        TenSP = tenSP;
        AnhSP = anhSP;
        GiaSP = giaSP;
        CheckBox = checkBox;
        SoLuongSP = soLuongSP;
    }
    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public Model_GioHang() {
    }

    public int getMaGH() {
        return MaGH;
    }

    public int getCheckBox() {
        return CheckBox;
    }

    public void setCheckBox(int checkBox) {
        CheckBox = checkBox;
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

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getAnhSP() {
        return AnhSP;
    }

    public void setAnhSP(String anhSP) {
        AnhSP = anhSP;
    }

    public int getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(int giaSP) {
        GiaSP = giaSP;
    }

    public int getSoLuongSP() {
        return SoLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        SoLuongSP = soLuongSP;
    }
}
