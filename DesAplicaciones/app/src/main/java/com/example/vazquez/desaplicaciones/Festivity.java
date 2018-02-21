package com.example.vazquez.desaplicaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Festivity  {
    private int imageId;
    private String name;
    private String location;
    private String type;

    public Festivity(int imageId, String name, String location, String type){
        this.imageId = imageId;
        this.name = name;
        this.location = location;
        this.type = type;
    }

    public Festivity(){
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
