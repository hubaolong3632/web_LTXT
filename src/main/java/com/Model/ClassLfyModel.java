package com.Model;
// ����ͳ������
public class ClassLfyModel {
    public String id;
    public String name; //��ѯ��ǰ��ѯ����
    public int classify; // ��ǰ���ڵ���������

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
