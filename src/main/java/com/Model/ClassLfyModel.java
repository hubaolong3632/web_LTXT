package com.Model;
// 用于下拉框和点击
public class ClassLfyModel {
    public int id;
    public String name;

    public ClassLfyModel() {
    }

    public ClassLfyModel(String name) {
        this.name = name;
    }

    public ClassLfyModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
