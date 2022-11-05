package Spring.team;

import Spring.ViewBaseServlet;
import qqzone.Dao.TeamDAo;
import qqzone.Iservlce.ITeamDao;
import qqzone.Modio.QQPath;
import qqzone.Modio.QQname;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/image_dispose")
public class Image_dispose extends ViewBaseServlet {
ITeamDao iTeamDao=new TeamDAo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<QQname> qname = iTeamDao.selectTeam();

        System.out.println("-------------步入数据库获取图片-----------");


        req.getSession().setAttribute("qname",qname);



        super.processTemplate("image_dispose.html",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入成功");
    }
}
