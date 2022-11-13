package com.Web;

import com.Form.Father;
import com.Form.Pzwj;
import com.Service.Main01Filter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("Index_homepapeAction")
public class Index_homepapeAction extends Action{
    //���ݵ��ύ
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        System.out.println("------������------");
        main.processTemplate(pzwj.getLiu(),req,resp);

    }
}
