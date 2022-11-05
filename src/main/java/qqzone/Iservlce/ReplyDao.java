package qqzone.Iservlce;

import qqzone.Modio.Reply;
import qqzone.Modio.Topic;

import java.util.List;

public interface ReplyDao {  //回复的
    //获取指定回复日志列表
    List<Reply> getReplyList(Topic topic);

    //添加回复
    void addReply(Reply reply);

    //删除回复
    void delReply(Integer id);





}
