import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlManager {
	private static Connection mConnect;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			mConnect=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","xfy123");
		
		}catch(ClassNotFoundException e){
			//e.printStackTrace();
		}catch(SQLException e) {
			//e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		return mConnect;
	}
	public static void close() {
		try {
			mConnect.close();
			
		}catch(SQLException e) {
			//e.printStackTrace();
		}
	}

}
