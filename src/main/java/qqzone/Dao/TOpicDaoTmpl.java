package qqzone.Dao;

import qqzone.Iservlce.TopicDao;
import qqzone.Modio.Topic;
import qqzone.Modio.UserBasic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOpicDaoTmpl  implements TopicDao { //日志查询
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) { //说说
        List<Topic>  topicList=new ArrayList<>();
        try{
            String sql="select * from t_topic where author="+userBasic.getId()+";";
            ResultSet set = DaoConnect.selectDB(sql);

            while(set.next()) {
                topicList.add(new Topic(set.getInt("id"), set.getString("title"), set.getString("content"), set.getDate("topicDate"),userBasic));
                //获取说说
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return topicList;
    }

    @Override
    public void addTopic(Topic topic) { //添加说说



    }

    @Override
    public void delTopic(Topic topic) { //删除说说

    }

    @Override
    public Topic getTopic(Integer id) {
        System.out.println("123123123");
        return null;
    }
}
