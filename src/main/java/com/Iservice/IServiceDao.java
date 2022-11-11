package com.Iservice;


import com.Form.Info;
import com.Form.Login;
import com.Model.LoginModel;

import java.util.List;
import java.util.Map;

public interface IServiceDao {
        LoginModel user_pwd (LoginModel login); //判断账号用户名的登录
        boolean addInfo(LoginModel info);//添加用户信息
        int addLogin(LoginModel login);//添加用户
        List<Map<String, Object>> goodfriend(String name);//查询好友列表
}
