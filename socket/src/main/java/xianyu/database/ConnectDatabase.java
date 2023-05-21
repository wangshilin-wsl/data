package xianyu.database;
import java.sql.*;

public class ConnectDatabase{
    public Connection con;
    public final void connectDatabase() {
        try{
            String uri ="jdbc:derby:Message;create=false";
            con=DriverManager.getConnection(uri);//连接数据库代码
        }
        catch(Exception e){}
    }
}