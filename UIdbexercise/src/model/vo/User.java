package model.vo;

/*
 * vo��ʾvalue object����Ҫʵ�����ݵķ�װ���������ݿ���һ�������ͼ���Ӧ
 * �����ʵ�ֻ�������һ���̶���ģ�壬��˺ܶཨģ���ߣ���rose�ȣ��ܹ��������ݿ��еı����ͼ�Զ����ɸ��ļ����˹��̳�Ϊ�����򹤳̡�
 */
public class User {
	
	private String userName;
	private String password;
	private String chrName;
	private String roleName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChrName() {
		return chrName;
	}
	public void setChrName(String chrName) {
		this.chrName = chrName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	

}
