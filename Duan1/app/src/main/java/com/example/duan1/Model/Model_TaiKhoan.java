package com.example.duan1.Model;

public class Model_TaiKhoan {

    private int MaTK;
    private String TaiKhoan, MatKhau, SDT;

    public Model_TaiKhoan(String taiKhoan, String matKhau, String SDT) {
        TaiKhoan = taiKhoan;
        MatKhau = matKhau;
        this.SDT = SDT;
    }

    public Model_TaiKhoan() {
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int maTK) {
        MaTK = maTK;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        TaiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
