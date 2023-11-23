package com.example.duan1.Model;

public class Model_KhachHang {

    private int MaKH, MaTK;
    private String AnhKH, TenKH, SDTKH, DiaChiKH;

    public Model_KhachHang(int maTK, String anhKH, String tenKH, String SDTKH, String diaChiKH) {
        MaTK = maTK;
        AnhKH = anhKH;
        TenKH = tenKH;
        this.SDTKH = SDTKH;
        DiaChiKH = diaChiKH;
    }

    public Model_KhachHang(int maKH) {
        MaKH = maKH;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int maTK) {
        MaTK = maTK;
    }

    public String getAnhKH() {
        return AnhKH;
    }

    public void setAnhKH(String anhKH) {
        AnhKH = anhKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getSDTKH() {
        return SDTKH;
    }

    public void setSDTKH(String SDTKH) {
        this.SDTKH = SDTKH;
    }

    public String getDiaChiKH() {
        return DiaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        DiaChiKH = diaChiKH;
    }
}
