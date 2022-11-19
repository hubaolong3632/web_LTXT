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
    IServiceDao dao; //���ݿ�
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        Info info = (Info) father;

        InfoModel infoModel = new InfoModel(info.getPhone(),info.getEmail(),info.getHeadimg()); //������Ϣ
        LoginModel loginModel=new LoginModel(info.getName(),info.getPassword(),infoModel); //�����˺����� (�����)



        if(dao.addInfo(loginModel)==true){  //ע��ɹ��ж�

            //�ļ��ϴ�����
            String filePath = "file\\image\\" + loginModel.getName() + "\\headPortrait" + "\\";  //����·��
            String srelativePath = FilesUtio.sc_Path(father, main, filePath);//�ϴ��ļ�����
            infoModel.setHeadimg(srelativePath); //���浽���ݿ��·��

            //�����˺�����
            req.getSession().setAttribute("login",loginModel);
            System.out.println("��ת����һ���ڵ�::"+pzwj.getLiu());
            resp.sendRedirect(pzwj.getLiu()); //����ɹ���ת��ָ����ҳ

        }else{
            req.getSession().setAttribute("no","ע��ʧ�ܵ�ǰ�Ѵ��ڴ��˺�!"); //�����˺�����
            main.processTemplate("register",req,resp); //��תָ����վ (���ص�ǰ�˺�)

        }




    }


}
