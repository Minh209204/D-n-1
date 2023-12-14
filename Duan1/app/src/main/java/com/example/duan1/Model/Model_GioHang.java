package com.example.duan1.Model;

public class Model_GioHang {
    private int MaGH, MaSP, MaKH;
    private String TenSP, AnhSP;
    private int GiaSP, CheckBox, SoLuongSP, SoLuong, TonTai;

    public Model_GioHang(int maGH, int maSP, int maKH, String tenSP, String anhSP, int giaSP, int checkBox, int soLuongSP, int soLuong, int tonTai) {
        MaGH = maGH;
        MaSP = maSP;
        MaKH = maKH;
        TenSP = tenSP;
        AnhSP = anhSP;
        GiaSP = giaSP;
        CheckBox = checkBox;
        SoLuongSP = soLuongSP;
        SoLuong = soLuong;
        TonTai = tonTai;
    }
    public Model_GioHang() {
    }
    public int getTonTai() {
        return TonTai;
    }
    public void setTonTai(int tonTai) {
        TonTai = tonTai;
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
