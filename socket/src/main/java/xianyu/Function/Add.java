
package xianyu.Function;

import xianyu.database.ConnectDatabase;
import xianyu.database.CreateDatabaseAndTable;
import xianyu.database.Message;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Add extends ConnectDatabase {
    CreateDatabaseAndTable cdt = new CreateDatabaseAndTable();//创建数据库和数据表
    int isOK ;
    public int insertMessage(Message c) {
        connectDatabase();   //继承于父类，连接数据库，创建连接对象con，
        try {
            String SQL ="insert into message values(?,?)";
            PreparedStatement sta  = con.prepareStatement(SQL);

            //从左向右数第1个通配符的值是word.getID():
            sta.setString(1,c.getID());
            //从左向右数第2个通配符的值是word.getName():
            sta.setString(2,c.getPassword());


            isOK = sta.executeUpdate();
            //con.close();    //关闭连接
        }
        catch(SQLException e) {
            isOK = 0; //course表中ID字段是主键，即不允许课程ID重复
            System.out.println("用户名ID已存在！");
        }
        return isOK;
    }
}
