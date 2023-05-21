package utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    //使用durid连接池
    private static DruidDataSource dataSource;
    static {
        InputStream inputStream=JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties=new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource=new DruidDataSource();
        dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
        dataSource.setUrl(properties.getProperty("jdbc.url"));
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));
    }
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    public static  Connection getConn() throws SQLException {
        if (threadLocal.get()==null){
            threadLocal.set(getConnection());
        }
        return threadLocal.get();
    }
 private   static Connection getConnection() throws SQLException {
     Connection connection= dataSource.getConnection();
        return connection;
 }
 public  static void close(Connection connection) throws SQLException {
        if(connection!=null){
            connection.close();
        }
 }
}
