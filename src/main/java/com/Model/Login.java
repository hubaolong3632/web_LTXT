package com.Model;

public class Login extends Father{
    private int id;
    private String name;
    private String pasword;

    public Login() {
    }

    public Login(String name, String pasword) {
        this.name = name;
        this.pasword = pasword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
