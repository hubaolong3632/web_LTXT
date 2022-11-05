package qqzone.Servlce;

import qqzone.Modio.UserBasic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserBasicService {
    //根据账号和密码获取用户特定信息
    public String login(String loginID, String pwd, HttpSession session);


    String friend(Integer id, HttpSession session);
}
