package com.example.duan1.Model;

public class TheLoai {
    private int MaTL;
    private String tenTl;

    public TheLoai(int maTL, String tenTl) {
        MaTL = maTL;
        this.tenTl = tenTl;
    }

    public TheLoai() {
    }

    public int getMaTL() {
        return MaTL;
    }

    public void setMaTL(int maTL) {
        MaTL = maTL;
    }

    public String getTenTl() {
        return tenTl;
    }

    public void setTenTl(String tenTl) {
        this.tenTl = tenTl;
    }
}
