package com.example.sanatoriyproj.model;

public class Building {
    private int ID;
    private String type;
    private int floorNum;

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getID() {
        return ID;
    }
    public int getFloorNum() {
        return floorNum;
    }
    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    @Override
    public String toString() {
        return "Building{" +
                "ID=" + ID +
                ", type='" + type + '\'' +
                ", floorNum=" + floorNum +
                '}';
    }
}
