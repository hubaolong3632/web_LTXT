package qqzone.Servlce.Text;

import qqzone.Dao.TOpicDaoTmpl;
import qqzone.Dao.UserBasicDaoImpl;
import qqzone.Iservlce.TopicDao;
import qqzone.Iservlce.UserBasicDao;
import qqzone.Modio.Topic;
import qqzone.Modio.UserBasic;
import qqzone.Servlce.UserBasicService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserBasicText implements UserBasicService{


    UserBasicDao userBasicDao=new UserBasicDaoImpl();
    TopicDao topicDao=new TOpicDaoTmpl();
    @Override
    public String login(String loginID, String pwd, HttpSession session) {
        UserBasic userBAsic = userBasicDao.getUserBAsic(loginID, pwd); //获取登入

        if(userBAsic!=null){ //如果获取到了账号密码
            userBAsic.setFriendList(userBasicDao.getUserBasicList(userBAsic)); //获取好友列表
            userBAsic.setTopicList(topicDao.getTopicList(userBAsic)); //获取说说

            session.setAttribute("userBAsic",userBAsic); //存储数据
//            session.setAttribute("friend",topicDao.getTopicList(userBAsic)); //获取到当前好友的说说
//            System.out.println("存储成功");
            return "index";
        }
        return "login";
    }

    @Override
    public String friend(Integer id, HttpSession session) {   //查看好友的说说
        UserBasic currFriend = userBasicDao.getUserBasicById(id); //更具id查找到好友信息

        List<Topic> list = topicDao.getTopicList(currFriend); //通过好友信息获取到好友说说

        session.setAttribute("friend",list); //获取到当前好友的说说
        return "list";
    }


}
