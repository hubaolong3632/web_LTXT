package com.Model;

//用于错误信息的判断
public class NoModel {
  private String no;
  private Object class1;

    public NoModel(String no, Object class1) {
        this.no = no;
        this.class1 = class1;
    }

    public Object getClass1() {
        return class1;
    }

    public void setClass1(Object class1) {
        this.class1 = class1;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
