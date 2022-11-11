package com.Web;

import com.Form.Father;
import com.Form.Info;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Model.InfoModel;
import com.Model.LoginModel;
import com.Service.Main01Filter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InfoAction extends Action{
    @Resource
    IServiceDao dao; //���ݿ�
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {

        Info info = (Info) father;

        InfoModel infoModel = new InfoModel(info.getPhone(),info.getEmail(),info.getHeadimg()); //������Ϣ
        LoginModel loginModel=new LoginModel(info.getName(),info.getPassword(),infoModel); //�����˺����� (�����)


        if(dao.addInfo(loginModel)==true){  //����ɹ��ж�
            req.getSession().setAttribute("login",loginModel); //�����˺�����
            System.out.println("1:"+pzwj.getLiu());
            resp.sendRedirect(pzwj.getLiu()); //����ɹ���ת��ָ����ҳ

        }else{
            main.processTemplate("register",req,resp); //��תָ����վ (���ص�ǰ�˺�)
            req.getSession().setAttribute("no","ע��ʧ�ܵ�ǰ�Ѵ��ڴ��˺�!"); //�����˺�����

        }




    }
}
