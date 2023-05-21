package test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class windowlogin  extends JFrame{
    public JPanel contentPane;
    public JTextField textField;
    public JTextField textField_1;


    public JButton button_2 ;   //注册
    public JButton button;          //登录


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    windowlogin frame = new windowlogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public windowlogin() {
        setTitle("\u767B\u5F55\u5165\u53E3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(151, 51, 180, 24);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(151, 88, 180, 24);
        contentPane.add(textField_1);
        textField_1.setColumns(10);





        button = new JButton("\u767B\u5F55");
        button.setBounds(250, 204, 91, 36);
        contentPane.add(button);

        button_2 = new JButton("\u6CE8\u518C");
        button_2.setBounds(145, 204, 91, 36);
        contentPane.add(button_2);

        JLabel label = new JLabel("\u7528\u6237\u540D");
        label.setBounds(54, 54, 72, 18);
        contentPane.add(label);

        JLabel label_1 = new JLabel("\u5BC6\u7801");
        label_1.setBounds(54, 91, 72, 18);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("\u5982\u5DF2\u6709\u8D26\u53F7\uFF0C\u8BF7\u767B\u5F55");
        label_2.setBounds(161, 128, 157, 18);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("\u5982\u6CA1\u6709\u8D26\u53F7\uFF0C\u8BF7\u6CE8\u518C");
        label_3.setBounds(160, 150, 141, 18);
        contentPane.add(label_3);

        setListener();



    }


    //将事件源与监听器对象绑定
    void setListener(){

        HandleLogin Handlelogin = new HandleLogin(this);
        button.addActionListener(Handlelogin);//修改
    }
}
