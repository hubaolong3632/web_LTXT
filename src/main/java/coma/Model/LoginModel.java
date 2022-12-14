package coma.Model;


import java.util.List;

public class LoginModel {
    private int id;
    private String name; //账号
    private String password; //密码
    private InfoModel info; //个人信息
    private List<MyarticleModel> models; //当前界面的说说
    private List<GoodFriendModel> getFriend; //自己的所有好友

//  private List<>
    public LoginModel() {
    }

    public LoginModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public LoginModel(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public LoginModel(String name, String password, InfoModel info) {
        this.name = name;
        this.password = password;
        this.info = info;
    }



    public List<GoodFriendModel> getGetFriend() {
        return getFriend;
    }

    public void setGetFriend(List<GoodFriendModel> getFriend) {
        this.getFriend = getFriend;
    }

    public List<MyarticleModel> getModels() {
        return models;
    }

    public void setModels(List<MyarticleModel> models) {
        this.models = models;
    }

    public InfoModel getInfo() {
        return info;
    }

    public void setInfo(InfoModel info) {
        this.info = info;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
