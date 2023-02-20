package com.example.sanatoriyproj.model;

import java.util.Date;

public class Office {
    private int ID;
    private int buildingID;
    private Date quartztime;

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
    public Date getQuartztime() {
        return quartztime;
    }
    public int getBuildingID() {
        return buildingID;
    }
    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }
    public void setQuartztime(Date quartztime) {
        this.quartztime = quartztime;
    }

    @Override
    public String toString() {
        return "Office{" +
                "ID=" + ID +
                ", buildingID=" + buildingID +
                ", quartztime=" + quartztime +
                '}';
    }
}
