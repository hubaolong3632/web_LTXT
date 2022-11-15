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
    IServiceDao dao; //���ݿ�

    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        System.out.println("-------Submit_articleAction-----");

        //��ȡ����
        Myarticle father1 = (Myarticle) father; // ��������
        LoginModel login=  (LoginModel)req.getSession().getAttribute("login");

        //��ȡʱ��
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//��ȡʱ��
        Date date = new Date(System.currentTimeMillis());


        //�������
        MyarticleModel myart=new MyarticleModel();
        myart.setUname(login.getName()); //����
        myart.setTheme(father1.getHeadline());  //����
        myart.setContent(father1.getMessage());  //����
        myart.setClassify(new ClassLfyModel(father1.getClassify())); //����
        myart.setPostdate(formatter.format(date)); //����ʱ��
        myart.setLikenum(0); //��������
        myart.setCollection(0); //�ղ�����


        boolean bool=dao.addMyarticle(myart); //�������
        if(bool==false){

        }


        main.processTemplate(pzwj.getLiu(),req,resp); //��תָ����վ
    }
}
