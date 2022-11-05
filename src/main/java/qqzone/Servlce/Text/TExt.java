package qqzone.Servlce.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TExt {
    public static void main(String[] args) {
        SimpleDateFormat formatter= new SimpleDateFormat("'上传日期:'yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
    }
}
interface JK{
    private void abc() {
        System.out.println("私有方法");
    }

     default void aaa() {
        System.out.println("默认方法");
    }

    void bbb();
}
class  syh implements JK{

    JK s=new JK() {
        @Override
        public void bbb() {
            System.out.println(1);
        }
    };

    @Override
    public void bbb() {
    }
}
