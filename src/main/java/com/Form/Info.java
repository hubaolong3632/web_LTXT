package com.Form;

public class Info extends Father {
    private int id;
    private String name; //�˺�
    private String password; //����
    private String phone; //�ֻ���
    private String email; //�ʼ�
    private String headimg; //ͷ��
    private int fins; //������


    public Info() {
    }

    public Info(String name, String password, String phone, String email, String headimg) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.headimg = headimg;
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
}
