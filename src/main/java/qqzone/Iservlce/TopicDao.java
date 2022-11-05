package qqzone.Iservlce;

import qqzone.Modio.Topic;
import qqzone.Modio.UserBasic;

import java.util.List;

public interface TopicDao {

    //获取指定用户的所有日志
    public List<Topic> getTopicList(UserBasic userBasic);

    //添加日志
    public void addTopic(Topic topic);

    //删除日志
    void delTopic(Topic topic);

    //获取特定的日志信息
    Topic getTopic(Integer id);

}
