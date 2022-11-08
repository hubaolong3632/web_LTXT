package com.Web;

import com.Model.Father;
import com.Model.Pzwj;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("StudentAction")
public class StudentAction extends Action{
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("有木有成功");



        req.getRequestDispatcher(pzwj.getLiu()).forward(req,resp);//跳转
    }
}
