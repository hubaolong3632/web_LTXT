package coma.Web;

import coma.Form.Father;
import coma.Form.PersonalData;
import coma.Form.Pzwj;
import coma.Iservice.IServiceDao;
import coma.Model.InfoModel;
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
        LoginModel login = (LoginModel) req.getSession().getAttribute("login"); //个人信息````
        System.out.println("---------------进入个人资料界面-------------------");

        PersonalData personalData = (PersonalData) father; //获取信息
        System.out.println("当前类"+personalData);


        Result failure = Result.failure(ResultCode.NOSUCCESS, "操作失败"); //开始默认为失败

        switch (personalData.getName()){
            case "pasword":
                // 去数据库修改密码
                if (dao.changePassword(new LoginModel(login.getName(),personalData.getContent()))) {
                    failure= Result.failure(ResultCode.SUCCESS, "修改密码成功"); //失败
                }else{
                    failure= Result.failure(ResultCode.NOSUCCESS, "密码修改失败,数据库异常"); //失败
                }
                break;
            case "phone":   //修改手机号
                String[] split = personalData.getContent().split("=");
                System.out.println(split[0]+"    "+split[1]);
                if(login.getInfo().getPhone().equals(split[0])){ //如果手机号一样

                    LoginModel model = new LoginModel();
                    model.setName(login.getName()); //设置名称
                    model.setInfo(new InfoModel(split[1])); //设置需要修改的手机号
                    if(dao.changePhone(model)){
                        login.getInfo().setPhone(split[1]);


                        failure= Result.failure(ResultCode.SUCCESS, "手机号修改成功!"); //成功
                    }else{
                        failure= Result.failure(ResultCode.NOSUCCESS, "手机号修改失败,数据库异常"); //失败
                    }

                }else{
                    failure= Result.failure(ResultCode.NOSUCCESS, "手机号不一样"); // 不一样
                }
                break;
        }


        resp.setContentType("text/json; charset=utf-8"); //设置编码格式和数据类型
        System.out.println("json:"+Utio.JSON(failure));
        resp.getWriter().println(Utio.JSON(failure));
    }

}
