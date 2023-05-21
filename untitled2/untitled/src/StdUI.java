import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StdUI extends JFrame implements ActionListener
{


    //定义组件
    JButton jb1=new JButton();
    JButton jb2=new JButton();
    JButton jb3=new JButton();
    JPanel jp1,jp2,jp3,jp4=null;
    JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6=null;

    


    //****************************事件判断**********************

    //构造函数
    public StdUI() //不能申明为void!!!!!否则弹不出新界面
    {

        //创建组件
        jb1=new JButton("报名项目");
        jb1.setForeground(Color.BLUE);
        jb2=new JButton("成绩查询");
        jb2.setForeground(Color.BLUE);
        jb3=new JButton("报名");
        jb3.setForeground(Color.BLUE);

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();

        jlb1=new JLabel("姓名：");
        jlb2=new JLabel("学号：");
        jlb3=new JLabel("最新公告：");
        jlb3.setForeground(Color.red);
        jlb4=new JLabel("erp初赛结果已出");
        
        
        jlb5=new JLabel(new MainUI().s1_name);
        jlb6=new JLabel(new MainUI().s1_num);

        jp1.add(jlb1);
        jp1.add(jlb5);
        jp1.add(jlb2);
        jp1.add(jlb6);


        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);

        jp3.add(jlb3);
        jp3.add(jlb4);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);


        //设置布局管理器
        this.setLayout(new GridLayout(4,3,50,50));
        this.setTitle("学生竞赛管理系统");
        this.setSize(400,300);
        this.setLocation(200, 200);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            //关闭当前界面
            dispose();
            new KeChengBiaoUI();
        }else if(e.getSource() == jb2){
            //关闭当前界面
            dispose();
            new ChengJiBiaoUI();
        }else if(e.getSource() == jb3){
                //关闭当前界面
                dispose();
                new BaoMingBiaoUI();
        }

    }
}

