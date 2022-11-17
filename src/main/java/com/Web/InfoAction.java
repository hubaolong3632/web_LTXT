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
    IServiceDao dao; //���ݿ�
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // ת����ʽ
        Info info = (Info) father;

        InfoModel infoModel = new InfoModel(info.getPhone(),info.getEmail(),info.getHeadimg()); //������Ϣ
        LoginModel loginModel=new LoginModel(info.getName(),info.getPassword(),infoModel); //�����˺����� (�����)


        //�ж��Ƿ����ļ�����
        if (ServletFileUpload.isMultipartContent(req))//�ж������Ƿ�Ϊ�������(ֻ�ж�����ݣ������ļ��ϴ�)
        {
            System.out.println("��ȡ���ļ��ϴ�����");
            for (Part part : req.getParts()) {
                //�����û��ļ���·��
                String path1 = main.getServletContext().getRealPath("/")+ "image\\" +"2020_11_999"+"\\";//��ø�Ŀ¼

                //ֻ�����ϴ��ļ�����
                if (part.getName().startsWith("file")) {
                    String header = part.getHeader("Content-Disposition"); //�ļ���ʽ
                    String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\"")); //��ȡ����·��
                    System.out.println("�ļ�����:"+fileName);


                    File f = new File(path1);//�ļ�����
                    if (!f.exists()) {
                        System.out.println("�����ļ�·��");
                        f.mkdirs();
                    }

                    System.out.println("����·��:"+(path1 + fileName));
                    part.write(path1 + fileName); //�����ļ�

                }
            }
        }



        if(dao.addInfo(loginModel)==true){  //����ɹ��ж�
            req.getSession().setAttribute("login",loginModel); //�����˺�����
            System.out.println("1:"+pzwj.getLiu());
            resp.sendRedirect(pzwj.getLiu()); //����ɹ���ת��ָ����ҳ

        }else{
            req.getSession().setAttribute("no","ע��ʧ�ܵ�ǰ�Ѵ��ڴ��˺�!"); //�����˺�����
            main.processTemplate("register",req,resp); //��תָ����վ (���ص�ǰ�˺�)

        }




    }
}
