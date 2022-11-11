package com.Form;

public class Pzwj  extends Father {

    private String value;//值
    private String yi;//com.Model.PasWord
    private String er;/// 1
    private String san;///login.jsp
    private String si;// 1
    private String wu;///LoginAction
    private String liu;// /WEB-INF/main.jsp



    public Pzwj() {
    }

    public Pzwj(String value, String yi, String er, String san, String si, String wu, String liu) {
        this.value = value;
        this.yi = yi;
        this.er = er;
        this.san = san;
        this.si = si;
        this.wu = wu;
        this.liu = liu;
    }

    public String getLiu() {
        return liu;
    }

    public void setLiu(String liu) {
        this.liu = liu;
    }

    public Pzwj(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getYi() {
        return yi;
    }

    public void setYi(String yi) {
        this.yi = yi;
    }

    public String getEr() {
        return er;
    }

    public void setEr(String er) {
        this.er = er;
    }

    public String getSan() {
        return san;
    }

    public void setSan(String san) {
        this.san = san;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getWu() {
        return wu;
    }

    public void setWu(String wu) {
        this.wu = wu;
    }
}
