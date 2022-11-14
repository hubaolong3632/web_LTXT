package com.Dao;

import com.Form.Login;
import com.Iservice.IServiceDao;

import com.Model.*;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

//多个层都使用一个dao实现
@Component("loginDao")
public class loginServiceDao implements IServiceDao {
    @Resource
    JdbcTemplate jdbc_link; //注入

    //判断账号密码的登录
    @Override
    public LoginModel user_pwd(LoginModel pas){
        System.out.println(pas.getName()+"    "+pas.getPassword());
        try{
            String sql2="SELECT * FROM `t_login` where name =? and password=?;";
            RowMapper<LoginModel> pasword=new BeanPropertyRowMapper(LoginModel.class); //获取Pasowrd类
            LoginModel  query2 = jdbc_link.queryForObject(sql2, pasword,pas.getName(),pas.getPassword()); //查询返回对象

            return query2;
        }catch (Exception e){ //否则返回的是spring数据库连接错误
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public LoginModel user_zc(LoginModel pas){
        System.out.println(pas.getName());
        try{
            String sql2="SELECT * FROM `t_login` where name =? ;";
            RowMapper<LoginModel> pasword=new BeanPropertyRowMapper(LoginModel.class); //获取Pasowrd类
            LoginModel  query2 = jdbc_link.queryForObject(sql2, pasword,pas.getName()); //查询返回对象

            return query2;
        }catch (Exception e){ //否则返回的是spring数据库连接错误
            e.printStackTrace();
            return null;
        }
    }

    //添加用户信息
    @Override
    public boolean addInfo(LoginModel login) {
        System.out.println("-----查询手机------");
         //传入 手机号 邮箱
        try{

            LoginModel loginModel = user_pwd(login); //查询账号密码是否存在

            if(loginModel==null){ //如果不存在当前账号
                InfoModel info = login.getInfo(); // 获取个人信息

                String sqlLogin=" insert into t_login (name,password) VALUES (?,?);"; //插入账号密码的
                String sqlInfo=" insert into `t_info` (phone,email,headimg,uname) VALUES (?,?,?,?);";
                System.out.println(info.getPhone()+"   "+info.getEmail()+"   "+info.getHeadimg()+"   "+login.getName()+"   "+login.getPassword());

                int num = jdbc_link.update(sqlLogin,login.getName(),login.getPassword()); //添加账号密码
                int num1 = jdbc_link.update(sqlInfo,info.getPhone(),info.getEmail(), info.getHeadimg(),login.getName()); //添加个人信息
                System.out.println(num1);
                if(num1!=0){ //如果注册成功
                    System.out.println("注册成功");
                    return true;
                }


            }
            System.out.println("注册失败1");
            return false;
        }catch (Exception e){
            e.printStackTrace(); //500错误好看一点
            System.out.println("注册失败2");
            return false;
        }


    }

    //添加用户登录
    @Override
    public int addLogin(LoginModel login) {
        String sqlLogin = "insert into `t_login`(`name`,`password`) VALUES(?,?); ";
        System.out.println(sqlLogin);
        Object[] objLogin = new Object[]{
                login.getName(),
                login.getPassword()
        };
        int num = jdbc_link.update(sqlLogin,objLogin);
        return num;
    }

    @Override
    public List<GoodFriendModel> goodfriend(LoginModel login) {
        String sql = "select * from t_goodfriend where uname=?";


        List<GoodFriendModel> query = jdbc_link.query(sql, new BeanPropertyRowMapper<>(GoodFriendModel.class),login.getName());
        for (GoodFriendModel model : query) {
            System.out.println("姓名： "+model.getFname()+" 好友id：   "+model.getId());
        }

        return query;
    }

    @Override
    public ClassLfyModel getCount(ClassLfyModel classlfy) {
//        System.out.println(classlfy.getName());
        String sql = "select count(classify) as 'classify'  from t_myarticle where classify=?;";
        BeanPropertyRowMapper<ClassLfyModel> classflyBean = new BeanPropertyRowMapper<>(ClassLfyModel.class);
        classlfy = jdbc_link.queryForObject(sql, classflyBean,classlfy.getName());
//        System.out.println(classlfy.getClassify());
        return classlfy;
    }

    //区分文章方法
    @Override
    public List<MyarticleModel> diArticles(MyarticleModel model) {
        String sql = "select * FROM t_myarticle where classify = ? ; ";
        System.out.println(sql);
        System.out.println(model.getClassify().getName());
        BeanPropertyRowMapper<MyarticleModel> myarticlemodel = new BeanPropertyRowMapper<>(MyarticleModel.class);
        List<MyarticleModel> list= jdbc_link.query(sql,myarticlemodel,model.getClassify().getName());

        return list;
    }

    @Override
    //添加文章方法
    public boolean addMyarticle(MyarticleModel model){
        String sql = "insert into t_myarticle(uname,theme,content,likenum,collection,classify,postdate) values (?,?,?,?,?,?,?);";

        try{
            int num =  jdbc_link.update(sql,model.getUname(),model.getTheme(),model.getContent(),model.getClassify(),model.getPostdate());
            if(num != 0){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        return false;
    }

    //修改点赞数和收藏数
    @Override
    public Boolean updateNumColl(MyarticleModel model){
        try {
            String sql = "UPDATE `t_myarticle` SET likenum = ?, collection =? WHERE id = ?;";
            BeanPropertyRowMapper<MyarticleModel> mapper = new BeanPropertyRowMapper<>(MyarticleModel.class);
            jdbc_link.update(sql,mapper,model.getLikenum(),model.getCollection(),model.getId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
//    public boolean password(Login login){  //查询站好密码
//        //用来遍历数据库所有的   where 指定的
//        String sql="SELECT * FROM `cheshibiao`";
//        System.out.println(sql);
//        RowMapper<Login> pasword=new BeanPropertyRowMapper(Login.class); //获取Login类
//
//        List<Login> query = jdbc_link.query(sql, pasword);  //获取一个list集合包含了数据库对应名称的数据
//        for (Login p1 : query) {
//            System.out.println(p1.getId()+"     "+p1.getName()+"  ---  "+p1.getPassword());
//        }
//
//       //查找一个数据
//        String sql2="SELECT * FROM `t_login` where name =?;";
//        Login query2 = jdbc_link.queryForObject(sql2, pasword,"李四");
//        System.out.println(query2.getName()+"--*--"+query2.getPassword());
//
////        for (Map<String, Object> map : jdbc_link.queryForList(sql)) {
////            return true;
////        }
//        return false;
//    }

@Test
public void abc(){
    System.out.println("11");
}

}
