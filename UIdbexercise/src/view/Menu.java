package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import model.vo.User;


public class Menu {
	static JMenuItem jm3=new JMenuItem("退出");
	static JMenuItem jm2=new JMenuItem("查询");
	static JMenuItem jm1=new JMenuItem("收银");
	class MyListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(e.getSource()==jm1)
			{
				new Add().add();
			}
			if(e.getSource()==jm2)
			{
				new Total().total();
			}
			if(e.getSource()==jm3)
			{
				System.exit(0);
			}
		}
		
	}
	public void menu(User user)
	{
		jm1.addActionListener(new Menu().new MyListener());
		jm2.addActionListener(new Menu().new MyListener());
		jm3.addActionListener(new Menu().new MyListener());
		JFrame jf=new JFrame("超市收银1.0版本--欢迎"+user.getUserName()+"用户");
		jf.setBounds(10, 10, 1000,600);
		JMenuBar a = new JMenuBar();
		JMenu ch=new JMenu("操作(O)");
		Font font=new Font("黑体",Font.BOLD,20);
		ch.setFont(font);
		a.add(ch);
		
		jm1.setFont(font);
		jm1.setForeground(Color.BLUE);
		
		jm2.setFont(font);
		jm2.setForeground(Color.BLUE);
	
		jm3.setFont(font);
		jm3.setForeground(Color.BLUE);
		ImageIcon image1=new ImageIcon(this.getClass().getClassLoader().getResource("images/收银.png"));
		//ImageIcon image1=new ImageIcon("src/images/收银.png");
		image1.setImage(image1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT ));
		jf.setIconImage(image1.getImage());
		jm1.setIcon(image1);
		ImageIcon image2=new ImageIcon(this.getClass().getClassLoader().getResource("images/统计.png"));
		//ImageIcon image2=new ImageIcon("src/images/统计.png");
		image2.setImage(image2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT ));
		jm2.setIcon(image2);
		ImageIcon image3=new ImageIcon(this.getClass().getClassLoader().getResource("images/退出.png"));
		//ImageIcon image3=new ImageIcon("src/images/退出.png");
		image3.setImage(image3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT ));
		jm3.setIcon(image3);
		ch.setMnemonic(KeyEvent.VK_O);
		jm1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		jm2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
		jm3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		ch.add(jm1);
		ch.add(jm2);
		ch.add(jm3);
		jf.add(a,BorderLayout.NORTH);
		jf.setVisible(true);
	}
}
