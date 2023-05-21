package model.dao;

import model.vo.User;
import util.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * dao即data access object，用于操作的封装
 */
public class UserDao {
	/*
	 * 该方法实现按各个字段的组合查询，，各个查询参数存放于user对象中，
	 * 如user对象某个成员变量为null，则表示组合时忽略该字段,
	 * 由于该方法是被view所调用的，因此经常将查询结果集（ResultSet）转换为集合对象
	 */
	public List<User> query(User user){
		List<User> list=new ArrayList<>();
		/*
		 * 
		 */
		/*
		 * 组合查询生成的动态sql语句
		 */
		String sql="select * from user where 1=1 ";
		if(user.getUserName()!=null){
			sql+=" and name='"+user.getUserName()+"' ";
		}
		if(user.getPassword()!=null){
			sql+=" and pw='"+user.getPassword()+"' ";
		}

		//System.out.println(sql);
		try {
			DBManager db=new DBManager();
			ResultSet rs;
			Connection conn=db.getConnection();
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				User user1=new User();
				user1.setUserName(rs.getString("name"));
				user.setPassword(rs.getString("pw"));
				list.add(user1);				
			}
            db.close(rs,stmt,conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public boolean insert(User user){
		String sql="insert into user values('"+user.getUserName()+"','"+user.getPassword()+"') ";
		int rs=0;
		try {
			DBManager db=new DBManager();
			Connection conn=db.getConnection();


			Statement stmt=conn.createStatement();

			rs=stmt.executeUpdate(sql);
			db.close(null,stmt,conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0){
			return true;
		}else {
			return false;
		}
	}
	/*
	 * 用户登陆
	 */
	public boolean checkUser(User  user){
		boolean ret=false;
		List<User> list=query(user);
		if(list.size()>0){
			ret=true;
		}
		return ret;
	}
}
