package com.Web;

import com.Form.ClassLfy;
import com.Form.Father;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Model.LoginModel;
import com.Model.MyarticleModel;
import com.Service.Main01Filter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("ArticleAction")
public class ArticleAction extends Action{
    @Resource
    IServiceDao dao; //数据库层
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        ClassLfy lfy = (ClassLfy) father;//获取他的id
        LoginModel loginModel2 = (LoginModel) req.getSession().getAttribute("login");


//        loginModel2.getModels().indexOf();

//        for (MyarticleModel model2Model : loginModel2.getModels()) {
//            if()
//            System.out.println("获取到的内容: "+model2Model.getId());
//        }
        System.out.println("011-Action:跳转到"+pzwj.getLiu()+"界面");
        main.processTemplate(pzwj.getLiu(),req,resp); //跳转网页
    }
}
