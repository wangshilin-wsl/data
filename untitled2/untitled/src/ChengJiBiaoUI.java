import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class ChengJiBiaoUI extends JFrame
{

    public ChengJiBiaoUI()
    {
        intiComponent();
    }

    //初始化窗体组件
    private void intiComponent()
    {

        String[] columnNames =
                { "竞赛数目","竞赛名称", "级别", "导师", "奖项", "进行中" }; //设置JTable的列名
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
                        obj[0][3] = "    任继勤";
                        obj[0][4] = "    小组第二";
                        obj[0][5] = "    是";


                        break;
                    case 1:
                        obj[1][0] = "    2";
                        obj[1][1] = "  萌芽杯";
                        obj[1][2] = "    省级";
                        obj[1][3] = "    王莉娟";
                        obj[1][4] = "    省一等奖";
                        obj[1][5] = "    否";

                        break;
                    case 2:
                        obj[2][0] = "    3";
                        obj[2][1] = "   erp沙盘模拟";
                        obj[2][2] = "    院级";
                        obj[2][3] = "    张爱美";
                        obj[2][4] = "    小组第五";
                        obj[2][5] = "    是";

                        break;
                    case 3:
                        obj[3][0] = "    4";
                        obj[3][1] = "   服创大赛";
                        obj[3][2] = "    省级";
                        obj[3][3] = "    辛春林";
                        obj[3][4] = "    省三等奖";
                        obj[3][5] = "    是";

                        break;
                    case 4:
                        obj[4][0] = "    5";
                        obj[4][1] = "   数学模拟建模";
                        obj[4][2] = "    校级";
                        obj[4][3] = "    张思成";
                        obj[4][4] = "    无";
                        obj[4][5] = "    是";

                        break;
                    case 5:
                        obj[5][0] = "    6";
                        obj[5][1] = "    商业挑战赛";
                        obj[5][2] = "    院级";
                        obj[5][3] = "    张鹤达";
                        obj[5][4] = "    院一等奖";
                        obj[5][5] = "    是";
                        break;
                    case 6:
                        obj[6][0] = "    7";
                        obj[6][1] = "  英语演讲比赛";
                        obj[6][2] = "    校级";
                        obj[6][3] = "    黄海燕";
                        obj[6][4] = "    校二等奖";
                        obj[6][5] = "    是";
                        break;

                }
            }
        }

        JTable table=new JTable(obj, columnNames); //JTable的其中一种构造方法
        TableColumn column=null;     //设置JTable的列默认的宽度和高度
        int colunms = table.getColumnCount();
       /** table.addMouseListener((MouseListener) new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {*/
        table.addMouseListener((MouseListener) new MouseAdapter() {
        	  public void mouseClicked(MouseEvent e) {
        	    
        	    		//监视鼠标点击事件第row行
        	    		int row=table.getSelectedRow();
        	    		//连接数据库
        	    		Connection connection=MysqlManager.getConnection();
        	    		MysqlChengJiBiao demol=new MysqlChengJiBiao(connection);
        	    		//查询第row行数据
        	    		
        	    		//获取数据  储存在result
        	    		ChengjiBiaoBean result=new ChengjiBiaoBean();
        	    		result=demol.selectModel();
        	    		
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
        
