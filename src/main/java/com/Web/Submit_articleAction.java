package com.Web;

import com.Form.Father;
import com.Form.Myarticle;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Model.ClassLfyModel;
import com.Model.LoginModel;
import com.Model.MyarticleModel;
import com.Service.Main01Filter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("Submit_articleAction")
public class Submit_articleAction extends Action{
    @Resource
    IServiceDao dao; //数据库

    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        System.out.println("-------Submit_articleAction-----");

        //获取内容
        Myarticle father1 = (Myarticle) father; // 传输文章
        LoginModel login=  (LoginModel)req.getSession().getAttribute("login");

        //获取时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//获取时间
        Date date = new Date(System.currentTimeMillis());


        //保存参数
        MyarticleModel myart=new MyarticleModel();
        myart.setUname(login.getName()); //姓名
        myart.setTheme(father1.getHeadline());  //主题
        myart.setContent(father1.getMessage());  //内容
        myart.setClassify(new ClassLfyModel(father1.getClassify())); //分区
        myart.setPostdate(formatter.format(date)); //发表时间
        myart.setLikenum(0); //点赞数量
        myart.setCollection(0); //收藏数量


        boolean bool=dao.addMyarticle(myart); //添加文章
        if(bool==false){

        }


        main.processTemplate(pzwj.getLiu(),req,resp); //跳转指定网站
    }
}
