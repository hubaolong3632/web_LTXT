package com.Dao;

import com.Iservice.IServiceDao;
import com.Model.ClassLfyModel;
import com.Model.MyarticleModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

//
@ComponentScan("com")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        IServiceDao login = (IServiceDao) context.getBean("loginDao");
        ClassLfyModel java = login.getCount(new ClassLfyModel("java"));
        List<MyarticleModel> mysql = login.diArticles(new MyarticleModel(new ClassLfyModel("mysql")));
    }
}



