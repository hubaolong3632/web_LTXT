package com.Model;

public class GoodFriendModel {
    private int id;
    private String uname;
    private String fname;

    public GoodFriendModel(int id, String uname, String fname) {
        this.id = id;
        this.uname = uname;
        this.fname = fname;
    }

    public GoodFriendModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
