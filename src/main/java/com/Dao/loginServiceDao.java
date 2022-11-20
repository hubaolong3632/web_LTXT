package com.Dao;

import com.Iservice.IServiceDao;

import com.Model.*;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

//多个层都使用一个dao实现
@Component("loginDao")
public class loginServiceDao implements IServiceDao {
    @Resource
    JdbcTemplate jdbc_link; //注入



    //判断账号密码的登录
    @Override
    public LoginModel user_pwd(LoginModel pas){
        System.out.println("006: dao-判断账号是否登入成功>");
//        System.out.println(pas.getName()+"    "+pas.getPassword());
        try{
            String sql2="SELECT * FROM `t_login` where name =? and password=?;";//
            RowMapper<LoginModel> pasword=new BeanPropertyRowMapper(LoginModel.class); //获取Pasowrd类
            LoginModel  query2 = jdbc_link.queryForObject(sql2, pasword,pas.getName(),pas.getPassword()); //查询返回对象

            InfoModel model = getInfoModel(query2); //查询个信息
//            System.out.println("当前个人信息:"+model.getHeadimg()+"    "+model.getUname());
            pas.setInfo(model); //提交上去


            return pas;
        }catch (Exception e){ //否则返回的是spring数据库连接错误
            System.out.println("当前用户进行了登入但是 账号密码错误了！");
//            e.printStackTrace();
            return null;
        }
    }

    @Override
    public LoginModel user_zc(LoginModel pas){ //判断是否有当前姓名了
        System.out.println("输出名称："+pas.getName());
        try{
            String sql2="SELECT * FROM `t_login` where name =? ;";
            RowMapper<LoginModel> pasword=new BeanPropertyRowMapper(LoginModel.class); //获取Pasowrd类
            LoginModel  query2 = jdbc_link.queryForObject(sql2, pasword,pas.getName()); //查询返回对象

            return query2;
        }catch (Exception e){ //否则返回的是spring数据库连接错误
//            e.printStackTrace();
            System.out.println("002 :  查询到当前数据库没有当前用户 进行用户的保存");
            return null; //
        }
    }



    //添加用户信息
    @Override
    public boolean addInfo(LoginModel login) {
        System.out.println("-----查询------");
        //传入 手机号 邮箱
        try{

//            LoginModel loginModel = user_zc(login); //查询账号密码是否存在  如果抛出了异常那么代表 1.没查询到  2.添加相同的主键了！
//            if(loginModel==null){ //如果不存在当前账号
            InfoModel info = login.getInfo(); // 获取个人信息
            String sqlLogin=" insert into t_login (name,password) VALUES (?,?);"; //插入账号密码的
            String sqlInfo=" insert into `t_info` (phone,email,headimg,fins,uname) VALUES (?,?,?,?,?);";
            System.out.println(info.getPhone()+"   "+info.getEmail()+"   "+info.getHeadimg()+"   "+login.getName()+"   "+login.getPassword());

            int num = jdbc_link.update(sqlLogin,login.getName(),login.getPassword()); //添加账号密码
            int num1 = jdbc_link.update(sqlInfo,info.getPhone(),info.getEmail(), info.getHeadimg(),0,login.getName()); //添加个人信息
            System.out.println(num1);
            if(num1!=0){ //如果注册成功
                System.out.println("注册成功");
                return true;
            }


//            }
            System.out.println("注册失败:由于姓名已经存在");
            return false;
        }catch (Exception e){
            e.printStackTrace(); //500错误好看一点
            System.out.println("注册失败2：未知错误");
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

    //通过分区查询数据
    @Override
    public ClassLfyModel getCount(ClassLfyModel classlfy) {
//        System.out.println(classlfy.getName());
        String sql = "select count(classify) as 'classify'  from t_myarticle where classify=?;";
        BeanPropertyRowMapper<ClassLfyModel> classflyBean = new BeanPropertyRowMapper<>(ClassLfyModel.class);
        classlfy = jdbc_link.queryForObject(sql, classflyBean,classlfy.getName());
//        System.out.println("classlfy = "+classlfy.getClassify());
        return classlfy;
    }

    //区分文章方法
    @Override
    public List<MyarticleModel> diArticles(MyarticleModel model) {
        String sql = "select * FROM t_myarticle where classify = ? ; ";
        System.out.println(sql);
//        System.out.println(111);
        System.out.println(model.getClassify().getName());
        BeanPropertyRowMapper<MyarticleModel> myarticlemodel = new BeanPropertyRowMapper<>(MyarticleModel.class);
        List<MyarticleModel> list= jdbc_link.query(sql,myarticlemodel,model.getClassify().getName());

        return list;
    }

    //根据姓名查文章
    @Override
    public List<MyarticleModel> queryName(MyarticleModel model) {
        String sql = "select * FROM t_myarticle where uname = ? ; ";
//        System.out.println(sql);
//        System.out.println(model.getClassify().getName());
        BeanPropertyRowMapper<MyarticleModel> myarticlemodel = new BeanPropertyRowMapper<>(MyarticleModel.class);
        List<MyarticleModel> list= jdbc_link.query(sql,myarticlemodel,model.getUname());
        return list;
    }

    @Override
    //添加文章方法
    public boolean addMyarticle(MyarticleModel model){
        String sql = "insert into t_myarticle(uname,theme,content,likenum,collection,classify,postdate) values (?,?,?,?,?,?,?);";

//        System.out.println("insert into t_myarticle(uname,theme,content,likenum,collection,classify,postdate) values (\""+model.getUname()+"\",\""+model.getTheme()+"\",\""+model.getContent()+"\",\""+model.getLikenum()+"\","+model.getCollection()+","+model.getClassify().getName()+",\""+model.getPostdate()+"\");");
        try{
            int num =  jdbc_link.update(sql,model.getUname(),model.getTheme(),model.getContent(),model.getLikenum(),model.getCollection(),model.getClassify().getName(),model.getPostdate());
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


    //根据登录表查找信息表
    @Override
    public InfoModel getInfoModel(LoginModel loginModel){
        String sql = "select id, phone ,email ,headimg, fins ,uname from `t_info` where `uname` = ?";
        //<泛型约束>，(告诉spring要把哪个类进行spring的注入)
        BeanPropertyRowMapper<InfoModel> info = new BeanPropertyRowMapper<>(InfoModel.class);
        return  jdbc_link.queryForObject(sql,info,loginModel.getName());
    }

    //根据姓名查询头像
    @Override
    public List<InfoModel> name_headImg(LoginModel loginModel){
        String sql = "select headimg from `t_info` where `uname` = ?";
        return jdbc_link.query(sql,new BeanPropertyRowMapper<>(),loginModel.getName());
    }

    //根据文章主题模糊查询内容,返回多篇文章
    @Override
    public List<MyarticleModel> getContent(MyarticleModel theme){
        String sql = "select content from `t_myarticle` where theme like '%"+theme.getTheme()+"%'";
        return jdbc_link.query(sql,new BeanPropertyRowMapper<>(MyarticleModel.class) ,theme.getTheme());
    }
    //
    @Test
    public void abc(){
        System.out.println("11");////
//
    }

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
