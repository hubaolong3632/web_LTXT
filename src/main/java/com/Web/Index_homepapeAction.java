package com.Web;

import com.Form.ClassLfy;
import com.Form.Father;
import com.Form.Pzwj;
import com.Iservice.IServiceDao;
import com.Model.ClassLfyModel;
import com.Model.MyarticleModel;
import com.Service.Main01Filter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//����˵˵��ȡ(ͨ�������ȡ)
@Component("Index_homepapeAction")
public class Index_homepapeAction extends Action{
    @Resource
    IServiceDao dao; //���ݿ��
    //���ݵ��ύ
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        System.out.println("------������------");

        //�������from��
        ClassLfy clas= (ClassLfy) father;

        //�����ļ�
        MyarticleModel model = new MyarticleModel(new ClassLfyModel());
        System.out.println(clas.getName());
        model.getClassify().setName(clas.getName());
        System.out.println("getName:"+clas.getName());

        List<MyarticleModel> models = dao.diArticles(model);//�������ݿ��������ݱ���
        req.setAttribute("models",models); //����

        for (MyarticleModel myarticleModel : models) {
            System.out.println(myarticleModel.getUname()+"  \n  "+myarticleModel.getTheme()+" \n   "+myarticleModel.getContent());
        }


        main.processTemplate(pzwj.getLiu(),req,resp);

    }
}
