package com.Web;

import com.Iservice.IServiceDao;
import com.Model.Father;
import com.Model.Login;
import com.Model.Pzwj;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 *登入界面
 */

@Component("IndexAction")
public class IndexAction extends Action{

    @Resource
    IServiceDao dao; //数据库层
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("当前是登入首页界面");
        req.removeAttribute("index"); //首页
    }
}
