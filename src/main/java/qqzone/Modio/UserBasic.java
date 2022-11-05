package qqzone.Modio;

import java.util.List;

public class UserBasic {  //登入的账号密码

    private Integer id;
    private String  loginID;
    private String  nickName;
    private String pwd;
    private String headImg;

    private  UserDetail userDetail;  //1:1 单个用户信息
    private List<Topic> topicList; //1:N 多个说说
    private List<UserBasic> friendList; // N:M 好友多对多


    public UserBasic(Integer id, String loginID, String nickName, String headImg) {
        this.id = id;
        this.loginID = loginID;
        this.nickName = nickName;
        this.headImg = headImg;
    }

    public UserBasic(Integer id, String loginID, String nickName, String pwd, String headImg) {
        this.id = id;
        this.loginID = loginID;
        this.nickName = nickName;
        this.pwd = pwd;
        this.headImg = headImg;
    }

    public UserBasic() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<UserBasic> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<UserBasic> friendList) {
        this.friendList = friendList;
    }
}
