package com.Iservice;


import com.Form.Info;
import com.Form.Login;

import java.util.List;
import java.util.Map;

public interface IServiceDao {
        Login user_pwd (Login login); //判断账号用户名的登录
        int addInfo(Info info);//添加用户信息
        int addLogin(Login login);//添加用户
        List<Map<String, Object>> goodfriend(String name);//查询好友列表
}
