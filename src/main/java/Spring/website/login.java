package Spring.website;

import Spring.ViewBaseServlet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import qqzone.Servlce.Text.UserBasicText;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/dr")
public class login extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("---------登入界面-------------");
        userIP(req);
        System.out.println();
        super.processTemplate("dr",req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------------------------------");
        userIP(req);
        System.out.println("------------------------------");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("xm");
        String pasword = req.getParameter("mhm");

        UserBasicText us=new UserBasicText();
        String namePasWordExamine = us.login(name, pasword,req.getSession());

        if(namePasWordExamine.equals("index")){
            resp.sendRedirect("main");//刷新

        }else{
            System.out.println("账号密码错误!当前用户输入的账号:"+name+"   密码:"+pasword+"\n\n");
            req.getSession().setAttribute("show", "请输入Uid和Pwd....");
            RequestDispatcher rd = req.getRequestDispatcher("dr.html");


            rd.forward(req, resp);
        }

    }

    public static String userIP(HttpServletRequest request){

        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("Proxy-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("WL-Proxy-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getRemoteAddr();
        try{
            if(isIP(ip)){
                URL url=new URL("http://mip.chinaz.com/?query="+ip);
                Document parse = Jsoup.parse(url,10000);
                Elements elements = parse.select("td[class=z-tc]");
                String str= String.valueOf(elements);
                String replace = str.replace("<td class=\"z-tc\">", "");
                String replace1 = replace.replace("</td>", "");
                String replace2 = replace1.replace("<br> <a class=\"z-tc\" data-toggle=\"modal\" data-target=\".ip138\" style=\"text-decoration: none;cursor:pointer;color:#c0c1c4;\">ip138提供</a> ", "");

                System.out.println("访问者地址/ip"+replace2);
            }
        } catch (Exception e) {
            System.out.println("错误");
        }

        return ip;
    }

    public static boolean isIP(String addr)
    {
        if(addr.length() < 7 || addr.length() > 15 || "".equals(addr))
        {
            return false;
        }
        /**
         * 判断IP格式和范围
         */
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

        Pattern pat = Pattern.compile(rexp);

        Matcher mat = pat.matcher(addr);

        boolean ipAddress = mat.find();

        return ipAddress;
    }


}
