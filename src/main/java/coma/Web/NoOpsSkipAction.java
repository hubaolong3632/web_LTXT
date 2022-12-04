package coma.Web;

import coma.Form.Father;
import coma.Form.Pzwj;
import coma.Iservice.IServiceDao;
import coma.Service.Main01Filter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 *最普通的跳转无操作
 */

@Component("NoOpsSkipAction")
public class NoOpsSkipAction extends Action {
    @Resource
    IServiceDao dao; //数据库层
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        System.out.println("----------调用api然后跳转到<"+pzwj.getLiu()+">-----------");
        main.processTemplate(pzwj.getLiu(),req,resp); //首页显示

    }

}
