package com.example.duan1.Model;

public class TaiKhoan {
    private int MaTK, SDT;
    private String taiKhoan, matKhau;

    public TaiKhoan(int maTK, String taiKhoan, String matKhau, int SDT) {
        this.MaTK = maTK;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.SDT = SDT;
    }

    public TaiKhoan() {
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int maTK) {
        MaTK = maTK;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }
}
