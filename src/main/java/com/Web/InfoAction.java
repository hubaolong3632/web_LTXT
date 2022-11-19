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
    IServiceDao dao; //���ݿ�
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        Info info = (Info) father;

        InfoModel infoModel = new InfoModel(info.getPhone(),info.getEmail(),info.getHeadimg()); //������Ϣ
        LoginModel loginModel=new LoginModel(info.getName(),info.getPassword(),infoModel); //�����˺����� (�����)


            for (Part part : father.getParts()) {
                //�����û��ļ���·��
                String path1 = main.getServletContext().getRealPath("/")+ "image\\" +info.getName()+"\\headPortrait"+"\\";//���·������

                //ֻ�����ϴ��ļ�����
                if (part.getName().startsWith("file")) {
                    String header = part.getHeader("Content-Disposition"); //�ļ���ʽ
                    String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\"")); //��ȡ����·��
                    System.out.println("FileName:"+fileName); //�ļ�·��

                    File f = new File(path1);//�ļ�����
                    if (!f.exists()) {
                        f.mkdirs();
                    }
                    String pathName = path1 + fileName;  //��ȡ����·��
                    infoModel.setHeadimg(pathName); //���浽���ݿ��·��
                    System.out.println("savePath:"+pathName);
                    part.write(pathName); //�����ļ�

                }
            }



        if(dao.addInfo(loginModel)==true){  //ע��ɹ��ж�
            req.getSession().setAttribute("login",loginModel); //�����˺�����
            System.out.println("1:"+pzwj.getLiu());
            resp.sendRedirect(pzwj.getLiu()); //����ɹ���ת��ָ����ҳ

        }else{
            req.getSession().setAttribute("no","ע��ʧ�ܵ�ǰ�Ѵ��ڴ��˺�!"); //�����˺�����
            main.processTemplate("register",req,resp); //��תָ����վ (���ص�ǰ�˺�)

        }




    }
}
