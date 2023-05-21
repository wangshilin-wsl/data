package xianyu.database;
import java.sql.*;


public class CreateDatabaseAndTable{
    Connection con;
    public  CreateDatabaseAndTable(){
        //1.加载Derby驱动
        try{Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        }
        catch(Exception e){}
        try{ //2.创建名字是message的数据库：
            String uri ="jdbc:derby:Message;create=true";
            con=DriverManager.getConnection(uri); //连接数据库代码

        }
        catch(Exception e){}
        try {
            Statement sta = con.createStatement();
            String SQL="create table message"+
                    "(ID char(8) primary key,password char(16))";
            sta.executeUpdate(SQL);//创建表course
            con.close();   // 关闭数据库连接
        }
        catch(SQLException e) {//如果表已经存在，将触发SQL异常，即不再创建该表
        }
    }
}