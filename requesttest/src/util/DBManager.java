package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBManager {
	private static DataSource ds;
	static {
		try {
			//加载配置文件
			Properties properties=new Properties();
			InputStream is= DBManager.class.getClassLoader().getResourceAsStream("druid.properties");
			properties.load(is);
			//获取连接池对象
			 ds= DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	public  void close(Statement stat, Connection connection){
		close(null,stat,connection);
	}
	public  void close(ResultSet resultSet,Statement stat, Connection connection){
		if(resultSet!=null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static DataSource getDtaSource(){
		return ds;
	}
}
