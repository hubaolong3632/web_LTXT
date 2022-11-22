package com.Model;
// ???????????
public class ClassLfyModel {
    private String id;
    private String name; //姓名
    private int classify; // 信息

    public ClassLfyModel() {
    }
    public ClassLfyModel(String name) {
        this.name = name;
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
