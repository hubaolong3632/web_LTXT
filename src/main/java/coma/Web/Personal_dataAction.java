package coma.Web;

import coma.Form.Father;
import coma.Form.PersonalData;
import coma.Form.Pzwj;
import coma.Iservice.IServiceDao;
import coma.Model.LoginModel;
import coma.Model.NoModel;
import coma.Service.Main01Filter;
import coma.Utio.Result;
import coma.Utio.ResultCode;
import coma.Utio.Utio;
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
        if(father==null){ //为初始化操作

        }
        LoginModel login = (LoginModel) req.getSession().getAttribute("login"); //个人信息````
        System.out.println("---------------进入个人资料界面-------------------");

        PersonalData personalData = (PersonalData) father; //获取信息


        Result failure = Result.failure(ResultCode.NOSUCCESS, "操作失败"); //失败
        switch (personalData.getName()){
            case "pasword":

                // 去数据库修改密码
                failure= Result.failure(ResultCode.SUCCESS, "修改密码成功"); //失败
                break;
        }


        resp.setContentType("text/json; charset=utf-8"); //设置编码格式和数据类型
        System.out.println("json:"+Utio.JSON(failure));
        resp.getWriter().println(Utio.JSON(failure));
    }

}
