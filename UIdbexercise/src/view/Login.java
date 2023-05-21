package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.dao.UserDao;
import model.vo.User;

/*
 * 登陆界面视图
 */
public class Login {

	/**
	 * @param args
	 */
	static String userName = null;
	static String password = null;
	 User user = new User();
	JButton jb1=new JButton("登录");
	JButton jb2=new JButton("退出");
	JFrame jf=new JFrame("登录窗口");
	JTextField t2=new JTextField(25);
	JTextField t3=new JTextField(25);
	/*class MyKeyListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(e.getSource()==t2)
			{
				t3.requestFocus();
				t3.setCaretPosition(0);
			}
			if(e.getSource()==t3)
			{
				userName=t2.getText();
				password =t3.getText();
				user.setUserName(userName);
				user.setPassword(password);
				UserDao dao = new UserDao();
				if (!dao.checkUser(user))
				{
					JOptionPane.showMessageDialog(null, "用户名或密码错误！！！");
					return ;
				} else
				{
					jf.setVisible(false);
					Menu.menu();
					return ;
				}
			}
		}
	}*/
	class MyKeyListener extends KeyAdapter
	{
		public void keyPressed(KeyEvent e) 
		{
			if(e.getSource()==t2&&e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				t3.requestFocus();
				t3.setCaretPosition(0);
			}
			if(e.getSource()==t3&&e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				userName=t2.getText();
				password =t3.getText();
				user.setUserName(userName);
				user.setPassword(password);
				UserDao dao = new UserDao();
				if (!dao.checkUser(user))
				{
					JOptionPane.showMessageDialog(null, "用户名或密码错误！！！");
					return ;
				} else
				{
					jf.setVisible(false);
					Menu menu=new Menu();
					menu.menu(user);
					//Menu.menu(user);
					return ;
				}
			}
		}
	}
	class MyListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(e.getSource()==jb1)
			{
				userName=t2.getText();
				password =t3.getText();
				user.setUserName(userName);
				user.setPassword(password);
				UserDao dao = new UserDao();
				if (!dao.checkUser(user))
				{
					JOptionPane.showMessageDialog(null, "用户名或密码错误！！！");
					return ;
				} else
				{
					jf.setVisible(false);
					Menu menu=new Menu();
					menu.menu(user);
					//Menu.menu(user);
					return ;
				}
			}
			if(e.getSource()==jb2)
			{
				System.exit(0);
			}
		}
	}
	public User login() {
		// TODO Auto-generated method stub
		jf.setResizable(false);
		t2.addKeyListener(new MyKeyListener());
		t3.addKeyListener(new MyKeyListener());
		jb1.addActionListener(new MyListener());
		jb2.addActionListener(new MyListener());
		Font font=new Font("黑体",Font.BOLD,25);
		jf.setBounds(400, 100, 350, 350);
		jf.setLayout(new BorderLayout(70,20));;
		JLabel l1=new JLabel("欢迎使用超市收银系统！",JLabel.CENTER);
		l1.setForeground(Color.BLUE);
		l1.setFont(font);
		JPanel jp4=new JPanel();
		jp4.setLayout(new GridLayout(2,1));
		jp4.add(new JPanel());
		jp4.add(l1);
		JLabel l2=new JLabel("用户名：",JLabel.RIGHT);
		Font font1=new Font("黑体",Font.BOLD,20);
		l2.setFont(font1);
		l2.setForeground(Color.GREEN);
		JLabel l3=new JLabel("密码：",JLabel.RIGHT);
		Font font2=new Font("黑体",Font.BOLD,20);
		l3.setFont(font2);
		l3.setForeground(Color.GREEN);
		
		JPanel jp1=new JPanel();
		jp1.setLayout(new GridLayout(2,2,5,10));
		jp1.add(l2);
		jp1.add(t2);
		jp1.add(l3);
		jp1.add(t3);
		
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		jp3.setLayout(new BorderLayout(50,50));
		jp2.setLayout(new GridLayout(1,1,50,5));
		jb1.setForeground(Color.CYAN);
		//ImageIcon image=new ImageIcon(this.getClass().getClassLoader().getResource("images/login.png"));
		ImageIcon image=new ImageIcon("src/images/login.png");
		image.setImage(image.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT ));
		jf.setIconImage(image.getImage());
		jb1.setIcon(image);
		jp2.add(jb1);
		
		jb2.setForeground(Color.CYAN);
		//ImageIcon image1=new ImageIcon(this.getClass().getClassLoader().getResource("images/exit.png"));
		ImageIcon image1=new ImageIcon("src/images/exit.png");
		image1.setImage(image1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT ));
		jb2.setIcon(image1);
		jp2.add(jb2);
		
		jp3.add(new JPanel(),BorderLayout.SOUTH);
		jp3.add(new JPanel(),BorderLayout.EAST);
		jp3.add(new JPanel(),BorderLayout.WEST);
		jp3.add(new JPanel(),BorderLayout.NORTH);
		jp3.add(jp2);
		jf.add(jp4,BorderLayout.NORTH);
		jf.add(jp3,BorderLayout.SOUTH);
		jf.add(new JPanel(),BorderLayout.EAST);
		jf.add(new JPanel(),BorderLayout.WEST);
		jf.add(jp1);
		jf.setVisible(true);
		return user;
	}

}

