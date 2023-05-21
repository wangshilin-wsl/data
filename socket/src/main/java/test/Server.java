package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket ss;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		server.connect();
		server.strat();
	}

	/**
	 * 服务端开启
	 */
	public void connect(){
		try {
			//创建服务端的端口
			ss = new ServerSocket(8088);
			System.out.println("服务端初始化成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 启动监听
	 */
	public void strat() {

		try {
			//拿到客户端
			Socket accept = ss.accept();
			//获取客户端的ip地址
			String address = accept.getInetAddress().getHostAddress();
			System.out.println("客户端ip为："+address);

			//拿到客户端传递的字节流
			InputStream is = accept.getInputStream();
			//将字节流转换为字符流
			InputStreamReader ins = new InputStreamReader(is,"utf-8");
			//创建输入的缓冲区
			BufferedReader rd = new BufferedReader(ins);
			//读取一行
			String message = rd.readLine();
			System.out.println(address+":"+message);


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}
