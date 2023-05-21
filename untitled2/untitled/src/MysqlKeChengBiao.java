import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/*
 * 课程表增改操作
 * 数据库操作
 * 2020-11-29 21：20
 * */


public class MysqlKeChengBiao {
	public Connection mConnect;
	public MysqlKeChengBiao(Connection connection) {
		this.mConnect=connection;
	}
	
	//添加数据
		public void addModel() {
			try {
				Statement statement=mConnect.createStatement();
				String sql="insert into demo(one,two,three,four,five) values("+","+"one"+
				","+"two"+","+"three"+","+"five"+")";
				int testing=statement.executeUpdate(sql);
				
				if(testing>0) {
					JOptionPane.showConfirmDialog(null,
							   "新增成功！","温馨提示",JOptionPane.YES_OPTION);
				}
				else {
					JOptionPane.showConfirmDialog(null,
							   "新增失败！","温馨提示",JOptionPane.YES_OPTION);
				}
				statement.close();
			}catch(SQLException e) {
				JOptionPane.showConfirmDialog(null,
						   "数据库连接失败！","温馨提示",JOptionPane.YES_OPTION);
			}
		}
		
		//查询数据
		public KecehngBean selectModel() {
			KecehngBean model=new KecehngBean();
			try {
				Statement statement=mConnect.createStatement();
				String sql="select * from demo where one=test";
				
				ResultSet result=statement.executeQuery(sql);
				if(result.first()) {
					
					model.setClassify(result.getString("one"));
					model.setMember1(result.getString("two"));
					model.setMember2(result.getString("three"));
					model.setMember3(result.getString("four"));
					model.setMember4(result.getString("five"));
					model.setMember5(result.getString("six"));
					model.setTeacher(result.getString("seven"));
				}
				statement.close();
			}catch(SQLException e) {
				JOptionPane.showConfirmDialog(null,
						   "数据库连接失败！","温馨提示",JOptionPane.YES_OPTION);
			}
			return model;
		}
		
		//更改数据表数据
		public int updatePwd(String row,String one,String two,String three,String four,String five) {
			int result=-1;
			try {
				String sql="update demo set one="+one+","+"two="+two+","+"three="+three
						+","+"four="+four+"five="+five;
				Statement statement=mConnect.createStatement();
				statement.executeUpdate(sql);
				statement.close();
				result=0;
				
				
			}catch(SQLException e) {
				JOptionPane.showConfirmDialog(null,
						   "数据库连接失败！","温馨提示",JOptionPane.YES_OPTION);
			}
			return result;
		}
	
}
