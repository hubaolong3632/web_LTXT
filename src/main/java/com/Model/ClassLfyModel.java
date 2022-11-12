package com.Model;
// 用于统计数量
public class ClassLfyModel {
    public String id;
    public String name; //查询当前用户发送文章数量
    public String classify; // 当前分期的文章数量

    public ClassLfyModel() {
    }

    public ClassLfyModel(String name, String classify) {
        this.name = name;
        this.classify = classify;
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
