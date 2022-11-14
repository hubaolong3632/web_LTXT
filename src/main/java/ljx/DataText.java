package ljx;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataText {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");//获取时间
        Date date = new Date();
        System.out.println(formatter.format(date));
    }
}
