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

/**
 * 通过分类查询
 */
@Component("Index_homepape_fuzzyQueryAction")
public class Index_homepape_fuzzyQueryAction extends Action{

    @Resource
    IServiceDao dao; //数据库层

    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        ClassLfy clas= (ClassLfy) father;
//
        //保存文件
        MyarticleModel model = new MyarticleModel(new ClassLfyModel());
//        model.getClassify().setName(clas.getName());
        model.setTheme(clas.getName());
        System.out.println("getName:"+model.getTheme());

        List<MyarticleModel> models = dao.getContent(model);//调用数据库层进行数据保存

//        System.out.println("模糊查询："+models);
        for (MyarticleModel myarticleModel : models) {
            System.out.println(myarticleModel.getId()+"    "+myarticleModel.getUname());
        }


        String str = (String) req.getSession().getAttribute("str");//保存第二个数据
        System.out.println("作用域保存的值:"+str);


        //保存进sinse作用域里面
        LoginModel loginModel = (LoginModel) req.getSession().getAttribute("login");
        loginModel.setModels(models); //保存进入域
        req.setAttribute("models",models); //保存
        req.getSession().setAttribute("str","数据"); //保存第二个数据




        main.processTemplate(pzwj.getLiu(),req,resp);

    }
}
