package com.Web;

import com.Form.Father;
import com.Form.Login;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;

import com.Model.LoginModel;
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

        LoginModel loginModel=new LoginModel(login.getName(),login.getPassword()); //转换成model层
        LoginModel from = dao.user_pwd(loginModel); //放入账号密码进行判断

        System.out.println("查找到的头像:"+from.getInfo().getHeadimg());

        if(from==null){ //如果数据库不存在当前用户
            req.getSession().setAttribute("no","登入失败当前账号或者密码错误！！！"); //保存账号密码
             main.processTemplate("login",req,resp); //跳转指定网站
        }else{



            System.out.println("005-Action: 登入的账号为:"+from.getName()+"  密码为:"+from.getPassword()+"     \n 图片位置为:"+from.getInfo().getHeadimg()); //测试当前账号密码是
            req.getSession().setAttribute("login",from); //保存账号密码
            System.out.println("006-Action: 下一个跳转的网页:"+pzwj.getLiu());

            resp.sendRedirect(pzwj.getLiu()); //登入成功跳转到指定网页



        }


    }
}
