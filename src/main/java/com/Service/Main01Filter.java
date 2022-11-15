package com.Service;



import com.Form.Father;
import com.Form.Pzwj;
import com.Utio.IP;
import com.Utio.ViewBaseServlet;
import com.Web.Action;
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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@MultipartConfig(location="D:\\",fileSizeThreshold=1024)   //到时上传到服务器要改路径
public class Main01Filter extends ViewBaseServlet {
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
//        System.out.println("-------c5");
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String path=req.getRequestURL().toString(); //获取一整条URL
        String target=path.substring(path.lastIndexOf("/")+1); // 获取末尾的值 如 aaa.do
        System.out.println("----doPost----<----"+target+"---->-------------");


        String ip = IP.userIP(req);
        System.out.println("获取的id:"+ip);

        try{

            Pzwj pzwj1 =map.get(target); //查找map对应里面的数据
            if(pzwj1==null){    //如果为空执行的地方
                System.out.println("空------------->");
                super.processTemplate("cccc.html",req,resp); //如果跳转的是还没有设置的界面
                return;
            }


            Father instance=null;
            if(!pzwj1.getYi().equals("null")){  //如果当前进入的为空那么就跳转直接执行
                 Class<?> aClass = Class.forName(pzwj1.getYi());  //创建指定的类  -Model.PasWord
                 instance = (Father)aClass.newInstance();  //创建实现的父类

//                //文件查找
//                for (Part part : req.getParts()) {
//                    if (part.getSize() > 1024 * 10240) { //大型文件判断
//                        part.delete();//文件大小超过设置的值
//                    }
//
//                    //只处理上传文件区段
//                    if (part.getName().startsWith("file")) {
//                        String header = part.getHeader("Content-Disposition");
//                        String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
//                        header.lastIndexOf("\"");
//
//                        //文件保存
//                        File f = new File(path);
//                        if (!f.exists()) {
//                            f.mkdirs();
//                        }
//
//                        System.out.println(path + fileName);
//                        part.write(path + fileName); //保存文件
//
//
//                    }
//                }

                Enumeration<String> parameterNames = req.getParameterNames();  //数据的处理
                    while (parameterNames.hasMoreElements()) {





                                String nextElement =parameterNames.nextElement(); //获取名称
                        //      System.out.println(nextElement+"  -----  "+req.getParameter(nextElement)); //获取标签 和标签对应的数据
                                String set = "set" + nextElement.substring(0, 1).toUpperCase() + nextElement.substring(1);  //需要保存的set方法并且转换成setName的模式
                                //文件的查找

                        //使用list存储多文件
                            if(nextElement.equals("headimg")){  //如果为图片

//// 设置单个文件大小
//                                spring.servlet.multipart.max-file-size= 50MB
//// 设置单次请求文件的总大小
//                                spring.servlet.multipart.max-request-size= 50MB
                                String path1 = this.getServletContext().getRealPath("/");//获得根目录
                                path1 = path1 + "image\\" +"wj";
                                System.out.println(path1);

                                System.out.println("查找到文件");
                                //文件查找
                                for (Part part : req.getParts()) {
                                    if (part.getSize() > 1024 * 10240) { //大型文件判断
                                        part.delete();//文件大小超过设置的值
                                    }

                                    //只处理上传文件区段
                                    if (part.getName().startsWith("file")) {
                                        String header = part.getHeader("Content-Disposition");
                                        String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\"")); //获取最后的路径
                                        header.lastIndexOf("\""); //设置路径
                                        System.out.println("文件名称:"+fileName);

                                        //文件保存
                                        File f = new File(path1);
                                        if (!f.exists()) {
                                            f.mkdirs();
                                        }

                                        System.out.println(path + fileName);
                                        part.write(path + fileName); //保存文件


                                    }
                                }

                                continue; //跳过本次循环

                            }



                                Method[] methods = aClass.getMethods();
                                for (Method method : methods) {

                                      //System.out.println("method ----- "+method);
                                      Class<?>[] parameterTypes = method.getParameterTypes(); //获取对应的方法
                                      for (Class<?> parameterType : parameterTypes) { //里面的是类别 String等等
                                          // System.out.println(method.getName()+"------------"+set);
                                          if (method.getName().equals(set)) {  //查找指定数据进行注入
                                              Method name = aClass.getMethod(method.getName(), parameterType);  //查找对应的值
                                              name.invoke(instance, req.getParameter(nextElement));  //把数据进行注入

                                              break;
                                          }
                                      }

                                }
                        }

                    }


            //支持spring依赖
            if(pzwj1.getSi().equals("1")){
                System.out.println("调用的方法:"+pzwj1.getSi()  +"    跳转的子类"+pzwj1.getWu());

                ServletContext servletContext = this.getServletContext();
                WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
                System.out.println("pzwj1.getWu():"+pzwj1.getWu());
                Action action =(Action) applicationContext.getBean(pzwj1.getWu()); //找到是需要跳转到那个父类
                 action.execute(instance,pzwj1,req,resp,this); //调用此方法 执行代码
                //   父类名称    走下去的线    req 和resp请求
            }

        }catch (Exception e){
            e.printStackTrace();
        }







    }





}
