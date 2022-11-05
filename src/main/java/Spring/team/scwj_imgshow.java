package Spring.team;

import Spring.ViewBaseServlet;
import qqzone.Modio.UserBasic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/scwj_imgshow")
public class scwj_imgshow  extends ViewBaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println();
        super.processTemplate("scwj_imgshow",req,resp);
    }
}
