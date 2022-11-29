package coma.Web;

import com.alibaba.fastjson.JSONObject;
import coma.Form.ClassLfy;
import coma.Form.Father;
import coma.Form.Pzwj;
import coma.Iservice.IServiceDao;
import coma.Model.LikeModio;
import coma.Model.LoginModel;
import coma.Model.NoModel;
import coma.Service.Main01Filter;
//import com.Utio.Utio;
import coma.Utio.Result;
import coma.Utio.ResultCode;
import coma.Utio.Utio;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component("LikeAction")
public class LikeAction extends Action{

    @Resource
    IServiceDao dao; //数据库层

    //点赞功能
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        ClassLfy lfy = (ClassLfy) father;
        LoginModel login = (LoginModel) req.getSession().getAttribute("login");
        resp.setContentType("text/json; charset=utf-8"); //设置编码格式和数据类型

        if(!dao.like(new LikeModio(login.getName(), lfy.getClassify()))){//执行添加一条记录
            System.out.println("008-已经点赞！"+login.getName()+"  给文章  "+lfy.getClassify());
            resp.getWriter().println(Utio.JSON(Result.failure(ResultCode.SUCCESS,new NoModel("点赞失败,你已经对当前点赞过了",null))));
        }else{
            System.out.println("009-点赞成功!"+login.getName()+"  给文章  "+lfy.getClassify());
            resp.getWriter().println(Utio.JSON(Result.failure(ResultCode.SUCCESS,new NoModel("点赞成功!!恭喜你",null))));
        }

        System.out.println("传输json格式成功");
    }
}
