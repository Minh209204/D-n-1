package com.example.duan1.Model;

public class Model_TheLoai {
    private int MaTL;
    private String TenTL;

    public Model_TheLoai(int maTL, String tenTL) {
        MaTL = maTL;
        TenTL = tenTL;
    }

    public Model_TheLoai() {
    }

    public int getMaTL() {
        return MaTL;
    }

    public void setMaTL(int maTL) {
        MaTL = maTL;
    }

    public String getTenTL() {
        return TenTL;
    }

    public void setTenTL(String tenTL) {
        TenTL = tenTL;
    }
}
