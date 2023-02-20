package com.example.sanatoriyproj.model;

import java.sql.Date;

public class Ticket {
    private int ID;
    private String type;
    private int userID;
    private String price;
    private String diet;
    private Date arrivalDate;
    private Date departureDate;

    public Ticket(String type, int userID, String price, String diet, Date arrivalDate, Date departureDate) {
        this.type = type;
        this.userID = userID;
        this.price = price;
        this.diet = diet;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }

    public Ticket() {
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
    public Date getArrivalDate() {
        return arrivalDate;
    }
    public Date getDepartureDate() {
        return departureDate;
    }
    public String getPrice() {
        return price;
    }
    public int getUserID() {
        return userID;
    }
    public String getDiet() {
        return diet;
    }
    public String getType() {
        return type;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
    public void setDiet(String diet) {
        this.diet = diet;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ID=" + ID +
                ", type='" + type + '\'' +
                ", userID=" + userID +
                ", price=" + price +
                ", diet='" + diet + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                '}';
    }
}
