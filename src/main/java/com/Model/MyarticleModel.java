package com.Model;

import javax.xml.crypto.Data;
import java.util.Date;

/*
* �ҵ�����ģ�Ͳ�
* */
public class MyarticleModel {

    private int id;//id���
    private String uname; //���·�����
    private String theme; //��������
    private String content; //��������
    private Integer likenum; //������
    private Integer collection; //�ղ���
    private ClassLfyModel  classify ; //����
    private String postdate; //ʱ��

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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public ClassLfyModel getClassify() {
        return classify;
    }

    public void setClassify(ClassLfyModel classify) {
        this.classify = classify;
    }


    public MyarticleModel() {
    }




    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public MyarticleModel(ClassLfyModel classify) {

        this.classify = classify;
    }

}
