package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBManager;

public class Product {
	public static String lookForName(String code)
	{
		String name=null;
		String sql="select product "
				+"from tproduct "
				+"where barcode='"+code+"'";
		DBManager db=new DBManager();
		try {
			ResultSet a=db.executeQuery(sql);
			while(a.next())
			name=a.getString(1);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return name;
	}
	public static int lookForStock(String code)
	{
		int name=0;
		String sql="select Stock "
				+"from tproduct "
				+"where barcode='"+code+"'";
		DBManager db=new DBManager();
		try {
			ResultSet a=db.executeQuery(sql);
			while(a.next())
			name=a.getInt(1);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return name;
	}
public static float lookForPrice(String code)
		{
			float price=0;
			String sql="select price "
					+"from tproduct "
					+"where barcode='"+code+"'";
			DBManager db=new DBManager();
			try {
				ResultSet a=db.executeQuery(sql);
				if(a.next())
				price=a.getFloat(1);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return price;
		}
public static void update(String code,int i)
{
	int j=lookForStock(code);
	int value=j-i;
	String sql="update tproduct "
			+"set stock='"+String.valueOf(value)+"'"
			+"where barcode='"+code+"'";
	DBManager db=new DBManager();
	try {
		db.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return ;
}

}
