//package com.Service;
//
//import com.Model.Pzwj;
//import com.Utio.ViewBaseServlet;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.ResourceBundle;
//
////@WebServlet("/index.do")
//public class IndexFiter extends ViewBaseServlet {
//    private Map<String, Pzwj> map=new HashMap<>(); //保存数据的集合
//
//    @Override
//    public void init() throws ServletException {
//      super.init();
//        System.out.println("你好啊啊啊啊");
//    }
//
//    //
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("-------c1");
//
//        req.getSession().setAttribute("no"," is not char");
//
////        req.getRequestDispatcher("cccc").forward(req,resp);//跳转
//
//        super.processTemplate("cccc.html",req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("tz------------");
//           resp.sendRedirect("index.do");
//
//    }
//}
