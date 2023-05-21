package xianyu.controller;

import xianyu.client.Client;
import xianyu.Function.Login;
import xianyu.database.Message;
import xianyu.view.windowlogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HandleLogin implements ActionListener{
	windowlogin win;
	Message c1 = new Message();
	Message c[] ;

	public HandleLogin(windowlogin win){
		this.win = win;
	}

	public void actionPerformed(ActionEvent e) {



		c1.setID(win.textField.getText());
		c1.setPassword(win.textField_1.getText());

		Client client=new Client(win);
		client.connect();


		Login login = new Login();
		Message c[]  = login.loginMessage(c1);
		int i=c.length;
		if(i > 0)
		{
			JOptionPane.showMessageDialog(null, "登录成功");
			return;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "登录失败");
			return;
		}

	}

}