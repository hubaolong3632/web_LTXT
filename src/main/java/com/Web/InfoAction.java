package com.Web;

import com.Form.Father;
import com.Form.Info;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Model.InfoModel;
import com.Model.LoginModel;
import com.Service.Main01Filter;
import com.Utio.FilesUtio;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.util.Collection;

@Component("InfoAction")
public class InfoAction extends Action{
    @Resource
    IServiceDao dao; //数据库
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        Info info = (Info) father;

        InfoModel infoModel = new InfoModel(info.getPhone(),info.getEmail(),info.getHeadimg()); //个人信息
        LoginModel loginModel=new LoginModel(info.getName(),info.getPassword(),infoModel); //放入账号密码 (登入表)



        if(dao.addInfo(loginModel)==true){  //注册成功判断

            //文件上传功能
            String filePath = "file\\image\\" + loginModel.getName() + "\\headPortrait" + "\\";  //保存路径
            String srelativePath = FilesUtio.sc_Path(father, main, filePath);//上传文件功能
            infoModel.setHeadimg(srelativePath); //保存到数据库的路径

            //保存账号密码
            req.getSession().setAttribute("login",loginModel);
            System.out.println("跳转的下一个节点::"+pzwj.getLiu());
            resp.sendRedirect(pzwj.getLiu()); //登入成功跳转到指定网页

        }else{
            req.getSession().setAttribute("no","注册失败当前已存在此账号!"); //保存账号密码
            main.processTemplate("register",req,resp); //跳转指定网站 (返回当前账号)

        }




    }


}
