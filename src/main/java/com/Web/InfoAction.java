package com.Web;

import com.Form.Father;
import com.Form.Info;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Model.InfoModel;
import com.Model.LoginModel;
import com.Service.Main01Filter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InfoAction extends Action{
    @Resource
    IServiceDao dao; //数据库
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {

        Info info = (Info) father;

        InfoModel infoModel = new InfoModel(info.getPhone(),info.getEmail(),info.getHeadimg()); //个人信息
        LoginModel loginModel=new LoginModel(info.getName(),info.getPassword(),infoModel); //放入账号密码 (登入表)


        if(dao.addInfo(loginModel)==true){  //登入成功判断
            req.getSession().setAttribute("login",loginModel); //保存账号密码
            System.out.println("1:"+pzwj.getLiu());
            resp.sendRedirect(pzwj.getLiu()); //登入成功跳转到指定网页

        }else{
            main.processTemplate("register",req,resp); //跳转指定网站 (返回当前账号)
            req.getSession().setAttribute("no","注册失败当前已存在此账号!"); //保存账号密码

        }




    }
}
