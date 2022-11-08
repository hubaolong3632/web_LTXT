package com.Model;

public class Info extends Father{
    private int id;
    private String phone;
    private String email;
    private String headimg;
    private int fins;
    private Login uname; //Ò»¶Ô¶à

    public Info() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public int getFins() {
        return fins;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }

    public Login getUname() {
        return uname;
    }

    public void setUname(Login uname) {
        this.uname = uname;
    }



    public Info( int id ,String phone, String email, String headimg, int fins, Login uname) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.headimg = headimg;
        this.fins = fins;
        this.uname = uname;
    }



}
