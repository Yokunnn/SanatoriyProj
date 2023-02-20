package com.example.sanatoriyproj.model;

public class User {
    private int ID;
    private String FIO;
    private String email;
    private String address;

    public User(String FIO, String email, String address) {
        this.FIO = FIO;
        this.email = email;
        this.address = address;
    }

    public User() {
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getFIO() {
        return FIO;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", FIO='" + FIO + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
