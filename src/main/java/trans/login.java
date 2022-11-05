//package Spring;
//
//import qqzone.Servlce.Text.UserBasicText;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
////@WebServlet("/login")
//public class login extends ViewBaseServlet {
//
//
////    @Override
////    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        System.out.println("logo_doGet------------------------");
////        Object o = req.getSession().getAttribute("uname");
////
////        req.setAttribute("pring", "当然哇你好");
////        super.processTemplate("login",req,resp);
////    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("logo_doPost------------------------");
//
//        String name = req.getParameter("name");
//        String pasword = req.getParameter("pasword");
//
//        UserBasicText us=new UserBasicText();
//        String namePasWordExamine = us.login(name, pasword,req.getSession());
//
//        if(namePasWordExamine.equals("index")){
//            resp.sendRedirect("index");//刷新
//
//        }else{
//            System.out.println("账号密码错误!1");
//            resp.sendRedirect("login");//刷新
//
//        }
//
//    }
//
//
//}
