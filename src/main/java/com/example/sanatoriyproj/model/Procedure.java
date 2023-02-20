package com.example.sanatoriyproj.model;

import java.util.Date;

public class Procedure {
    private int ID;
    private String name;
    private Date datetime;

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    public Date getDatetime() {
        return datetime;
    }
    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
