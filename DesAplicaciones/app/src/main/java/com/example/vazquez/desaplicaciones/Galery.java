package com.example.vazquez.desaplicaciones;

public class Galery {

    private int imageId;
    private String name;


    public Galery(int imageId , String name){

        this.imageId = imageId;
        this.name = name;

    }


    public Galery(){
        this(R.mipmap.ic_launcher_round, "unamed");
    }

    public int getImageId() {
        return imageId;
    }
    public String getName() {
        return name;
    }


}
