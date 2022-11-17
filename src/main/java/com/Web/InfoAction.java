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
@Component("InfoAction")
public class InfoAction extends Action{
    @Resource
    IServiceDao dao; //数据库
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 转换格式
        Info info = (Info) father;

        InfoModel infoModel = new InfoModel(info.getPhone(),info.getEmail(),info.getHeadimg()); //个人信息
        LoginModel loginModel=new LoginModel(info.getName(),info.getPassword(),infoModel); //放入账号密码 (登入表)


        //判断是否是文件操作
        if (ServletFileUpload.isMultipartContent(req))//判断数据是否为多段数据(只有多段数据，才是文件上传)
        {
            System.out.println("读取了文件上传功能");
            for (Part part : req.getParts()) {
                //用于用户文件的路径
                String path1 = main.getServletContext().getRealPath("/")+ "image\\" +"2020_11_999"+"\\";//获得根目录

                //只处理上传文件区段
                if (part.getName().startsWith("file")) {
                    String header = part.getHeader("Content-Disposition"); //文件格式
                    String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\"")); //获取最后的路径
                    System.out.println("文件名称:"+fileName);


                    File f = new File(path1);//文件保存
                    if (!f.exists()) {
                        System.out.println("创建文件路径");
                        f.mkdirs();
                    }

                    System.out.println("保存路径:"+(path1 + fileName));
                    part.write(path1 + fileName); //保存文件

                }
            }
        }



        if(dao.addInfo(loginModel)==true){  //登入成功判断
            req.getSession().setAttribute("login",loginModel); //保存账号密码
            System.out.println("1:"+pzwj.getLiu());
            resp.sendRedirect(pzwj.getLiu()); //登入成功跳转到指定网页

        }else{
            req.getSession().setAttribute("no","注册失败当前已存在此账号!"); //保存账号密码
            main.processTemplate("register",req,resp); //跳转指定网站 (返回当前账号)

        }




    }
}
