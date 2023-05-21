import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame implements ActionListener {
    //组件
    JButton jButton1,jButton2,jButton3 = null;
    JRadioButton jRadioButton1,jRadioButton2,jRadioButton3 ;
    JPanel jPanel1,jPanel2,jPanel3,jPanel4 = null;
    JTextField jTextField = null;
    JLabel jLabel1,jLabel2,jLabel3 = null;
    JPasswordField jPasswordField = null;
    ButtonGroup buttonGroup = null;

    final String s1_name="谢方毅";
    final String s1_pwd = "1";
    final String s1_num="2018050326";
    final String t_name = "张思成";
    final String t_pwd = "1";
    final String t_num= "00001";
    final String m_name="1";
    final String m_pwd="1";
    final String m_num="1";
    public MainUI(){
        //创建组件
        jButton1 = new JButton("登录");
        jButton2 = new JButton("重置");
        jButton3 = new JButton("退出");

        //设置监听器
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);

        jRadioButton1 = new JRadioButton("教师");
        jRadioButton2 = new JRadioButton("学生");
        jRadioButton3 = new JRadioButton("管理员");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);
        //默认选择学生权限
        jRadioButton2.setSelected(true);

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();

        jLabel1 = new JLabel("用户名：");
        jLabel2 = new JLabel("密码：");
        jLabel3 = new JLabel("身份：");

        jTextField = new JTextField(10);
        jPasswordField = new JPasswordField(10);

        jPanel1.add(jLabel1);
        jPanel1.add(jTextField);

        jPanel2.add(jLabel2);
        jPanel2.add(jPasswordField);

        jPanel3.add(jLabel3);
        jPanel3.add(jRadioButton1);
        jPanel3.add(jRadioButton2);
        jPanel3.add(jRadioButton3);

        jPanel4.add(jButton1);
        jPanel4.add(jButton2);
        jPanel4.add(jButton3);

        //加入到JFrame
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);

        this.setLayout(new GridLayout(4,1));
        this.setTitle("管理系统");
        this.setSize(350,250);
        this.setLocation(400,200);
        //当前窗口关闭，保证JVM也退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可见
        this.setVisible(true);
        //生成的窗体能否自由改变大小；
        this.setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //事件判断
        if(e.getActionCommand()=="登录") {
            if (jRadioButton1.isSelected()) {
                teaLogin();
            } else if (jRadioButton2.isSelected()) {
            	//this.dispose();
            	this.setVisible(false);            	
                stuLogin();
            }else if(jRadioButton3.isSelected()) {
            	manlogin();
            }
        }else if(e.getActionCommand()=="重置"){
            clear();
        }
    }

    //学生登录方法
    public void stuLogin(){
        if(s1_name.equals(jTextField.getText())&&s1_pwd.equals(jPasswordField.getText())){
            JOptionPane.showMessageDialog(null,"登录成功","提示消息",JOptionPane.WARNING_MESSAGE);
            this.dispose();
            StdUI ui=new StdUI();  //创建新界面
        }else if(jTextField.getText().isEmpty()&&jPasswordField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jTextField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jPasswordField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
            //清空输入框
            clear();
        }
    }
    //教师登录判断方法
    public void teaLogin()
    {
        if(t_name.equals(jTextField.getText())&&t_pwd.equals(jPasswordField.getText()))
        {

            JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            clear();
            dispose();
            TerUI ui=new TerUI(); //创建一个新界面
        }else if(jTextField.getText().isEmpty()&&jPasswordField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jTextField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jPasswordField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
            clear(); //清空输入框
        }
    }
    //清空文本框和密码框
    public void manlogin(){
        if(m_name.equals(jTextField.getText())&&m_pwd.equals(jPasswordField.getText())){
            JOptionPane.showMessageDialog(null,"登录成功","提示消息",JOptionPane.WARNING_MESSAGE);
            this.dispose();
            //创建新界面
        }else if(jTextField.getText().isEmpty()&&jPasswordField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jTextField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jPasswordField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
            //清空输入框
            clear();
        }
    }
    public void clear(){
        jTextField.setText("");
        jPasswordField.setText("");
    }
    
    public static void main(String[] args)
    {
    	MainUI mainDialog=new MainUI();
    }
}
