package com.Iservice;


import com.Form.Info;
import com.Form.Login;

public interface IServiceDao {
        Login user_pwd (Login login); //判断账号用户名的登录
        int addInfo(Info info);//添加用户信息
        int addLogin(Login login);//添加用户
}
