package com.example.duan1.Model;

public class TaiKhoan {
    private int MaTK;
    private String taiKhoan, matKhau, SDT;

    public TaiKhoan(int maTK, String taiKhoan, String matKhau, String SDT) {
        MaTK = maTK;
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

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
