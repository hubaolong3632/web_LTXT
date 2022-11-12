package com.Web;

import com.Form.Father;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Service.Main01Filter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClassLfyAction extends Action{

    @Resource
    IServiceDao dao; //Êý¾Ý¿â²ã

    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {

        System.out.println("----------ClassLfyAction-----------");
        main.processTemplate(pzwj.getLiu(),req,resp); //Ìø×ªÍøÒ³
    }
}
