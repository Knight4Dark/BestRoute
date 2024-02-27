package org.example.models;

import org.example.models.GeoPoint;
import org.example.models.User;

public class Restaurant implements User {
    private String name;
    private int prepTime;

    private GeoPoint location;

    public Restaurant(String name, int prepTime, GeoPoint location) {
        this.name = name;
        this.prepTime = prepTime;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }
}
