package com.Dao;

import com.Iservice.IServiceDao;
import com.Model.Info;
import com.Model.Login;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        IServiceDao login = (IServiceDao) context.getBean("loginDao");

        Login from = login.user_pwd(new Login("张三", "111"));
        if(from==null){
            System.out.println("当前并没有此账号");
        }else{
            System.out.println(from.getName()+"  ---- "+from.getPassword());
        }

         int num = login.addInfo(new Info(1,"18762893132", "3142436228@qq.com",
                "\"C:\\Users\\lxy\\Desktop\\网页\\作业\\素材\\农业网站版本四\\0首页.jpg\"", 10, 1
                ));

        if(num > 0 ){
            System.out.println("success");
        } else{
            System.out.println("errer");
        }
    }


}
