package coma.Model;
 //保存点赞数据
public class LikeModio {
    private int id;
    private String login_name;  //名称
    private String myarticle_id; // 表id

    public LikeModio() {
    }

    public LikeModio(String login_name, String myarticle_id) {
        this.login_name = login_name;
        this.myarticle_id = myarticle_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getMyarticle_id() {
        return myarticle_id;
    }

    public void setMyarticle_id(String myarticle_id) {
        this.myarticle_id = myarticle_id;
    }
}
