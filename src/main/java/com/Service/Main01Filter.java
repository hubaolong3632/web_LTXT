package com.Service;



import com.Form.Father;
import com.Form.Pzwj;
import com.Utio.IP;
import com.Utio.ViewBaseServlet;
import com.Web.Action;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

@MultipartConfig(location="D:\\",fileSizeThreshold=1024)   //到时上传到服务器要改路径
public class Main01Filter extends ViewBaseServlet {

    private static final long serialVersionUID = 1L;

    private Map<String, Pzwj> map=new HashMap<>(); //保存数据的集合

    @Override
    public void init() throws ServletException {
        super.init(); //很重要先调用父类的方法操作一遍
        System.out.println("-------文件读取-------");
        //文件的读取
        ResourceBundle pzwj = ResourceBundle.getBundle("pzwj"); //获取保存的文件
        Enumeration<String> keys = pzwj.getKeys();

        while (keys.hasMoreElements()) {

                    String key = keys.nextElement();//获取键
                    String value=pzwj.getString(key); //获取值
            String[] split = value.split("=");
//            System.out.println(key+"   "+split[0]+"  - - "+split[1]+"  - - "+split[2]+"  - - "+split[3]+"  - - "+split[4]+"  - - "+split[5]);
            map.put(key,new Pzwj(value,split[0],split[1],split[2],split[3],split[4],split[5])); //保存集合

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //初始化操作
        req.setCharacterEncoding("UTF-8"); //
        String path=req.getRequestURL().toString(); //获取一整条URL
        String target=path.substring(path.lastIndexOf("/")+1); // 获取末尾的值 如 aaa.do
        System.out.println("----doPost----<----"+target+"---->-------------");


        //登入用户的ip地址
        String ip = IP.userIP(req);
        System.out.println("获取的ip:"+ip);

        try{

            Pzwj pzwj1 =map.get(target); //查找map对应里面的数据
            if(pzwj1==null){    //如果为空执行的地方
                System.out.println("空------------->");
                super.processTemplate("cccc.html",req,resp); //如果跳转的是还没有设置的界面
                return;
            }


            Father instance=null;
            if(!pzwj1.getYi().equals("null")) {  //如果当前进入的为空那么就跳转直接执行
                Class<?> aClass = Class.forName(pzwj1.getYi());  //创建指定的类  -Model.PasWord
                instance = (Father) aClass.newInstance();  //创建实现的父类



                Enumeration<String> parameterNames = req.getParameterNames();  //数据的处理
                while (parameterNames.hasMoreElements()) {

                    String nextElement = parameterNames.nextElement(); //获取名称
                    String set = "set" + nextElement.substring(0, 1).toUpperCase() + nextElement.substring(1);  //需要保存的set方法并且转换成setName的模式


                //对于数据的注入
                        Method[] methods = aClass.getMethods();
                        for (Method method : methods) {
                            Class<?>[] parameterTypes = method.getParameterTypes(); //获取对应的方法
                            for (Class<?> parameterType : parameterTypes) { //里面的是类别 String等等
                                if (method.getName().equals(set)) {  //查找指定数据进行注入
                                    Method name = aClass.getMethod(method.getName(), parameterType);  //查找对应的值
                                    name.invoke(instance, req.getParameter(nextElement));  //把数据进行注入
                                    break; //查找到之后就退出程序
                                }
                            }
                        }
                    }


                }


                //支持spring依赖
                if (pzwj1.getSi().equals("1")) {
                    System.out.println("调用的方向:" + pzwj1.getSi() + "    跳转的Action:" + pzwj1.getWu());
                    ServletContext servletContext = this.getServletContext();
                    WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
                    Action action = (Action) applicationContext.getBean(pzwj1.getWu()); //找到是需要跳转到那个父类
                    action.execute(instance, pzwj1, req, resp, this); //调用此方法 执行代码
                    //   父类名称    走下去的线    req 和resp请求
                }


        }catch (Exception e){
            super.processTemplate("cccc.html",req,resp); //出现异常跳转的界面
            e.printStackTrace();
        }







    }





}
