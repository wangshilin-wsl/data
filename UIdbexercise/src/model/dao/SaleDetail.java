package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.vo.SaleDetil;
import util.DBManager;

public class SaleDetail {
	
	public static boolean add(SaleDetil s){
		boolean ret=false;
		String sql="insert into tsaledetail ";
		sql+="values('"+s.getId()+"','"+s.getBarcode()+"','"
				+s.getProduct()+"','"
				+s.getPrice()+"','"
				+s.getTotalnumber()+"','"+s.getSaletime()+"','"+s.getSaleperson()+"')";
		DBManager db=new DBManager();
			try {
				if(db.executeUpdate(sql))
					ret=true;
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		
		return ret;
	}
	
	public static String get()
	{
		String name=null;
		String id=null;
		String id1=new SimpleDateFormat("yyyyMMdd").format(new Date());
		String sql="select Id "
				+"from tsaledetail "
				+"where id like'"+id1+"%'"
				+"order by Id ";
		DBManager db=new DBManager();
		try {
			ResultSet a=db.executeQuery(sql);
			while(a.next())
			{
				name=a.getString(1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(name!=null)
		id=name.substring(8);
		/*String newSequence;
		int last=Integer.parseInt(id);  //转换为整形
		last=last+1;
		newSequence=String.valueOf(last);
		while(newSequence.length()<4){
			newSequence="0"+newSequence;
		}*/
		return id;
	}
	
	public static ResultSet getAll(String today)
	{
		ResultSet all=null;
		String sql="select * "
				+"from tsaledetail "
				+"where Id like"+"'"+today+"%'";
		DBManager db=new DBManager();
		try {
			all=db.executeQuery(sql);

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	
		return all;
	}
}
	
