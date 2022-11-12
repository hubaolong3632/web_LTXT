package com.Dao;

import com.Form.Login;
import com.Iservice.IServiceDao;
import com.Model.GoodFriendModel;
import com.Model.LoginModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Map;
//
@ComponentScan("com")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        IServiceDao login = (IServiceDao) context.getBean("loginDao");

        LoginModel model = new LoginModel();
        model.setName("张三");
        List<GoodFriendModel> goodfriend = login.goodfriend(model);
        System.out.println("好友列表:"+goodfriend);

    }
}
