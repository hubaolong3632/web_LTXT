package qqzone.Modio;

import java.util.Date;

public class UserDetail { //个人信息
    private Integer id;
    private String realName;
    private String tel;
    private String email;
    private String birte;
    private Date birth;
    private String star;


    public UserDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirte() {
        return birte;
    }

    public void setBirte(String birte) {
        this.birte = birte;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }
}
