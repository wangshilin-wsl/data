import javax.swing.*;


import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.GroupLayout.Alignment;

import java.awt.Font;

import java.awt.GridLayout;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ManUI extends JFrame 
{public ManUI()
{
    intiComponent();
}

//初始化窗体组件
private void intiComponent()
{
    String[] columnNames =
            { "竞赛数目","竞赛名称", "级别", "专业", "注意事项", "发布" }; //设置JTable的列名
    Object[][] obj=new Object[7][7];
    for (int i=0;i<7;i++)
    {
        for(int j=0;j<7;j++)
        {
            switch (j)
            {
                case 0:
                    obj[0][0] = "    1";
                    obj[0][1] = "   大创";
                    obj[0][2] = "    校级";
                    obj[0][3] = "    全部";
                    obj[0][4] = "    无";
                    obj[0][5] = "发布";


                    break;
                    
                case 1:
                    obj[1][0] = "    2";
                    obj[1][1] = "  萌芽杯";
                    obj[1][2] = "    省级";
                    obj[1][3] = "    全部";
                    obj[1][4] = "    无";
                    obj[1][5] = "    发布";

                    break;
                case 2:
                    obj[2][0] = "    3";
                    obj[2][1] = "   erp沙盘模拟";
                    obj[2][2] = "    院级";
                    obj[2][3] = "    会计财管";
                    obj[2][4] = "    无";
                    obj[2][5] = "    发布";

                    break;
                case 3:
                    obj[3][0] = "    4";
                    obj[3][1] = "   服创大赛";
                    obj[3][2] = "    省级";
                    obj[3][3] = "    全部";
                    obj[3][4] = "    无";
                    obj[3][5] = "    发布";

                    break;
                case 4:
                    obj[4][0] = "    5";
                    obj[4][1] = "   数学模拟建模";
                    obj[4][2] = "    校级";
                    obj[4][3] = "    信管";
                    obj[4][4] = "    无";
                    obj[4][5] = "    发布";

                    break;
                case 5:
                    obj[5][0] = "    6";
                    obj[5][1] = "    商业挑战赛";
                    obj[5][2] = "    院级";
                    obj[5][3] = "    经管学院";
                    obj[5][4] = "    无";
                    obj[5][5] = "    发布";
                    break;
                case 6:
                    obj[6][0] = "    7";
                    obj[6][1] = "  英语演讲比赛";
                    obj[6][2] = "    校级";
                    obj[6][3] = "    全部";
                    obj[6][4] = "    无";
                    obj[6][5] = "    发布";
                    break;

            }
        }
    }
    
    JTable table=new JTable(obj, columnNames); //JTable的其中一种构造方法
    TableColumn column=null;     //设置JTable的列默认的宽度和高度
    int colunms = table.getColumnCount();
    
    table.addMouseListener((MouseListener) new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    	
    		int row=table.getSelectedRow();
    		int colum=table.getSelectedColumn();
    		//System.out.println(row+"+"+colum);
    		switch(row) {
    		case 0:
    			System.out.println(row+","+colum);
    			if(colum==5) {
    				//chu fa shi jian
    				JOptionPane.showConfirmDialog(null,
   "确定发布吗？","温馨提示",JOptionPane.YES_NO_CANCEL_OPTION); 						;
    				
    			}
    			break;
    		case 1:
    			System.out.println(row+","+colum);
    			if(colum==5) {
    				//chu fa shi jian
    				JOptionPane.showConfirmDialog(null,
    						   "确定发布吗？","温馨提示",JOptionPane.YES_NO_CANCEL_OPTION);
    			}
    			break;
    		case 2:
    			System.out.println(row+","+colum);
    			if(colum==5) {
    				//chu fa shi jian
    				JOptionPane.showConfirmDialog(null,
    						   "确定发布吗？","温馨提示",JOptionPane.YES_NO_CANCEL_OPTION);
    				
    			
    			}
    			break;
    		case 3:
    			System.out.println(row+","+colum);
    			if(colum==5) {
    				//chu fa shi jian
    				JOptionPane.showConfirmDialog(null,
    						   "确定发布吗？","温馨提示",JOptionPane.YES_NO_CANCEL_OPTION);
    				
    			
    			}
    			break;
    		case 4:
    			System.out.println(row+","+colum);
    			if(colum==5) {
    				//chu fa shi jian
    				JOptionPane.showConfirmDialog(null,
    						   "确定发布吗？","温馨提示",JOptionPane.YES_NO_CANCEL_OPTION);
    				
    			
    			}
    			break;
    		case 5:
    			System.out.println(row+","+colum);
    			if(colum==5) {
    				//chu fa shi jian
    				JOptionPane.showConfirmDialog(null,
    						   "确定发布吗？","温馨提示",JOptionPane.YES_NO_CANCEL_OPTION);
    				
    			
    			}
    			break;
    		case 6:
    			System.out.println(row+","+colum);
    			if(colum==5) {
    				//chu fa shi jian
    				JOptionPane.showConfirmDialog(null,
    						   "确定发布吗？","温馨提示",JOptionPane.YES_NO_CANCEL_OPTION);
    				
    			
    			}
    			break;
    		default:
    			break;
    		}
    		
    	}
    });
    for(int i=0;i<colunms;i++)
    {
        column = table.getColumnModel().getColumn(i);
        column.setPreferredWidth(100);   //将每一列的默认宽度设置为100
    }
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); //设置JTable自动调整列表的状态，此处设置为关闭
    JScrollPane scroll = new JScrollPane(table); //用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看
    scroll.setSize(300, 50);
   
    
    
    add(scroll);

    this.setLocation(450, 200);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
}


}







	