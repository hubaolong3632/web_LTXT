package com.Form;
// ���ڱ� ͳ�Ƶ�ǰ�û��������� ��ǰ���µ�����
public class ClassLfy extends Father{
    public String id;
    public String name; //��ѯ��ǰ�û�������������
    public String classify; // ��ǰ���ڵ���������

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
