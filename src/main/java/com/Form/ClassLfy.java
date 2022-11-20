package com.Form;
// 用于表单 统计当前用户的数量和 当前文章的数量
public class ClassLfy extends Father{
    public String id;
    public String name; //查询当前用户发送文章数量
    public String classify; // 当前分期的文章数量

    public ClassLfy() {
    }

    public ClassLfy(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
}
