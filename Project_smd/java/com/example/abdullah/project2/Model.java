package com.example.abdullah.project2;

import android.graphics.Bitmap;

public class Model {

    String image;
    String name;
    String adress;

    public Model()
    {}

    public Model(String image, String name, String adress) {
        this.image = image;
        this.name = name;
        this.adress = adress;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
