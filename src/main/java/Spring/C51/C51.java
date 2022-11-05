package Spring.C51;

import Moide.Message;
import Spring.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


@WebServlet("/C51_kill")
public class C51 extends ViewBaseServlet {
    public   static Socket socket;
static {
        try {
                socket=new Socket(InetAddress.getByName("127.0.0.1"),9999);
        } catch (IOException e) {
                e.printStackTrace();
        }
}
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                System.out.println("进入成功");
                super.processTemplate("C51_kill",req,resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.setCharacterEncoding("UTF-8");


                String c1 = req.getParameter("a1");


                switch (c1){
                        case "1档": c1="A";break;
                        case "2档": c1="B";break;
                        case "3档": c1="C";break;
                        case "关闭": c1="D";break;
                }
                System.out.println(c1);
                doGet(req, resp); //跳转回去

                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        System.out.println("传输给服务端的:");
                        oos.writeObject(new Message(c1)); //发送对象

        }
}
