package com.Utio;

import com.Form.Father;
import com.Service.Main01Filter;

import javax.servlet.http.Part;
import java.io.File;


public class FilesUtio {
    public static String sc_Path(Father father, Main01Filter main, String filePath) { //保存文件
        String pathName=null;//获取绝对路径
        String srelativePath=null;//保存到数据库的路径
        try{
            System.out.println("判断是否为空："+father);
            System.out.println("当前是否存在："+father.getParts());


            for (Part part : father.getParts()) {
                String path1 = main.getServletContext().getRealPath("/");//获得路径保存
//                String filePath= "file\\image\\" +name+"\\headPortrait"+"\\";  // ???????·??
                path1+=filePath; //总文件
                if (part.getName().startsWith("file")) {
                    String header = part.getHeader("Content-Disposition");  //文件格式
                    String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));//获取最后的路径
                    System.out.println("FileName:"+fileName); //获取最后的路径

                    File f = new File(path1);//文件保存
                    if (!f.exists()) {
                        f.mkdirs();
                    }
                    pathName = path1 + fileName;  //获取绝对路径
                    srelativePath = filePath + fileName;//保存到数据库的路径

                    part.write(pathName);  //保存文件

                    System.out.println("\n---------path->->----------\n"+"pathName:"+pathName+"\n"+"srelativePath:"+srelativePath+"\n---------path->->----------\n"); //输出

                }


            }

        }catch (Exception e){
            System.out.println("文件保存失败");
            e.printStackTrace();
            return null;
        }
        return srelativePath;
    }
}
