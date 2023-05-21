package controller;

import model.vo.User;
import view.Login;

public class SuperMarket {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Login l=new Login();
		 User user=new User();
		user=l.login();
	}
} 
