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

/**
 * 通过分类查询
 */
//http://localhost:9090/Index_homepape_fuzzyQueryAction.do?name=1
@Component("Index_homepape_fuzzyQueryAction")
public class Index_homepape_fuzzyQueryAction extends Action {

    @Resource
    IServiceDao dao; //数据库层

    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        ClassLfy clas= (ClassLfy) father;
//
        //保存文件
        MyarticleModel model = new MyarticleModel(new ClassLfyModel());
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
        req.getSession().setAttribute("models",models); //保存
        req.getSession().setAttribute("str","数据"); //保存第二个数据




        System.out.println(Utio.JSON(Result.failure(ResultCode.SUCCESS,new NoModel("查询到了分页",models))));
        resp.setContentType("text/json; charset=utf-8"); //设置编码格式和数据类型
        resp.getWriter().println(Utio.JSON(Result.failure(ResultCode.SUCCESS,new NoModel("通过名称查询成功",models)))); //打印模糊查询


//        main.processTemplate(pzwj.getLiu(),req,resp);

    }
}
