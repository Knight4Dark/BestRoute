package org.example.models;

public class Driver implements User {
    private String name;
    private GeoPoint location;

    public String getName() {
        return name;
    }

    public Driver(String name, GeoPoint location) {
        this.name = name;
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }
}
