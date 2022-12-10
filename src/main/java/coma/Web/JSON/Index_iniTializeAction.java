package coma.Web.JSON;

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

//刚刚开始用于初始化的Json文档  (文章显示)
@Component("Index_iniTializeAction")
public class Index_iniTializeAction extends Action {

    @Resource
    IServiceDao dao; //数据库层

    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        resp.setContentType("text/json; charset=utf-8"); //设置编码格式和数据类型
        //保存对象from层
        ClassLfy clas= (ClassLfy) father;
        System.out.println("传输进来的页数:"+clas.getPage());
        System.out.println("Name值:"+clas.getName());
        //保存文件
        MyarticleModel model = new MyarticleModel(new ClassLfyModel());
        model.getClassify().setName(clas.getName());

//        if(Integer.parseInt(clas.getPage())>dao.pageTotal(30)){ //如果传输进来的分页数量大于当前分页数量
//            resp.getWriter().println(Utio.JSON(Result.failure(ResultCode.DATA_IS_WRONG,new NoModel("已经为查询的最大值",null)))); //打印模糊查询
//            System.out.println("提交过来的超过最大分页数");
//            return;
//        }


       int begin=Integer.parseInt(clas.getPage())*30; //开始页
//       int end=begin+30; //结束页
        model.setBegin(30); //取出30条数据
        model.setEnd(begin); //从当前指定的开始
//  select * FROM t_myarticle where classify ="java"  LIMIT 30  OFFSET 60 ; #跳过 前60条取出后30条的数据

//        model.setPage(Integer.parseInt(clas.getPage())); //设置页数
        List<MyarticleModel> models;//调用数据库层进行数据保存
        if(clas.getClassify()!=null&&clas.getClassify().equals("myself"))
        {
            System.out.println("0001_查找个人的个人信息");
            String username = (String) req.getSession().getAttribute("username");  //查找到自己姓名
            System.out.println("传输进来的姓名:"+username);
            model.setUname(username);
            models=dao.queryName(model);


        }else if(clas.getClassify()!=null&&clas.getClassify().equals("name")){
            System.out.println("0002_通过姓名查找内容");
            model.setUname(clas.getName());//放入别人的姓名
            models=dao.queryName(model);
        }
        else{
//            System.out.println("0003_通过分区查询  从:"+begin+"    到:"+end);
            models=dao.diArticles(model);
        }

        //不需要的三句话
        LoginModel loginModel = (LoginModel) req.getSession().getAttribute("login");
        loginModel.setModels(models); //保存进入域
        req.setAttribute("models",models); //保存

        System.out.println("JSON-2-Index_iniTializeAction:初始化文章的json格式被调用");

        resp.getWriter().println(Utio.JSON(Result.failure(ResultCode.SUCCESS,new NoModel(String.valueOf(dao.pageTotal(30)),models)))); //打印模糊查询

    }

}
