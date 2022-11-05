//package trans;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class OpenSessionInViewFilter {
//
//
//    private   ThreadLocal<Connection>  threadLocal=new ThreadLocal<>(); //事物
//
//    //开启事物
//    public void beginTrans() throws SQLException {
//        Connection con = threadLocal.get();
//        if(con==null){
////            con=ConnUtil.getConn(); //
//                threadLocal.set(con); //重新设置此类
//        }
//
//        con.setAutoCommit(false); // 不要让事物自动提交
//
//    }
//
//    //提交事物
//    public void commit() throws SQLException {
//        Connection con = threadLocal.get();
//        if(con==null){  //如果没获取到
//        return;
//        }
//        if(!con.isClosed()){ //如果是打开的状态, 就把他关闭
//            con.close(); //如果没获取到
//            threadLocal.set(null);
//        }
//
//        con.setAutoCommit(false); // 不要让事物自动提交
//
////        ConnUtil.getConn().commit();  //此类没写
//
//    }
//     //回滚事物
//    public  void rollback(){
////        ConnUtil.getConn().rollback();   //此类没写
//    }
//}
