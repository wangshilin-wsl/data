package xianyu.client;


import xianyu.view.windowlogin;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client {
	private Socket sk;
	private windowlogin win;
	/*public static void main(String[] args) {
		Client client = new Client();
		client.connect();
	}*/

	public Client(windowlogin win) {
		this.win = win;
	}

	/**
	 * 创建客户端并连接到服务器
	 */
	public void connect() {

		try {
			sk = new Socket("localhost",8088);
			System.out.println("创建客户端成功");
			//拿到自身的输出流
			OutputStream outputStream = sk.getOutputStream();
			//将字节流转换为字符流
			OutputStreamWriter writer = new OutputStreamWriter(outputStream, "utf-8");






			//windowlogin win=new windowlogin();



			String id1 = win.textField.getText();
			String password = win.textField_1.getText();

			System.out.println(id1+"  "+password);
			//id长度不能大于8位
			if(id1.length()>8) {
				JOptionPane.showMessageDialog(null, "id长度不能大于8位");
				return;

			}
			//password长度不能大于16位
			if(password.length()>16) {
				JOptionPane.showMessageDialog(null, "password长度不能大于16位");
				return;
			}
			//password的强度问题
			CheckPassword checkPassword	= new CheckPassword();
			checkPassword.checkPassword(password);






			//创建缓冲区
			PrintWriter id = new PrintWriter(writer,true);
			id.println (id);
			//System.out.print("\r\n");
			PrintWriter pw = new PrintWriter(writer,true);
			id.print(password);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

