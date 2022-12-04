package coma.Web.HomepapeAction;

import coma.Form.ClassLfy;
import coma.Form.Father;
import coma.Form.Pzwj;
import coma.Iservice.IServiceDao;
import coma.Model.ClassLfyModel;
import coma.Model.LoginModel;
import coma.Model.MyarticleModel;
import coma.Model.NoModel;
import coma.Service.Main01Filter;
import coma.Utio.Result;
import coma.Utio.ResultCode;
import coma.Utio.Utio;
import coma.Web.Action;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//文章说说获取(通过分类/姓名获取)
@Component("Index_homepapeAction")
public class Index_homepapeAction extends Action {
    @Resource
    IServiceDao dao; //数据库层
    //数据的提交
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        System.out.println("------分类区------");
//        //保存对象from层
//        ClassLfy clas= (ClassLfy) father;
//
//        System.out.println("getName:"+clas.getName());
////1
//        //保存文件
//        MyarticleModel model = new MyarticleModel(new ClassLfyModel());
//        model.getClassify().setName(clas.getName());
//
//
//
//        List<MyarticleModel> models;//调用数据库层进行数据保存
//        if(clas.getClassify()!=null&&clas.getClassify().equals("myself"))
//        {
//            System.out.println("查找个人的个人信息");
//            String username = (String) req.getSession().getAttribute("username");  //查找到自己姓名
//            model.setUname(username);
//            models=dao.queryName(model);
//
//        }else if(clas.getClassify()!=null&&clas.getClassify().equals("name")){
//            System.out.println("0002_通过姓名查找内容");
//            model.setUname(clas.getName());//放入别人的姓名
//            models=dao.queryName(model);
//        }
//        else{
//            models=dao.diArticles(model);
//        }
//
//        LoginModel loginModel = (LoginModel) req.getSession().getAttribute("login");
//        loginModel.setModels(models); //保存进入域
////        System.out.println(Utio.JSON(Result.failure(ResultCode.SUCCESS,new NoModel("点赞成功!!恭喜你",null))));
////        System.out.println(Utio.JSON(Result.failure(ResultCode.SUCCESS, models)));
//
//        req.setAttribute("models",models); //保存
//
//

        main.processTemplate(pzwj.getLiu(),req,resp);
        System.out.println("------跳转成功------");

    }
}