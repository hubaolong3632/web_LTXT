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
                System.out.println("����ɹ�");
                super.processTemplate("C51_kill",req,resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.setCharacterEncoding("UTF-8");


                String c1 = req.getParameter("a1");


                switch (c1){
                        case "1��": c1="A";break;
                        case "2��": c1="B";break;
                        case "3��": c1="C";break;
                        case "�ر�": c1="D";break;
                }
                System.out.println(c1);
                doGet(req, resp); //��ת��ȥ

                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        System.out.println("���������˵�:");
                        oos.writeObject(new Message(c1)); //���Ͷ���

        }
}
