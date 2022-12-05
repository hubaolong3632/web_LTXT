package coma.Model;

public class InfoModel {   //注册类
    private int id;
    private String phone; //手机号
    private String email; //邮件
    private String headimg; //头像
    private String fins; //点赞数
    private String uname; //一对多，在写sql语句根本用不上
//    private List<Myantecle> myantecles;




    public InfoModel() {
    }

    public InfoModel(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getFins() {
        return fins;
    }

    public void setFins(String fins) {
        this.fins = fins;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public InfoModel(String phone, String email, String headimg) {

        this.phone = phone;
        this.email = email;
        this.headimg = headimg;

    }

    public InfoModel(String phone, String email, String headimg, String fins, String uname) {

        this.phone = phone;
        this.email = email;
        this.headimg = headimg;
        this.fins = fins;
        this.uname = uname;
    }



}
