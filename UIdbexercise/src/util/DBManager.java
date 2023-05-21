package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ����ʵ��JDBC�ķ�װ����Ҫʵ�ִ��������
 * ��������ĳ�����̣���Ա��������Ա��������
 * ���ݿ�ķ��ʲ��裺
 * ��1�������������������ӣ����������󣨷�װ�ڹ��췽���У�
 * ��2������insert��delete��update֮��Ĳ�����������Ӱ��ļ�¼����
 * ��>0�����ʾ�����ɹ��������ʾ����ʧ�ܣ���Ҫʵ��һ������
 * ��3������select�Ĳ��������ص��ǲ�ѯ���ļ�¼������Ҫʵ��һ������
 * ��4�������ݿ����Ӷ���Ĺرգ����ͷ���Դ�������Դ����ʱ���ͷţ�ϵͳ�������
 * ��out of memory���Ĵ��󣬵���ϵͳ����
 * 
 */
public class DBManager {
	//��Ա�ĳ�Ա����
	private Connection con;
	private Statement stm;
	private ResultSet rs;
	
	//����Ϊ��װ�ĳ�Ա����
	/*
	 * 1.���췽����ʵ�ּ����������������ӣ�����������
	 */
	public DBManager(){
		try {
			// 1.��������
			String driverName = "com.mysql.jdbc.Driver"; // mysql
															// jdbc����������,ʵ���Ͼ���driver���ڰ��е�����·��
			Class.forName(driverName);

			// 2.���������ݿ������
			String url = "jdbc:mysql://127.0.0.1:3306/sale?useUnicode=true&characterEncoding=utf-8"; // ���ݿ������ַ�����һ��ʹ��ͳһ��Դ��λ����url������ʽ

			String user = "root"; // �������ݿ�ʱ���û�
			String password = "root"; // �������ݿ�ʱ������
			con = DriverManager.getConnection(url, user, password);

			//3.����������
			stm = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 2.����insert��delete��update֮��Ĳ���,�����쳣�ĳ��������Բ�ȡ���ַ�ʽ
	 * ��1��ʹ��try��catch
	 * ��2)ֱ���׳���ʹ��thows�������������߽��д���
	 */
	public boolean executeUpdate(String sql) throws SQLException{
		boolean ret=false;
		int i=stm.executeUpdate(sql);
		if(i>0){
			ret=true;
		}
		return ret;		
	}
	
	/*
	 * 3.����select�Ĳ���
	 */
	
	public ResultSet executeQuery(String sql) throws SQLException{
		rs=stm.executeQuery(sql);
		return rs;
	}
	
	
	/*
	 * 4.��Դ���ͷ�
	 */
	
	public void close(){
		try {
			if (rs != null) {

				rs.close();

			}

			if (stm != null) {
				stm.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
