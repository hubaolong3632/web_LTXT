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
        st.password(new PasWord());


    }


}
