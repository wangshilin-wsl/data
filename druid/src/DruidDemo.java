
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties properties=new Properties();
        InputStream is=DruidDemo.class.getResourceAsStream("druid.properties");
        properties.load(is);
        //获取连接池对象
        DataSource ds=DruidDataSourceFactory.createDataSource(properties);
        //获取连接对象
        Connection connection=ds.getConnection();
        System.out.println(connection);
    }
}
