package com.Web;

import com.Form.ClassLfy;
import com.Form.Father;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Model.ClassLfyModel;
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

        List<MyarticleModel> models = dao.diArticles(model);//调用数据库层进行数据保存
        req.setAttribute("models",models); //保存

        for (MyarticleModel myarticleModel : models) {
            System.out.println(myarticleModel.getUname()+"  \n  "+myarticleModel.getTheme()+" \n   "+myarticleModel.getContent());
        }


        main.processTemplate(pzwj.getLiu(),req,resp);

    }
}
