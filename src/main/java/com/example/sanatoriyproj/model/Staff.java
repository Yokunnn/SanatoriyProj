package com.example.sanatoriyproj.model;

public class Staff {
    private int ID;
    private String FIO;
    private String post;
    private int salary;

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
    public void setFIO(String FIO) {
        this.FIO = FIO;
    }
    public String getFIO() {
        return FIO;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public String getPost() {
        return post;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "ID=" + ID +
                ", FIO='" + FIO + '\'' +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                '}';
    }
}
