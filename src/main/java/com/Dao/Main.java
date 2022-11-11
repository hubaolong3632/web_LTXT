package com.Dao;

import com.Form.Info;
import com.Form.Login;
import com.Iservice.IServiceDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Map;

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
//
//         int num = login.addInfo(new Info("18762893132", "3142436228@qq.com",
//                "\"C:\\Users\\lxy\\Desktop\\网页\\作业\\素材\\农业网站版本四\\0首页.jpg\""
//                ));
        if(num>0){
            System.out.println("添加信息成功");
        }else{
            System.out.println("添加信息失败");
        }

        int num1 = login.addLogin(new Login("123","456"));
        if(num1 > 0 ){
            System.out.println("success");
        } else{
            System.out.println("errer");
        }


        //map是list里面的一个值
        List<Map<String, Object>> goodfriend = login.goodfriend("张三");
        System.out.println("好友列表:"+goodfriend);
    }
}
