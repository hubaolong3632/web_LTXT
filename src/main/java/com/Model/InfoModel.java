package com.Model;

import java.util.List;

public class InfoModel {   //ע����
    private int id;
    private String phone; //�ֻ���
    private String email; //�ʼ�
    private String headimg; //ͷ��
    private int fins; //������
    private String uname; //һ�Զ�




    public InfoModel() {
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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public InfoModel(String phone, String email, String headimg) {

        this.phone = phone;
        this.email = email;
        this.headimg = headimg;

    }

    public InfoModel(String phone, String email, String headimg, int fins, String uname) {

        this.phone = phone;
        this.email = email;
        this.headimg = headimg;
        this.fins = fins;
        this.uname = uname;
    }



}
