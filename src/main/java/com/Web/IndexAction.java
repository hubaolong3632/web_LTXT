package com.Web;

import com.Form.Father;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Model.LoginModel;
import com.Service.Main01Filter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 *注册完成之后跳转的登入界面
 */

@Component("IndexAction")
public class IndexAction extends Action{

    @Resource
    IServiceDao dao; //数据库层
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {

        System.out.println("当前是登入首页界面");


//        req.getSession().setAttribute("login",new LoginModel("1","1"));//这样子写就不需要登入了

        System.out.println("2.跳转网站"+pzwj.getLiu());
        main.processTemplate(pzwj.getLiu(),req,resp); //首页显示

    }

}
