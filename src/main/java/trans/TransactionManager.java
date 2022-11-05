//package trans;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class TransactionManager { //事物的提交类
//
//
//    private   ThreadLocal<Connection>  threadLocal=new ThreadLocal<>(); //事物
//
//    //开启事物
//    public void beginTrans() throws SQLException {
//        ConnUtil.getConn().setAutoCommit(false);
//    }
//
//    //提交事物
//    public void commit() throws SQLException {
//        Connection conn = ConnUtil.getConn();
//        conn.commit();
//        ConnUtil.closeConn();
//
////        ConnUtil.getConn().commit();  //此类没写
//
//    }
//     //回滚事物
//    public  void rollback() throws SQLException {
//        Connection conn = ConnUtil.getConn();
//        conn.rollback();
//        ConnUtil.closeConn();
////        ConnUtil.getConn().rollback();   //此类没写
//    }
//}
