package com.Dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@PropertySource("classpath:jdbc.properties") //导入配置文件路径
public class Sdao_jdbc_link {
    @Value("${jdbc.jdbcurl}")
    String jdbcurl;

    @Value("${jdbc.driver}")
    String driver;

    @Value("${jdbc.user}")
    String user;

    @Value("${jdbc.password}")
    String password;


    @Bean(name="dataSource") //使用bean方法调用dataSource方法
    public DataSource DaoLink(){
//        System.out.println(jdbcurl+"  ----  "+driver);

        System.out.println("1");
        DruidDataSource dataSource=new DruidDataSource();
//        dataSource.setDriverClassName(driver); //配置类地址
        dataSource.setDriverClassName(driver); //配置类地址
//        Driver driver=new com.mysql.cj.jdbc.Driver(); //最后应该Driver最后导入一下

        dataSource.setUrl(jdbcurl); //连接串
        dataSource.setUsername(user); //账号
        dataSource.setPassword(password); //密码
        return dataSource;
    }

    @Bean(name="jdbcTemplate")
    public JdbcTemplate createLink(DataSource dataSource){ //导出去
        System.out.println("2");
        return new JdbcTemplate(dataSource);
    }


}
