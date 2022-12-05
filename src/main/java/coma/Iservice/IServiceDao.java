package coma.Iservice;



import coma.Model.*;

import java.util.List;
public interface IServiceDao {
        boolean like(LikeModio like);

        boolean collection(Collection collection);

        LoginModel user_pwd (LoginModel login); //判断账号用户名的登录

        LoginModel user_zc(LoginModel pas); //注册

        boolean addInfo(LoginModel info);//添加用户信息

        int addLogin(LoginModel login);//添加用户
        List<GoodFriendModel> goodfriend(LoginModel name);//查询好友列表

        ClassLfyModel getCount(ClassLfyModel name);//根据主题名称分类

        List<MyarticleModel> diArticles(MyarticleModel model);//根据主题名称分类(注释问题也会上传)

        //根据姓名查文章
        List<MyarticleModel> queryName(MyarticleModel model);

        //添加文章方法
        boolean addMyarticle(MyarticleModel model);

        //修改点赞数和收藏数
        Boolean updateNumColl(MyarticleModel model);

        InfoModel getInfoModel(LoginModel loginModel);

        //根据姓名查询头像
        List<InfoModel> name_headImg(LoginModel loginModel);

        //根据文章主题模糊查询内容
        List<MyarticleModel> getContent(MyarticleModel theme);

        //查询所有的好友集合
        List<GoodFriendModel> getFriend(GoodFriendModel name);
}
