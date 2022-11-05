package qqzone.Iservlce;

import qqzone.Modio.QQname;

import java.sql.SQLException;
import java.util.List;

public interface ITeamDao {
   void addingClanData(QQname qqname) throws SQLException;  //添加记录
   List<QQname> selectTeam();  //查询本周所有

}
