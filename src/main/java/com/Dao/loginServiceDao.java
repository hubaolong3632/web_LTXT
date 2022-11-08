package com.Dao;

import com.Iservice.IServiceDao;
import com.Model.Info;
import com.Model.Login;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("loginDao")
public class loginServiceDao implements IServiceDao {
    @Autowired
    JdbcTemplate jdbc_link; //注入


    public void addStudent(String name,String borrowBooks) {//添加
        String sql=" insert into t_user_basic(loginid,nickName,pwd,heagime) VALUES (1,1,1,1);";
        jdbc_link.update(sql);
    }



    @Override
    public Login user_pwd(Login pas){ //账号的登入

        try{
            String sql2="SELECT * FROM `t_login` where name =? and password=?;";
            System.out.println(sql2);
            RowMapper<Login> pasword=new BeanPropertyRowMapper(Login.class); //获取Pasowrd类
            Login  query2 = jdbc_link.queryForObject(sql2, pasword,pas.getName(),pas.getPassword()); //查询返回对象

            return query2;
        }catch (Exception e){ //否则返回的是spring数据库连接错误
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int addInfo(Info info) {
        String sql=" insert into t_info (phone,email,headimg,fins,uname) VALUES (?,?,?,?);";
        Object[] objects = new Object[]{

                info.getPhone(),
                info.getEmail(),
                info.getHeadimg(),
                info.getFins(),
                info.getUname()
        };
         int num = jdbc_link.update(sql, objects);
        return num;
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

        ///////////////////




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
