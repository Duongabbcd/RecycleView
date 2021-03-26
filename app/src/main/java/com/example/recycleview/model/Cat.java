package com.example.recycleview.model;

public class Cat {
    private int image ;
    private String name,price,subs;

    public Cat(int image, String name, String price, String subs) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.subs = subs;
    }

    public Cat(String s, String name, String price, String subs) {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSubs() {
        return subs;
    }

    public void setSubs(String subs) {
        this.subs = subs;
    }

}
