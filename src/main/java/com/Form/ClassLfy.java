package com.Form;
// 用于表单
public class ClassLfy {
    public String id;
    public String name;

    public ClassLfy() {
    }

    public ClassLfy(String name) {
        this.name = name;
    }

    public ClassLfy(String id, String name) {
        this.id = id;
        this.name = name;
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
}
