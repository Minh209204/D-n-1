package com.example.duan1.Model;

public class Model_SanPham {
    private int MaSP, MaTL;
    private String TenTL, TenSP, AnhSP, GioiThieuSP;
    private int GiaTienSP, LuotMuaSP, TonTai;

    public Model_SanPham(String tenTL, String tenSP, String anhSP, String gioiThieuSP, int giaTienSP, int luotMuaSP, int tonTai) {
        TenTL = tenTL;
        TenSP = tenSP;
        AnhSP = anhSP;
        GioiThieuSP = gioiThieuSP;
        GiaTienSP = giaTienSP;
        LuotMuaSP = luotMuaSP;
        TonTai = tonTai;
    }

    public String getTenTL() {
        return TenTL;
    }

    public void setTenTL(String tenTL) {
        TenTL = tenTL;
    }

    public int getTonTai() {
        return TonTai;
    }

    public Model_SanPham() {
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

    public String getGioiThieuSP() {
        return GioiThieuSP;
    }

    public void setGioiThieuSP(String gioiThieuSP) {
        GioiThieuSP = gioiThieuSP;
    }

    public int getGiaTienSP() {
        return GiaTienSP;
    }

    public void setGiaTienSP(int giaTienSP) {
        GiaTienSP = giaTienSP;
    }

    public int getLuotMuaSP() {
        return LuotMuaSP;
    }

    public void setLuotMuaSP(int luotMuaSP) {
        LuotMuaSP = luotMuaSP;
    }

    public int isTonTai() {
        return TonTai;
    }

    public void setTonTai(int tonTai) {
        TonTai = tonTai;
    }
}
