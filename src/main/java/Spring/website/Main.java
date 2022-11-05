package Spring.website;

import Spring.ViewBaseServlet;
import qqzone.Modio.Reply;
import qqzone.Modio.Topic;
import qqzone.Modio.UserBasic;
import qqzone.Servlce.Text.UserBasicText;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/main")
public class Main  extends ViewBaseServlet {
    private UserBasic userBAsic;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("-----------main----------------");
        String operate = req.getParameter("operate");
        System.out.println();
        if(operate==null)
        {
              operate = "index";  //初始化赋值
        }
        System.out.println("当前传输的方法"+operate);
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if(operate.equals(method.getName())){

                try {
                    method.invoke(this,req,resp);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                return;
            }
        }
        System.out.println("当前用户查找的不存在");

    }

    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------登入成功-------------");
        req.setCharacterEncoding("UTF-8"); //防止中文乱码

        userBAsic = (UserBasic)req.getSession().getAttribute("userBAsic");


        super.processTemplate("index",req,resp);
    }

    private void register_login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------注册模块-------------");
        req.setCharacterEncoding("UTF-8"); //防止中文乱码



        super.processTemplate("register_login",req,resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------好友界面-------------");
        req.setCharacterEncoding("UTF-8"); //防止中文乱码



        super.processTemplate("list",req,resp);
    }

    private void about_me(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------个人信息界面-------------");
        req.setCharacterEncoding("UTF-8"); //防止中文乱码



        super.processTemplate("about_me",req,resp);
    }

    private void article(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------说说详细-------------");
        req.setCharacterEncoding("UTF-8"); //防止中文乱码



        super.processTemplate("article",req,resp);
    }



//    private void  writeBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//
//        for (Topic topic : userBAsic.getTopicList()) {
//            if(String.valueOf(topic.getId()).equals(id)){
//                System.out.println("导入成功");
//                req.setAttribute("topic",topic); //导入数据
//                System.out.println(topic.getContent());
//
//            }
//        }
//
//        System.out.println("进入说说回复区域");
//        super.processTemplate("writeback",req,resp);
//    }
}
