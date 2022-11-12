package com.Model;
// 用于统计数量
public class ClassLfyModel {
    public String id;
    public String name; //查询当前查询分区
    public int classify; // 当前分期的文章数量

    public ClassLfyModel() {
    }

    public ClassLfyModel(String name, int classify) {
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

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }
}
