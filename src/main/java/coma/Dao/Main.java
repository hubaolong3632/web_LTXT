package coma.Dao;

import coma.Iservice.IServiceDao;
import coma.Model.ClassLfyModel;
import coma.Model.InfoModel;
import coma.Model.LoginModel;
import coma.Model.MyarticleModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

//
@ComponentScan("com")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        IServiceDao login = (IServiceDao) context.getBean("loginDao");
        ClassLfyModel java = login.getCount(new ClassLfyModel("java"));
        List<MyarticleModel> mysql = login.diArticles(new MyarticleModel(new ClassLfyModel("mysql")));
        InfoModel infoModel = login.getInfoModel(new LoginModel("12", "12"));
        System.out.println(infoModel.getHeadimg());
        MyarticleModel model = new MyarticleModel();
        model.setTheme("文章");
        List<MyarticleModel> content = login.getContent(model);
        for (MyarticleModel myarticleModel : content) {
            System.out.println(myarticleModel.getId());
        }


    }
}



