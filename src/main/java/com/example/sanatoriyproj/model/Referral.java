package com.example.sanatoriyproj.model;

import java.util.Date;

public class Referral {
    private int ID;
    private int procedureID;
    private int officeID;
    private int ticketID;
    private int staffID;
    private Date datetime;

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
    public Date getDatetime() {
        return datetime;
    }
    public int getOfficeID() {
        return officeID;
    }
    public int getProcedureID() {
        return procedureID;
    }
    public int getStaffID() {
        return staffID;
    }
    public int getTicketID() {
        return ticketID;
    }
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    public void setOfficeID(int officeID) {
        this.officeID = officeID;
    }
    public void setProcedureID(int procedureID) {
        this.procedureID = procedureID;
    }
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    @Override
    public String toString() {
        return "Referral{" +
                "ID=" + ID +
                ", procedureID=" + procedureID +
                ", officeID=" + officeID +
                ", ticketID=" + ticketID +
                ", staffID=" + staffID +
                ", datetime=" + datetime +
                '}';
    }
}
