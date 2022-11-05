package qqzone.Dao;

import qqzone.Modio.Topic;
import qqzone.Modio.UserBasic;
import qqzone.Iservlce.UserBasicDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserBasicDaoImpl  implements UserBasicDao {  //登入获取好友信息
    @Override
    public UserBasic getUserBAsic(String loginID, String pwd) {


        try{
            String sql="select * from t_user_basic where loginid=\""+loginID+"\" and pwd=\""+pwd+"\"";




            ResultSet set = DaoConnect.selectDB(sql);
            System.out.println(sql);
        if(set!=null&&set.next()) {
              return  new UserBasic(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5));
                //获取登入
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) { //好友

        String sql="select  a.id,a.loginid,a.nickName,a.heagime\n" +
                "FROM t_friend\n" +
                "left JOIN t_user_basic a on a.id=t_friend.fid\n" +
                "where t_friend.uid="+userBasic.getId()+";";
        List<UserBasic> list=new ArrayList<>();

        try{
            ResultSet set = DaoConnect.selectDB(sql);
            while (set.next()) {

                list.add(new UserBasic(set.getInt("id"), set.getString("loginID"), set.getString("nickName"), set.getString("heagime")));
                //获取好友列表
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public UserBasic getUserBasicById(Integer id) { //通过id查询用户详细信息

        return  null;
    }
}
