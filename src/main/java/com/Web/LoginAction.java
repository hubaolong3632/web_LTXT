package com.Web;

import com.Iservice.IServiceDao;
import com.Model.Father;
import com.Model.Login;
import com.Model.Pzwj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("LoginAction")
public class LoginAction extends Action{

    @Autowired
    IServiceDao dao;
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           Login login= (Login) father; //转换为账号密码类

        Login from = dao.user_pwd(login); //放入账号密码进行判断
        System.out.println("5555");
        if(from==null){
            System.out.println("当前并没有此账号");
        }else{
            System.out.println(from.getName()+"  ---- "+from.getPassword());
        }

        System.out.println("有木有成功");
        req.getRequestDispatcher(pzwj.getLiu()).forward(req,resp);//跳转
    }
}
