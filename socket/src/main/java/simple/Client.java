package simple;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	private Socket sk;
	public static void main(String[] args) {
		Client client = new Client();
		client.connect();
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
			//创建缓冲区
			PrintWriter pw = new PrintWriter(writer,true);
			String s="abcd";
			pw.println(s);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

