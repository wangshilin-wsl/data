package xianyu.controller;

import xianyu.client.Client;
import xianyu.database.Message;
import xianyu.view.windowlogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HandleAdd implements ActionListener{
	windowlogin win;
	Message c1 = new Message();

	public HandleAdd(windowlogin win){
		this.win = win;
	}

	public void actionPerformed(ActionEvent e) {



		c1.setID(win.textField.getText());

		c1.setPassword(win.textField_1.getText());

		Client client=new Client(win);
		client.connect();

		/*Add add = new Add();
		int i = add.insertMessage(c1);
		if(i > 0)
		{
			JOptionPane.showMessageDialog(null, "注册成功");
			return;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "注册失败");
			return;
		}*/

	}

}