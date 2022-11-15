package com.Iservice;


import com.Model.ClassLfyModel;
import com.Model.GoodFriendModel;
import com.Model.LoginModel;
import com.Model.MyarticleModel;

import java.util.List;
public interface IServiceDao {
        LoginModel user_pwd (LoginModel login); //判断账号用户名的登录

        LoginModel user_zc(LoginModel pas); //注册

        boolean addInfo(LoginModel info);//添加用户信息
        int addLogin(LoginModel login);//添加用户
        List<GoodFriendModel> goodfriend(LoginModel name);//查询好友列表

        ClassLfyModel getCount(ClassLfyModel name);//根据主题名称分类

        List<MyarticleModel> diArticles(MyarticleModel model);//根据主题名称分类(注释问题也会上传)

        //添加文章方法
        boolean addMyarticle(MyarticleModel model);


        //修改点赞数和收藏数
        Boolean updateNumColl(MyarticleModel model);
}
