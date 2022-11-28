package coma.Utio;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IP {
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
                String replace2 = replace1.replace("<br> <a class=\"z-tc\" data-toggle=\"modal\" data-target=\".ip138\" style=\"text-decoration: none;cursor:pointer;color:#c0c1c4;\">ip138�ṩ</a> ", "");

                System.out.println("当前ip"+replace2);
            }
        } catch (Exception e) {
            System.out.println("查找失败");
        }

        return "127.0.0.1";
    }

    public static boolean isIP(String addr)
    {
        if(addr.length() < 7 || addr.length() > 15 || "".equals(addr))
        {
            return false;
        }
        /**
         * �ж�IP��ʽ�ͷ�Χ
         */
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

        Pattern pat = Pattern.compile(rexp);

        Matcher mat = pat.matcher(addr);

        boolean ipAddress = mat.find();

        return ipAddress;
    }


}
