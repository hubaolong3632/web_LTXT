package com.Iservice;

import com.Model.Info;
import com.Model.Login;

public interface IDao {
        Login user_pwd (Login login); //判断账号用户名的登录
         Info addInfo(Info info);//添加用户信息
}
