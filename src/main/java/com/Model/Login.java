package com.Model;

import java.util.List;

public class Login extends Father{
    private int id;
    private String name; //账号
    private String password; //密码
    private Info info; //信息 (一对一的关系)

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }



    public Login() {
    }

    public Login(String name, String password) {
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
