package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.dao.SaleDetail;


public class Total {
	JButton jb=new JButton("查询");
	JFrame jf=new JFrame("销售查询统计");
	JTextField jt=new JTextField(180);
	JLabel jl=new JLabel("请选择查询日期：",JLabel.RIGHT);
	JScrollPane sp=new JScrollPane();
	
	class MyMouseListener extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			if(e.getSource()==jt)
			{
				JFrame jf1=new JFrame();
				Point p=new Point(285,120);
				JCalendarChooser jc=new JCalendarChooser(jf1,"选择日期",p);
				Calendar ca=jc.showCalendarDialog();
				jt.setText(new SimpleDateFormat("yyyyMMdd").format(ca.getTime()));
			}
		}
	}
	class MyKeyListener extends KeyAdapter
	{
		public void keyPressed(KeyEvent e) 
		{
			if(e.getSource()==jt&&e.getKeyCode()==KeyEvent.VK_ENTER)
			{
				DefaultTableModel model;
				JTable table;
				jf.remove(sp);
				String today=jt.getText();
				ResultSet all=SaleDetail.getAll(today);
				String[] columeName= {"流水号","条形码","产品名字","产品单价","产品数量","销售时间","销售人"};
				try {
					all.last();
					if(all.getRow()==0)
					{
						model=new DefaultTableModel(columeName,1);
				        table=new JTable(model);
						table.setBackground(Color.CYAN);
						sp=new JScrollPane(table);
						//sp.add(table);
						jf.add(sp);
						jf.validate();
						return ;
					}
					String[][] values= new String[all.getRow()+1][];
					int i=0;
					List<String> list=new ArrayList<String>();
					int number=0;
					float money=0;
					all.first();
					while(true)
					{
						int flag=0;
						for(int j=0;j<list.size();j++)
						{
							
							if(all.getString(2).equals(list.get(j)))
								flag++;
						}
						if(flag==0)
						list.add(all.getString(2));
						number+=all.getInt(5);
						money+=all.getFloat(5)*all.getInt(4);
						values[i++]=new String[] {all.getString(1),all.getString(2),all.getString(3),String.valueOf(all.getFloat(4)),String.valueOf(all.getInt(5)),all.getString(6),all.getString(7)};
						if(!all.next())
							break;
					}
						values[i]= new String[]{"商品总数",String.valueOf(list.size()),"商品总件数",String.valueOf(number),"销售总金额",String.valueOf(money),""};
						model=new DefaultTableModel(values,columeName);
						table=new JTable(model);
						table.setBackground(Color.CYAN);
						sp=new JScrollPane(table);
						//sp.add(table);
						jf.add(sp);
						jf.validate();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					
				//ResultSetTableModel model=new ResultSetTableModel(all);

			}
		}
	}
	
	class MyListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(e.getSource()==jb)
			{
				DefaultTableModel model;
				JTable table;
				jf.remove(sp);
				String today=jt.getText();
				ResultSet all=SaleDetail.getAll(today);
				String[] columeName= {"流水号","条形码","产品名字","产品单价","产品数量","销售时间","销售人"};
				try {
					all.last();
					if(all.getRow()==0)
					{
						model=new DefaultTableModel(columeName,1);
				        table=new JTable(model);
						table.setBackground(Color.CYAN);
						sp=new JScrollPane(table);
						//sp.add(table);
						jf.add(sp);
						jf.validate();
						return ;
					}
					String[][] values= new String[all.getRow()+1][];
					int i=0;
					List<String> list=new ArrayList<String>();
					int number=0;
					float money=0;
					all.first();
					while(true)
					{
						int flag=0;
						for(int j=0;j<list.size();j++)
						{
							
							if(all.getString(2).equals(list.get(j)))
								flag++;
						}
						if(flag==0)
						list.add(all.getString(2));
						number+=all.getInt(5);
						money+=all.getFloat(5)*all.getInt(4);
						values[i++]=new String[] {all.getString(1),all.getString(2),all.getString(3),String.valueOf(all.getFloat(4)),String.valueOf(all.getInt(5)),all.getString(6),all.getString(7)};
						if(!all.next())
							break;
					}
						values[i]= new String[]{"商品总数",String.valueOf(list.size()),"商品总件数",String.valueOf(number),"销售总金额",String.valueOf(money),""};
						model=new DefaultTableModel(values,columeName);
						table=new JTable(model);
						table.setBackground(Color.CYAN);
						sp=new JScrollPane(table);
						//sp.add(table);
						jf.add(sp);
						jf.validate();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					
				//ResultSetTableModel model=new ResultSetTableModel(all);
					
				
			}
			
		}
	}
	
public void total()
{
	jt.addKeyListener(new MyKeyListener());
	jt.addMouseListener(new MyMouseListener());
	ImageIcon image=new ImageIcon(this.getClass().getClassLoader().getResource("images/查找.png"));
	//ImageIcon image=new ImageIcon("src/images/查找.png");
	image.setImage(image.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT ));
	jf.setIconImage(image.getImage());
	jb.setIcon(image);
	jb.addActionListener(new MyListener());
	jf.setBounds(50, 50, 1000,600);
	JPanel jp=new JPanel();
	jp.setLayout(new GridLayout(1,5,10,10));
	
	Font font=new Font("黑体",Font.BOLD,25);
	jl.setFont(font);
	jb.setFont(font);
	jp.add(jl);
	jp.add(jt);
	jp.add(jb);
	jp.add(new JPanel());
	
	jf.add(jp,BorderLayout.NORTH);
	jf.add(new JPanel(),BorderLayout.SOUTH);
	jf.add(new JPanel(),BorderLayout.EAST);
	jf.add(new JPanel(),BorderLayout.WEST);
	jf.setVisible(true);
	
	
	//jt.setText(new SimpleDateFormat("yyyyMMdd").format());
	
	}
}
