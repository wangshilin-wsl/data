package model.vo;

/*
 * vo表示value object，主要实现数据的封装，常与数据库中一个表或视图相对应
 * 该类的实现基本上是一个固定的模板，因此很多建模工具（如rose等）能够根据数据库中的表和视图自动生成该文件，此过程称为“反向工程”
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
