package com.Web;

import com.Form.ClassLfy;
import com.Form.Father;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Model.ClassLfyModel;
import com.Model.LoginModel;
import com.Model.MyarticleModel;
import com.Service.Main01Filter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//文章说说获取(通过分类获取)
@Component("Index_homepapeAction")
public class Index_homepapeAction extends Action{
    @Resource
    IServiceDao dao; //数据库层
    //数据的提交
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        System.out.println("------分类区------");

        //保存对象from层
        ClassLfy clas= (ClassLfy) father;

        //保存文件
        MyarticleModel model = new MyarticleModel(new ClassLfyModel());
        System.out.println(clas.getName());
        model.getClassify().setName(clas.getName());
        System.out.println("getName:"+clas.getName());

//        System.out.println(333);
        List<MyarticleModel> models = dao.diArticles(model);//调用数据库层进行数据保存

        System.out.println("集合判断："+models);
        for (MyarticleModel myarticleModel : models) {

            System.out.println(myarticleModel.getId()+"    "+myarticleModel.getUname());
        }




//        System.out.println(1111);
        //保存进sinse作用域里面
        LoginModel loginModel = (LoginModel) req.getSession().getAttribute("login");
//        System.out.println(loginModel+"11111");
        loginModel.setModels(models); //保存进入域
//        System.out.println(2222);


//        for (MyarticleModel myarticleModel : models) {
//            System.out.println(myarticleModel.getUname()+"  \n  "+myarticleModel.getTheme()+" \n   "+myarticleModel.getContent());
//        }

        req.setAttribute("models",models); //保存

        main.processTemplate(pzwj.getLiu(),req,resp);

    }
}
