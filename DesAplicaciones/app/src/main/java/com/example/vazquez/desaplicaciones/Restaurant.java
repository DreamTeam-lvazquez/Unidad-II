package com.example.vazquez.desaplicaciones;

public class Restaurant  {

    private int imageId;
    private String name;
    private String location;
    private String type;

    public Restaurant(int imageId, String name, String location, String type){
        this.imageId = imageId;
        this.name = name;
        this.location = location;
        this.type = type;
    }

    public Restaurant(){
        this(R.mipmap.ic_launcher_round, "unamed", "unlocated", "untype");
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String  getType() {
        return type;
    }
}
