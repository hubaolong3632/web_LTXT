package com.Dao;

import com.Form.Info;
import com.Form.Login;
import com.Iservice.IServiceDao;

import com.Model.InfoModel;
import com.Model.LoginModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
            RowMapper<LoginModel> pasword=new BeanPropertyRowMapper(Login.class); //获取Pasowrd类
            LoginModel  query2 = jdbc_link.queryForObject(sql2, pasword,pas.getName(),pas.getPassword()); //查询返回对象

            return query2;
        }catch (Exception e){ //否则返回的是spring数据库连接错误
//            e.printStackTrace();
            return null;
        }
    }

    //添加用户信息
    @Override
    public boolean addInfo(LoginModel login) {
         //传入 手机号 邮箱
        try{

            LoginModel loginModel = user_pwd(login);
            if(loginModel==null){ //如果不存在当前账号
                String sqlInfo=" insert into `t_info` (phone,email,headimg,fins,uname) VALUES (?,?,?,?,?);";
//                System.out.println(sqlInfo);
                InfoModel info = login.getInfo(); // 获取个人信息

                int num = jdbc_link.update(sqlInfo,info.getPhone(),info.getEmail(), info.getHeadimg(),login.getName(),login.getPassword());
                System.out.println(num);
                if(num!=0){ //如果注册失败
                    return true;
                }


            }
            return false;
        }catch (Exception e){
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
    public List<Map<String, Object>> goodfriend(String name) {
        return null;
    }


    public boolean password(Login login){  //查询站好密码
        //用来遍历数据库所有的   where 指定的
        String sql="SELECT * FROM `cheshibiao`";
        System.out.println(sql);
        RowMapper<Login> pasword=new BeanPropertyRowMapper(Login.class); //获取Login类

        List<Login> query = jdbc_link.query(sql, pasword);  //获取一个list集合包含了数据库对应名称的数据
        for (Login p1 : query) {
            System.out.println(p1.getId()+"     "+p1.getName()+"  ---  "+p1.getPassword());
        }





       //查找一个数据

        String sql2="SELECT * FROM `t_login` where name =?;";
        Login query2 = jdbc_link.queryForObject(sql2, pasword,"李四");
        System.out.println(query2.getName()+"--*--"+query2.getPassword());

//        for (Map<String, Object> map : jdbc_link.queryForList(sql)) {
//            return true;
//        }
        return false;
    }

@Test
public void abc(){
    System.out.println("11");
}

}
