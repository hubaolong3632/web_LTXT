package coma.Web;

import coma.Form.Father;
import coma.Form.Login;
import coma.Form.Pzwj;
import coma.Iservice.IServiceDao;
import coma.Model.GoodFriendModel;
import coma.Model.LoginModel;
import coma.Model.NoModel;
import coma.Service.Main01Filter;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/***
 *登入界面
 */

@Component("LoginAction")
public class LoginAction extends Action{

    @Resource
    IServiceDao dao; //数据库层
    @Override
    public void execute(Father father, Pzwj pzwj, HttpServletRequest req, HttpServletResponse resp, Main01Filter main) throws ServletException, IOException {
        Login login= (Login) father; //转换为账号密码类

        req.getSession().setAttribute("username",login.getName());//不知道那里来的语句
        LoginModel loginModel=new LoginModel(login.getName(),login.getPassword()); //转换成model层
        LoginModel from = dao.user_pwd(loginModel); //放入账号密码进行判断


        if(from==null){ //如果数据库不存在当前用户

            req.setAttribute("nologin",new NoModel("登入失败当前账号或者密码错误！！！",loginModel));
            System.out.println("登入失败!");




//            req.setAttribute("nologin",loginModel);//登入失败放在上面用的东西
//            req.setAttribute("no","登入失败当前账号或者密码错误！！！"); //输出错误提示
             main.processTemplate("login",req,resp); //跳转指定网站
        }else{
            System.out.println("查找到的头像:"+from.getInfo().getHeadimg());

            List<GoodFriendModel> friend = dao.getFriend( new GoodFriendModel(from.getName()));  //查找他的好友

            if(friend!=null){ //如果有好友
                from.setGetFriend(friend); //保存好友
                for (GoodFriendModel friendModel : friend) {
                    System.out.println("当前拥有的好友:" + friendModel.getFname());
                }
            }else{
                System.out.println("集合为空");
            }




            System.out.println("005-Action: 登入的账号为:"+from.getName()+"  密码为:"+from.getPassword()+"     \n 图片位置为:"+from.getInfo().getHeadimg()); //测试当前账号密码是
            req.getSession().setAttribute("login",from); //保存账号密码
            System.out.println("006-Action: 下一个跳转的网页:"+pzwj.getLiu());

            resp.sendRedirect(pzwj.getLiu()); //登入成功跳转到指定网页



        }


    }
}
