package coma.Web;

import coma.Form.Father;
import coma.Form.Pzwj;
import coma.Iservice.IServiceDao;
import coma.Model.LoginModel;
import coma.Service.Main01Filter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//个人资料操作
@Component("Personal_dataAction")
public class Personal_dataAction extends Action{
    @Resource
    IServiceDao dao; //数据库

    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        LoginModel login = (LoginModel) req.getSession().getAttribute("login"); //个人信息````
        System.out.println("---------------进入个人资料界面-------------------");
        main.processTemplate(pzwj.getLiu(),req,resp); //跳转网页
    }

}
