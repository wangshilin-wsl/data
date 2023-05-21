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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.dao.Product;
import model.dao.SaleDetail;
import model.vo.SaleDetil;
import util.GenerateSequence;


public class Add {
	JButton jb1=new JButton("�ύ");
	JButton jb2=new JButton("�ر�");
	JFrame jf=new JFrame("����");
	JTextField jt1=new JTextField(100);
	JTextField jt2=new JTextField(100);
	JTextField jt3=new JTextField(100);
	class MyKeyListener extends KeyAdapter
	{
		public void keyPressed(KeyEvent e) 
		{
			if(e.getSource()==jt1&&e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				jt2.requestFocus();
				jt2.setCaretPosition(0);
			}
			if(e.getSource()==jt2&&e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				jt3.requestFocus();
				jt3.setCaretPosition(0);
			}
			if(e.getSource()==jt3&&e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				GenerateSequence a=new GenerateSequence();
				String id;
				String k=SaleDetail.get();
				if(k!=null)
				{
					id=a.generate(k);
				}
				else 
				{
					k="0000";
					id=a.generate(k);
				}
				String code;
				String product;
				float price;
				int number;
				String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());;
				String person;
				code=jt1.getText();
				number=Integer.valueOf(jt2.getText());
				person=jt3.getText();
				product=Product.lookForName(code);
				price=Product.lookForPrice(code);
				SaleDetil s=new SaleDetil(id,code,product,price,number,person,time);
				Product.update(code, number);
				if(SaleDetail.add(s))
				JOptionPane.showMessageDialog(null, "��ӳɹ�������");
			}
		}
	}
	class MyListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			if(e.getSource()==jb1)
			{
				GenerateSequence a=new GenerateSequence();
				String id;
				String k=SaleDetail.get();
				if(k!=null)
				{
					id=a.generate(k);
				}
				else 
				{
					k="0000";
					id=a.generate(k);
				}
				String code;
				String product;
				float price;
				int number;
				String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());;
				String person;
				code=jt1.getText();
				number=Integer.valueOf(jt2.getText());
				person=jt3.getText();
				product=Product.lookForName(code);
				price=Product.lookForPrice(code);
				SaleDetil s=new SaleDetil(id,code,product,price,number,person,time);
				Product.update(code, number);
				if(SaleDetail.add(s))
				JOptionPane.showMessageDialog(null, "��ӳɹ�������");
				jt1.setText("");
				jt2.setText("");
				jt3.setText("");
			}
			if(e.getSource()==jb2)
			{
				jf.setVisible(false);
			}
		}
	}
	
	public void add()
	{
		jf.setResizable(false);
		Font font=new Font("����",Font.BOLD,25);
		jt1.addKeyListener(new MyKeyListener());
		jt2.addKeyListener(new MyKeyListener());
		jt3.addKeyListener(new MyKeyListener());
		jb1.addActionListener(new MyListener());
		jb2.addActionListener(new MyListener());
		jf.setLayout(new BorderLayout(60,10));
		jf.add(new JPanel(),BorderLayout.EAST);
		jf.add(new JPanel(),BorderLayout.WEST);
		jf.add(new JPanel(),BorderLayout.NORTH);
		jf.setBounds(400, 100, 500, 350);
		
		JPanel jp1=new JPanel();
		jp1.setLayout(new GridLayout(3,2,5,10));
		JLabel jl1=new JLabel("�����룺",JLabel.RIGHT);
		jl1.setFont(font);
		JLabel jl2=new JLabel("������",JLabel.RIGHT);
		jl2.setFont(font);
		JLabel jl3=new JLabel("�ۻ�Ա��",JLabel.RIGHT);
		jl3.setFont(font);

		jp1.add(jl1);
		jp1.add(jt1);
		jp1.add(jl2);
		jp1.add(jt2);
		jp1.add(jl3);
		jp1.add(jt3);
		
		
		
		
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		jp3.setLayout(new BorderLayout(50,50));
		jp2.setLayout(new GridLayout(1,1,50,5));
		jb1.setForeground(Color.CYAN);
		//ImageIcon river = new ImageIcon(this.getClass().getClassLoader().getResource("images/river.gif"));
		ImageIcon image=new ImageIcon(this.getClass().getClassLoader().getResource("images/�ύ.png"));
		//ImageIcon image=new ImageIcon("images/�ύ.png");
		image.setImage(image.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT ));
		jf.setIconImage(image.getImage());
		jb1.setIcon(image);
		
		jb2.setForeground(Color.CYAN);
		ImageIcon image1=new ImageIcon(this.getClass().getClassLoader().getResource("images/�ر�.png"));
		//ImageIcon image1=new ImageIcon("src/images/�ر�.png");
		image1.setImage(image1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT ));
		jb2.setIcon(image1);
		
		
		jp3.add(new JPanel(),BorderLayout.SOUTH);
		jp3.add(new JPanel(),BorderLayout.EAST);
		jp3.add(new JPanel(),BorderLayout.WEST);
		jp3.add(new JPanel(),BorderLayout.NORTH);
		jp3.add(jp2);
		
		jp2.add(jb1);
		jp2.add(jb2);
		
		jf.add(jp1);
		jf.add(jp3,BorderLayout.SOUTH);
		jf.setVisible(true);
	}
}
