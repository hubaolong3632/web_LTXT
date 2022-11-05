package qqzone.Modio;

public class QQPath {
    private int id;
    private String name;
    private String path;

    public QQPath(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public QQPath(String path) {
        this.path = path;
    }

    public QQPath(int id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
