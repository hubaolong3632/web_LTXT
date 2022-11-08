import com.mysql.cj.protocol.x.OkBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//rwerwerwerwerwe42342342342
public class DaoConnect {
    public static Statement daoConnection() throws SQLException {
        Connection conn;
        Statement stmt;
        try
        {
            Driver driver=new com.mysql.cj.jdbc.Driver(); //最后应该Driver最后导入一下
            DriverManager.registerDriver(driver);

            String url="jdbc:mysql://43.142.237.246:3306/qqzhondb?characterEncoding=utf8";//数据库名stdio
            String user="name";//账号
            String password="dzqdb123";//密码

            conn=DriverManager.getConnection(url,user,password);//传输字符串语句
            stmt=conn.createStatement();

        }
        catch (Exception e)
        {
            throw new SQLException("数据库连接失败!"); //如果连接失败直接抛出异常结束运行
        }



        return stmt;//传输过去我的值
    }


    public static ResultSet selectDB(String sql){
        ResultSet resultSet=null;
        try
        {

                resultSet = daoConnection().executeQuery(sql);//获取数据库存储的值
                daoConnection().close();//关闭数据库
        }
        catch (Exception e)
        {
            System.out.println("数据库查询失败");
        }

        return resultSet;
    }



    public static int daoZSG(String sql)  //添加修改删除 封装起来上面直接调用就可以了
    {
        int a=-1;
        try
        {
            a=daoConnection().executeUpdate(sql);//吧sql语句放进去
            daoConnection().close();//关闭数据库
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }

        return a;//返回是否成功 1为成功 -1为不成功
    }





}




