//package Spring;
//
//import qqzone.Modio.UserBasic;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/index")
//public class index extends ViewBaseServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("登入成功 index_doget------------------------");
//        req.setCharacterEncoding("UTF-8"); //防止中文乱码
//
//        UserBasic userBAsic = (UserBasic)req.getSession().getAttribute("userBAsic");
//        System.out.println(userBAsic.getNickName());
//        System.out.println(userBAsic.getPwd());
//        System.out.println(userBAsic.getFriendList().get(1).getNickName());
//
//
//        super.processTemplate("index",req,resp);
//    }
//
//
//}
