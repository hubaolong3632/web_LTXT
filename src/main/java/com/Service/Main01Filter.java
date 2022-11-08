package com.Service;

import com.Dao.loginDao;
import com.Model.Father;
import com.Model.Pzwj;
import com.Utio.ViewBaseServlet;
import com.Web.Action;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Main01Filter extends ViewBaseServlet {
   private Map<String, Pzwj> map=new HashMap<>(); //保存数据的集合

    @Override
    public void init() throws ServletException {
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

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path=req.getRequestURL().toString(); //获取一整条URL
        String target=path.substring(path.lastIndexOf("/")+1); // 获取末尾的值 如 aaa.do
        System.out.println("当前放入的:"+target);
        try{

            Pzwj pzwj1 =map.get(target); //查找map对应里面的数据

            if(pzwj1==null){
//                xxxxx
                System.out.println("空------------->");
                //如果为空执行的地方
                return;

            }


//            System.out.println("当前输出的内容"+pzwj1.getYi());
//            System.out.println(pzwj1.getValue()+"   "+pzwj1.getYi()+"  - - "+pzwj1.getEr()+"  - - "+pzwj1.getSan()+"  - - "+pzwj1.getSi()+"  - - "+pzwj1.getWu());

            Class<?> aClass = Class.forName(pzwj1.getYi());  //创建指定的类  -Model.PasWord
            Father instance = (Father)aClass.newInstance();  //创建实现的父类

            Enumeration<String> parameterNames = req.getParameterNames();  //数据的处理
            while (parameterNames.hasMoreElements()) {

                String nextElement =parameterNames.nextElement(); //获取名称
//            System.out.println(nextElement+"  -----  "+req.getParameter(nextElement)); //获取标签 和标签对应的数据
                String set = "set" + nextElement.substring(0, 1).toUpperCase() + nextElement.substring(1);  //需要保存的set方法并且转换成setName的模式

                //文件的查找



                Method[] methods = aClass.getMethods();
                for (Method method : methods) {
//                    System.out.println("method ----- "+method);
                    Class<?>[] parameterTypes = method.getParameterTypes(); //获取对应的方法
                    for (Class<?> parameterType : parameterTypes) { //里面的是类别 String等等
                        System.out.println(method.getName()+"------------"+set);
                        if (method.getName().equals(set)) {  //查找指定数据进行注入
                            Method name = aClass.getMethod(method.getName(), parameterType);  //查找对应的值
                            name.invoke(instance, req.getParameter(nextElement));  //把数据进行注入

//                            System.out.println("name -------- "+name);
                            //     System.out.println("--------进来--------------");
                            break;
                        }
                        //   System.out.println(method.getName() + "的对象为：" + parameterType.getName() + "          ");
                    }
                }
            }


//
//            if(pzwj1.getYi().equals("1")){
//
//
//                //xxxxxxxx
//
//                req.getRequestDispatcher(pzwj1.getEr()).forward(req,resp); //指定跳转
//
//            }
//
//

            System.out.println(pzwj1.getSan());
            if(pzwj1.getSi().equals("1")){




                ServletContext servletContext = this.getServletContext();
                WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);



                loginDao st = (loginDao) applicationContext.getBean("studentdao");
                st.addStudent("1","1"); //插入数据库




                System.out.println("调用的方法:"+pzwj1.getSi());

                Action action =(Action) applicationContext.getBean(pzwj1.getWu());

                 action.execute(instance,pzwj1,req,resp); //调用此方法 执行代码
            }







//
//            //用于测试的方法
//            if(instance instanceof PasWord) {//判断是否是当前子类
//                PasWord pad = (PasWord) instance;
////                req.getSession().setAttribute("pad",pad);
//                System.out.println("输出账号："+pad.getName()+"     输出密码："+pad.getPasWord());
//
//            }if(instance instanceof Student){
//                Student student = (Student) instance;
//                System.out.println("id为："+student.getId()+"   姓名为："+student.getName());
//            }

        }catch (Exception e){
            e.printStackTrace();
        }







    }





}
