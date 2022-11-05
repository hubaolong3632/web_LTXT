package Spring.team;

import Spring.ViewBaseServlet;
import Spring.website.login;
import qqzone.Dao.TeamDAo;
import qqzone.Iservlce.ITeamDao;
import qqzone.Modio.QQPath;
import qqzone.Modio.QQname;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Register
 */
@WebServlet(name="Register",urlPatterns={"/register.do"})
//设置文件存储的路径
@MultipartConfig(location="D:\\",fileSizeThreshold=1024)   //到时上传到服务器要改路径
public class Register extends ViewBaseServlet {
    private static final long serialVersionUID = 1L;
    private static final Object[] OK = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.processTemplate("Register",req,resp);
    }



    ExecutorService es= Executors.newFixedThreadPool(10);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\n\n------------------doPost(wjsc)-----------------------------");
        ITeamDao dao=new TeamDAo();
        QQname name=new QQname();

        List<String> img = new ArrayList<>(); //服务器的
        List<QQPath> path1 = name.getPath(); //数据库的
        //获取时间
        SimpleDateFormat formatter = new SimpleDateFormat("'Data-'yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        //设置编码
        request.setCharacterEncoding("utf-8");
        try {
            //目录设置
            String nameQQ = request.getParameter("name") + "+" + request.getParameter("qq");
            String path_hou = formatter.format(date) + "\\" + nameQQ + "\\";//存放图片的路径 带上上传时间
            String path = this.getServletContext().getRealPath("/");//获得根目录
            path = path + "image\\" + path_hou;


            //文件保存、路径设置
            for (Part part : request.getParts()) {
                if (part.getSize() > 1024 * 10240) { //大型文件判断
                    part.delete();
                }

                //只处理上传文件区段
                if (part.getName().startsWith("file")) {
                    String header = part.getHeader("Content-Disposition");
                    String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
                    header.lastIndexOf("\"");

                //文件保存
                    File f = new File(path);
                    if (!f.exists()) {
                        f.mkdirs();
                    }

                    System.out.println(path + fileName);
                    part.write(path + fileName); //保存文件

                    String pathSelect="image\\" + path_hou + fileName; //需要保存的路径
                    img.add(pathSelect); //用于后期查找
                    path1.add(new QQPath(name.getName(),pathSelect)); //后期保存数据库的
                }
            }

            name.setQq(request.getParameter("qq"));
            name.setName(request.getParameter("name"));
            name.setIp(login.userIP(request));//获取ip地址
            name.setTimeData(formatter.format(date));


            es.submit(new Test(dao,name));
//            new Thread(() -> {  //对于数据进行保存到数据库
//                try {
//
//                    System.out.println("  游戏名称:"+name.getName()+"  联系QQ:"+name.getQq());
//                    dao.addingClanData(name); //添加保存到数据库
//                } catch (SQLException e) {
//                    System.out.println("cuoww");
//                }
//            });

            request.getSession().setAttribute("img", img); //存储数据
            response.sendRedirect("scwj_imgshow");//刷新


        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("scwj_no_scwj.html");

        }


    }
}
class Test  implements Callable {
   private ITeamDao dao;
   private QQname name;
    public Test(ITeamDao dao,QQname name) {
        this.dao=dao;
        this.name=name;

    }

    @Override
    public Object call() throws Exception {
        System.out.println("  游戏名称:"+name.getName()+"  联系QQ:"+name.getQq());
       dao.addingClanData(name); //添加保存到数据库

        return null;
    }
}

