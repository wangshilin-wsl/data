import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class KeChengBiaoUI extends JFrame
{

    public KeChengBiaoUI()
    {
        intiComponent();
    }

    private void intiComponent()
    {
        String[] columnNames =
                { "竞赛名称","小组成员", "", "", "", "", "","指导老师" };

        Object[][] obj=new Object[8][8];
        for (int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                switch (j)
                {
                    case 0:
                        obj[0][0] = "大创";
                        obj[0][1] = "谢方毅";
                        obj[0][2] = "王泽明";
                        obj[0][3] = "何峰";
                        obj[0][4] = "吕林笔";
                        obj[0][5] = "张一帆 ";
                        obj[0][6] = "";
                        obj[0][7] = "任继勤 ";
                        break;
                    case 1:
                        obj[1][0] = "萌芽杯";
                        obj[1][1] = "谢方毅";
                        obj[1][2] = "王泽明";
                        obj[1][3] = "何峰";
                        obj[1][4] = "吕林笔";
                        obj[1][5] = "张一帆";
                        obj[1][6] = "";
                        obj[1][7] = "王莉娟";
                        break;
                    case 2:
                        obj[2][0] = "erp沙盘模拟";
                        obj[2][1] = "谢方毅";
                        obj[2][2] = "臧翠龙 ";
                        obj[2][3] = "胡景文 ";
                        obj[2][4] = "花邵峰";
                        obj[2][5] = "";
                        obj[2][6] = "";
                        obj[2][7] = "张爱美";
                        break;
                    case 3:
                        obj[3][0] = "服创大赛";
                        obj[3][1] = "谢方毅";
                        obj[3][2] = "何峰 ";
                        obj[3][3] = "王泽明 ";
                        obj[3][4] = "吕林笔";
                        obj[3][5] = "";
                        obj[3][6] = "";
                        obj[3][7] = "辛春林";
                        break;
                    case 4:
                        obj[4][0] = "数学模拟建模";
                        obj[4][1] = "谢方毅";
                        obj[4][2] = "何峰 ";
                        obj[4][3] = " 吕林笔";
                        obj[4][4] = " ";
                        obj[4][5] = " ";
                        obj[4][6] = " ";
                        obj[4][7] = "张思成 ";
                        break;
                    case 5:
                        obj[5][0] = "商业挑战赛";
                        obj[5][1] = "谢方毅";
                        obj[5][2] = "何峰 ";
                        obj[5][3] = "吕林笔 ";
                        obj[5][4] = "王泽明 ";
                        obj[5][5] = "张一帆 ";
                        obj[5][6] = " ";
                        obj[5][7] = "张鹤达 ";
                        break;
                    case 6:
                        obj[6][0] = "英语演讲比赛";
                        obj[6][1] = "谢方毅";
                        obj[6][2] = " ";
                        obj[6][3] = " ";
                        obj[6][4] = " ";
                        obj[6][5] = " ";
                        obj[6][6] = " ";
                        obj[6][7] = "黄海燕 ";
                        break;
                    
                }
            }
        }

        JTable table=new JTable(obj, columnNames);
        TableColumn column=null;
        int colunms = table.getColumnCount();
        table.addMouseListener((MouseListener) new MouseAdapter() {
      	  public void mouseClicked(MouseEvent e) {
      	    
      	    		//监视鼠标点击事件第row行
      	    		int row=table.getSelectedRow();
      	    		//连接数据库
      	    		Connection connection=MysqlManager.getConnection();
      	    		MysqlKeChengBiao demol=new MysqlKeChengBiao(connection);
      	    		//查询第row行数据
      	    		//接收数据  储存在result对象中
      	    		KecehngBean result=new KecehngBean();
      	    		result=demol.selectModel();
      	    		//接下来执行数据显示
      	}
      });
        
        for(int i=0;i<colunms;i++)
        {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(100);
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(300, 50);
        
        

        add(scroll);

        this.setLocation(450, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public static void main(String[] args)
    {
        new KeChengBiaoUI();
    }
}
