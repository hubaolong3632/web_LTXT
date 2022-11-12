package com.Model;

public class GoodFriendModel {
    private int id;
    private String fname;



    public GoodFriendModel() {
    }

    public GoodFriendModel(int id, String fname) {
        this.id = id;
        this.fname = fname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }




}
