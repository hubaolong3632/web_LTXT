package qqzone.Iservlce;

import qqzone.Modio.UserBasic;

import java.util.List;

public interface UserBasicDao {
    //根据账号和密码获取用户特定信息
    public UserBasic getUserBAsic(String loginID,String pwd);

    //获取所有好友列表
    public List<UserBasic> getUserBasicList(UserBasic userBasic);

    public UserBasic getUserBasicById(Integer id);
}
