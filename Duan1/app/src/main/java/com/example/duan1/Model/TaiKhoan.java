package com.example.duan1.Model;

import java.util.HashMap;

public class TaiKhoan {
    private int MaTK, SDT;
    private String taiKhoan, matKhau;

    public TaiKhoan(int maTK, String taiKhoan, String matKhau, int SDT) {
        this.MaTK = maTK;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.SDT = SDT;
    }

    public TaiKhoan(int SDT, String taiKhoan, String matKhau) {
        this.SDT = SDT;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
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

    public HashMap<String, Object> canvert(){
        HashMap<String, Object> work = new HashMap<>();
        work.put("taiKhoan", taiKhoan);
        work.put(matKhau, matKhau);
        work.put("SDT", SDT);

        return work;
    }
}
