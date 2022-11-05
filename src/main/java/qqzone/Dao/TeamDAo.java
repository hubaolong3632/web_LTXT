package qqzone.Dao;

import qqzone.Iservlce.ITeamDao;
import qqzone.Modio.QQPath;
import qqzone.Modio.QQname;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeamDAo implements ITeamDao {
    @Override
    public void addingClanData(QQname qqname) throws SQLException {
        Statement sm = DaoConnect.daoConnection();  //用来数据的操作
        ResultSet set = DaoConnect.selectDB("SELECT name FROM s_qqname  where name=\"" + qqname.getName() + "\" and timedata=\""+qqname.getTimeData()+"\";");
        if(!set.next()){ //添加处理条(如果没有当前日期当前年份)
            sm.addBatch("INSERT INTO `qqzhondb`.`s_qqname`( `name`, `qq`, `ensure`, `ip`, `timedata` ) VALUES ( '"+qqname.getName()+"', '"+qqname.getQq()+"', 'NO', '"+qqname.getIp()+"', '"+qqname.getTimeData()+"');");
        }

        for (QQPath path : qqname.getPath()) { //队数据进行插入
         String  sql="insert into s_qqpath(name,path) values(\""+qqname.getName()+"\",\""+path.getPath()+"\");";
            sm.addBatch(sql.replace("\\","\\\\"));

        }
         sm.executeBatch(); //数据批量插入
    }

    @Override
    public List<QQname> selectTeam() {
        List<QQname> listName=new ArrayList<>();
        try {
         QQname name=null;
        String sql="select id,name,qq,ip,time,price from s_qqname;";

        ResultSet set = DaoConnect.selectDB(sql);
          while (set.next()){

              ResultSet set2 = DaoConnect.selectDB("select * from s_qqpath where name=\""+set.getString("name")+"\";");
              List<QQPath> listPath=new ArrayList<>();
              while (set2.next()){
                  listPath.add(new QQPath(set2.getString("path"))); //只需要路径
              }
              name=new QQname(set.getInt("id"),set.getString("name"),set.getString("qq"),set.getString("ip"), set.getString("time"),set.getInt("price"));
              name.setPath(listPath); //保存路径集合
              listName.add(name); //保存集合
          }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listName;
    }


}
