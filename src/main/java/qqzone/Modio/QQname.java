package qqzone.Modio;

import java.util.ArrayList;
import java.util.List;

public class QQname {
    private int id;
    private String name;
    private String qq;
    private String ip;
    private String timeData;
    private int price;
    private List<QQPath> path=new ArrayList<>();



    public QQname() {
    }

    public QQname(int id, String name, String qq, String ip, String timeData, int price) {
        this.id = id;
        this.name = name;
        this.qq = qq;
        this.ip = ip;
        this.timeData = timeData;
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTimeData() {
        return timeData;
    }

    public void setTimeData(String timeData) {
        this.timeData = timeData;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public List<QQPath> getPath() {
        return path;
    }

    public void setPath(List<QQPath> path) {
        this.path = path;
    }
}
