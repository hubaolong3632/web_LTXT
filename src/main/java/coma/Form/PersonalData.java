package coma.Form;

//
public class PersonalData extends  Father{
    private String name; //获取名称
    private String content; //获取内容

    public PersonalData() {
    }

    public PersonalData(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
