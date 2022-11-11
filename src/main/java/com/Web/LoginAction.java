package com.Web;

import com.Form.Father;
import com.Form.Login;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;

import com.Service.Main01Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 *登入界面
 */

@Component("LoginAction")
public class LoginAction extends Action{

    @Resource
    IServiceDao dao; //数据库层
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        Login login= (Login) father; //转换为账号密码类
        Login from = dao.user_pwd(login); //放入账号密码进行判断


        if(from==null){
            System.out.println("当前并没有此账号");
            req.getSession().setAttribute("no","登入失败当前账号或者密码错误！！！"); //保存账号密码
             main.processTemplate("login",req,resp); //跳转指定网站
//            req.getRequestDispatcher("/login.html").forward(req,resp);//跳转
        }else{
            System.out.println(from.getName()+"  ---- "+from.getPassword()); //测试当前账号密码是
            req.getSession().setAttribute("login",from); //保存账号密码
            System.out.println("1:"+pzwj.getLiu());


            resp.sendRedirect(pzwj.getLiu()); //登入成功跳转到指定网页



        }


    }
}
