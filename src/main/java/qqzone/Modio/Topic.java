package qqzone.Modio;

import java.util.Date;
import java.util.List;

public class Topic {   //说说
     private Integer id;
     private String  title;
     private String content;
     private Date topicDate;
     private UserBasic author; //这里面是多对一
    private List<Reply> replyList; //1:N 一个说说对应多个回复


    public Topic() {
    }

    public Topic(Integer id, String title, String content, Date topicDate,UserBasic author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.topicDate = topicDate;
        this.author=author;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Date topicDate) {
        this.topicDate = topicDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }
}
