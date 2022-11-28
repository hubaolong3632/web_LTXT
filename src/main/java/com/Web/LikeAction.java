package com.Web;

import com.Form.ClassLfy;
import com.Form.Father;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Model.LikeModio;
import com.Model.LoginModel;
import com.Model.NoModel;
import com.Service.Main01Filter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component("LikeAction")
public class LikeAction extends Action{

    @Resource
    IServiceDao dao; //数据库层

    //点赞功能
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        ClassLfy lfy = (ClassLfy) father;
        LoginModel login = (LoginModel) req.getSession().getAttribute("login");

        if(!dao.like(new LikeModio(login.getName(), lfy.getClassify()))){//执行添加一条记录
            System.out.println("008-已经点赞！"+login.getName()+"  给文章  "+lfy.getClassify());
            req.getSession().setAttribute("json",new NoModel("你已经点过赞了！！！",null));
        }else{
            System.out.println("009-点赞成功!"+login.getName()+"  给文章  "+lfy.getClassify());
            req.getSession().setAttribute("json",new NoModel("点赞成功",null));
        }

        main.processTemplate(pzwj.getLiu(),req,resp); //跳转网页

    }
}
