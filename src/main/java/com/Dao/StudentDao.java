package com.Dao;

import com.Iservice.IStudentDao;
import com.Model.PasWord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentdao")
public class StudentDao   implements IStudentDao {
    @Autowired
    JdbcTemplate jdbc_link; //注入


    public void addStudent(String name,String borrowBooks) {//添加
        String sql=" insert into t_user_basic(loginid,nickName,pwd,heagime) VALUES (1,1,1,1);";
        jdbc_link.update(sql);

    }

    public boolean password(PasWord st){  //查询站好密码



        //用来遍历数据库所有的   where 指定的
        String sql="SELECT * FROM `cheshibiao`";
        System.out.println(sql);
        RowMapper<PasWord> pasword=new BeanPropertyRowMapper(PasWord.class); //获取Pasowrd类

        List<PasWord> query = jdbc_link.query(sql, pasword);  //获取一个list集合包含了数据库对应名称的数据
        for (PasWord p1 : query) {
            System.out.println(p1.getId()+"     "+p1.getName()+"  ---  "+p1.getPasword());
        }

        ///////////////////




       //查找一个数据
        String sql2="SELECT * FROM `cheshibiao` where name =?;";
        PasWord query2 = jdbc_link.queryForObject(sql2, pasword,"李四");
        System.out.println(query2.getName()+"--*--"+query2.getPasword());

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
