package com.Model;
// ����ͳ������
public class ClassLfyModel {
    public String id;
    public String name; //��ѯ��ǰ�û�������������
    public String classify; // ��ǰ���ڵ���������

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
