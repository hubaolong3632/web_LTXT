package com.Form;

import com.Model.ClassLfyModel;

public class Myarticle extends Father{    //û�й�����ϵ��ֻ��string����

    private String headline; //��������
    private String message; //�������� һ����˵��һ��html����
    private String classify; //����

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
