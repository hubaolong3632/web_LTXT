package com.Dao;

import com.Model.PasWord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.Dao")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        StudentDao st = (StudentDao) context.getBean("studentdao");

        PasWord from = st.From(new PasWord("张三", "111e1"));
        if(from==null){
            System.out.println("当前并没有此账号");
        }else{
            System.out.println(from.getName()+"  ---- "+from.getPasword());
        }

    }


}
