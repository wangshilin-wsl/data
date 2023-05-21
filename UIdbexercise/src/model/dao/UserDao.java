package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.User;
import util.DBManager;

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
		List<User> list=new ArrayList<User>();
		/*
		 * 
		 */
		/*
		 * 组合查询生成的动态sql语句
		 */
		String sql="select * from tuser where 1=1 ";
		if(user.getUserName()!=null){
			sql+=" and userName='"+user.getUserName()+"' ";
		}
		if(user.getPassword()!=null){
			sql+=" and password='"+user.getPassword()+"' ";
		}
		if(user.getChrName()!=null){
			sql+=" and chrName='"+user.getChrName()+"' ";
		}
		if(user.getRoleName()!=null){
			sql+=" and roleName='"+user.getRoleName()+"' ";
		}
		
		//System.out.println(sql);
		
		DBManager db=new DBManager();
		ResultSet rs=null;
		try {
			rs=db.executeQuery(sql);
			while(rs.next()){
				User user1=new User();
				user1.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setChrName(rs.getString("chrName"));
				user.setRoleName(rs.getString("roleName"));
				list.add(user1);				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean add(User user){
		boolean ret=false;
		String sql="insert into tuser ";
		sql+="values('"+user.getRoleName()+"','"+user.getChrName()+"','"+user.getPassword()+"')";
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
