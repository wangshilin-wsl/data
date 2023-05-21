package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.User;
import util.DBManager;

/*
 * dao��data access object�����ڲ����ķ�װ
 */
public class UserDao {
	/*
	 * �÷���ʵ�ְ������ֶε���ϲ�ѯ����������ѯ���������user�����У�
	 * ��user����ĳ����Ա����Ϊnull�����ʾ���ʱ���Ը��ֶ�,
	 * ���ڸ÷����Ǳ�view�����õģ���˾�������ѯ�������ResultSet��ת��Ϊ���϶���
	 */
	public List<User> query(User user){
		List<User> list=new ArrayList<User>();
		/*
		 * 
		 */
		/*
		 * ��ϲ�ѯ���ɵĶ�̬sql���
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		return ret;
	}
	
	/*
	 * �û���½
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
