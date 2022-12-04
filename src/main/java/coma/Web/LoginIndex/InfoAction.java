package coma.Web.LoginIndex;

import coma.Form.Father;
import coma.Form.Info;
import coma.Form.Pzwj;
import coma.Iservice.IServiceDao;
import coma.Model.InfoModel;
import coma.Model.LoginModel;
import coma.Service.Main01Filter;
import coma.Utio.FilesUtio;
import coma.Web.Action;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//注册界面
@Component("InfoAction")
public class InfoAction extends Action {
    @Resource
    IServiceDao dao; //数据库
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        Info info = (Info) father;

        InfoModel infoModel = new InfoModel(info.getPhone(),info.getEmail(),info.getHeadimg()); //个人信息
        LoginModel loginModel=new LoginModel(info.getName(),info.getPassword(),infoModel); //放入账号密码 (登入表)
        String sessionCode = (String) req.getSession().getAttribute("code1");
        System.out.println("sessionCode:"+sessionCode);

        String code = req.getParameter("code");
        if(sessionCode!=null)
        {
            if(sessionCode.toLowerCase().equals(code.toLowerCase()))
            {
                if(dao.user_zc(loginModel)==null){  //注册成功判断

                    //文件上传功能
                    String filePath = "file\\image\\" + loginModel.getName() + "\\headPortrait" + "\\";  //保存路径
                    String srelativePath = FilesUtio.sc_Path(father, main, filePath);//上传文件功能
                    infoModel.setHeadimg(srelativePath); //保存到数据库的路径


                    if(dao.addInfo(loginModel)==true) { //添加一个账号 存储所有信息.
                        //保存账号密码
                        req.getSession().setAttribute("login",loginModel);
                        System.out.println("跳转的下一个节点::"+pzwj.getLiu());
                        resp.sendRedirect(pzwj.getLiu()); //登入成功跳转到指定网页
                    }else{
                        req.getSession().setAttribute("no","注册失败! 数据库异常 请检查网络的连接"); //保存账号密码
                        main.processTemplate("register",req,resp); //跳转指定网站 (返回当前账号)
                    }

                }else{
                    req.getSession().setAttribute("no","注册失败当前已存在此账号!"); //保存账号密码
                    main.processTemplate("register",req,resp); //跳转指定网站 (返回当前账号)

                }
            }
            else {
                req.getSession().setAttribute("no","验证码错误!!!"); //保存账号密码
                //  验证失败
                main.processTemplate("register",req,resp); //跳转指定网站 (返回当前账号)
            }
        }



    }


}
