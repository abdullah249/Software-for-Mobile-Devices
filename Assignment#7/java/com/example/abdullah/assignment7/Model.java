package com.example.abdullah.assignment7;

public class Model {

    int image;
    String name;
    String adress;


    public Model(int image, String name, String adress) {
        this.image = image;
        this.name = name;
        this.adress = adress;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
