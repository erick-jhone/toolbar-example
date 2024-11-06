package com.erick.appbarmenuexample.model;

public class ItemList {
    private String data;
    private int image;

    public ItemList(){

    }

    public ItemList(String data, int image){
        this.data = data;
        this.image = image;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
