package com.Form;

import com.Model.ClassLfyModel;

public class Myarticle extends Father{    //没有关联关系，只有string类型

    private String headline; //文章主题
    private String message; //文章内容 一般来说是一条html代码
    private String classify; //分区

    public Myarticle() {
    }


    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
}
