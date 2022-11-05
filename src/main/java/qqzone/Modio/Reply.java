package qqzone.Modio;

import java.util.Date;
import java.util.List;

public class Reply {  //说说好友回复
    private Integer id;
    private String content;
    private Date replyDate;
    private UserBasic author;  //主人 M:1
    private Topic topic; // 对应的说说 M:1

    private List<HostReply> hostReplyList; //主人回复

    public Reply() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<HostReply> getHostReplyList() {
        return hostReplyList;
    }

    public void setHostReplyList(List<HostReply> hostReplyList) {
        this.hostReplyList = hostReplyList;
    }
}
