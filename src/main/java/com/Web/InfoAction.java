package com.Web;

import com.Form.Father;
import com.Form.Info;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Model.InfoModel;
import com.Model.LoginModel;
import com.Service.Main01Filter;
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


            for (Part part : father.getParts()) {
                //用于用户文件的路径
                String path1 = main.getServletContext().getRealPath("/")+ "image\\" +info.getName()+"\\headPortrait"+"\\";//获得路径保存

                //只处理上传文件区段
                if (part.getName().startsWith("file")) {
                    String header = part.getHeader("Content-Disposition"); //文件格式
                    String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\"")); //获取最后的路径
                    System.out.println("FileName:"+fileName); //文件路径

                    File f = new File(path1);//文件保存
                    if (!f.exists()) {
                        f.mkdirs();
                    }
                    String pathName = path1 + fileName;  //获取绝对路径
                    infoModel.setHeadimg(pathName); //保存到数据库的路径
                    System.out.println("savePath:"+pathName);
                    part.write(pathName); //保存文件

                }
            }



        if(dao.addInfo(loginModel)==true){  //注册成功判断
            req.getSession().setAttribute("login",loginModel); //保存账号密码
            System.out.println("1:"+pzwj.getLiu());
            resp.sendRedirect(pzwj.getLiu()); //登入成功跳转到指定网页

        }else{
            req.getSession().setAttribute("no","注册失败当前已存在此账号!"); //保存账号密码
            main.processTemplate("register",req,resp); //跳转指定网站 (返回当前账号)

        }




    }
}
