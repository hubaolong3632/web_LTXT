package com.Model;

import java.util.Date;

/*
* 我的文章模型层
* */
public class MyarticleModel {

    private int id;//id编号
    private String uname; //文章发表人
    private String theme; //文章主题
    private String content; //文章内容
    private Integer likenum; //点赞数
    private Integer collection; //收藏数
    private ClassLfyModel  classify; //分类
    private Date postdate; //时间

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

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public MyarticleModel() { //spring框架反射需要
    }
    public MyarticleModel(int id, String uname, String theme, String content, Integer likenum, Integer collection, ClassLfyModel classify, Date postdate) {
        this.id = id;
        this.uname = uname;
        this.theme = theme;
        this.content = content;
        this.likenum = likenum;
        this.collection = collection;
        this.classify = classify;
        this.postdate = postdate;
    }

}
