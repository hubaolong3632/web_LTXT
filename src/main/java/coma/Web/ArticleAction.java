package coma.Web;

import coma.Form.Father;
import coma.Form.Pzwj;
import coma.Form.ClassLfy;
import coma.Iservice.IServiceDao;
import coma.Model.LoginModel;
import coma.Model.MyarticleModel;
import coma.Service.Main01Filter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//
@Component("ArticleAction")
public class ArticleAction extends Action{
    @Resource
    IServiceDao dao; //数据库层
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        ClassLfy lfy = (ClassLfy) father;//获取他的id
        req.getSession().setAttribute("getlfy",lfy);
        LoginModel loginModel2 = (LoginModel) req.getSession().getAttribute("login");

        System.out.println("需要查询的id"+lfy.getId());
        int indexOf = loginModel2.getModels().indexOf(new MyarticleModel(Integer.parseInt(lfy.getId())));//获取他的值通过id去查找他的集合
        MyarticleModel model = loginModel2.getModels().get(indexOf);//获取内容

        System.out.println("013-Action: 获取到的说说id:"+model.getId()+"   标题:"+model.getTheme());

        req.setAttribute("model",model); //保存当前的说说

        System.out.println("011-Action:跳转到"+pzwj.getLiu()+"界面");

        main.processTemplate(pzwj.getLiu(),req,resp); //跳转网页
    }
}
