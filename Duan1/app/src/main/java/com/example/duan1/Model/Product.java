package com.example.duan1.Model;

public class Product {
    private int img;
    private String name;
    private int price;
    private boolean checkBox;

    public Product(int img, String name, int price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public Product(int img, String name, int price, boolean checkBox) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.checkBox = checkBox;
    }

    public Product() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }
}
