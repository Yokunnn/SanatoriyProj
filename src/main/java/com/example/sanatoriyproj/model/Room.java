package com.example.sanatoriyproj.model;

public class Room {
    private int ID;
    private int buildingID;
    private String type;
    private String condition;
    private int bedNum;
    private int floor;

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }
    public int getBuildingID() {
        return buildingID;
    }
    public int getID() {
        return ID;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public int getBedNum() {
        return bedNum;
    }
    public int getFloor() {
        return floor;
    }
    public String getCondition() {
        return condition;
    }
    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "ID=" + ID +
                ", buildingID=" + buildingID +
                ", type='" + type + '\'' +
                ", condition='" + condition + '\'' +
                ", bedNum=" + bedNum +
                ", floor=" + floor +
                '}';
    }
}
