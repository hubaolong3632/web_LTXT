package coma.Dao;

import coma.Iservice.IServiceDao;
import coma.Model.LikeModio;
import coma.Model.MyarticleModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

//
@ComponentScan("coma")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        IServiceDao login = (IServiceDao) context.getBean("loginDao");

        System.out.println(login.pageTotal(30));

//
//
//        int begin=0*30; //开始页每30页分一次
//        int end=begin+30; //结束页
//
//        MyarticleModel model = new MyarticleModel();// 引入model
//        model.setUname("1");
//        model.setBegin(begin);
//        model.setEnd(end);
//        System.out.println("开始:"+begin+"     结束:"+end);
//
//        List<MyarticleModel> list = login.queryName(model);
//
//        for (MyarticleModel myarticleModel : list) {
//            System.out.println(myarticleModel.getId()+"     "+myarticleModel.getUname()+"      "+myarticleModel.getTheme());
//        }
//
    }
}

//        ClassLfyModel java = login.getCount(new ClassLfyModel("java"));
//        List<MyarticleModel> mysql = login.diArticles(new MyarticleModel(new ClassLfyModel("mysql")));
//        InfoModel infoModel = login.getInfoModel(new LoginModel("12", "12"));
//        System.out.println(infoModel.getHeadimg());
//        MyarticleModel model = new MyarticleModel();
//        model.setTheme("文章");
//        List<MyarticleModel> content = login.getContent(model);
//        for (MyarticleModel myarticleModel : content) {
//            System.out.println(myarticleModel.getId());
//        }




