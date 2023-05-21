package test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        //1.1创建数据库连接池对象,什么都没传，用的是默认的配置
        DataSource ds=new ComboPooledDataSource();
        //1.2创建数据库连接池对象，传入名称，用的是相应名称的配置
       // DataSource ds=new ComboPooledDataSource("otherconfig");
        //2/获取连接(Connection)对象
        Connection connection=ds.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
