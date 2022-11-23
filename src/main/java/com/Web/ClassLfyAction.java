package com.Web;

import com.Form.Father;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Service.Main01Filter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//跳转界面
@Component("ClassLfyAction")
public class ClassLfyAction extends Action{

    @Resource
    IServiceDao dao; //数据库层

    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {

        System.out.println("----------ClassLfyAction-----------");
        main.processTemplate(pzwj.getLiu(),req,resp); //跳转网页
    }
}
