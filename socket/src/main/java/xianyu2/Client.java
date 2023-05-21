package xianyu2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends JFrame implements Runnable,ActionListener
{  Button reg,login,send;
    TextField inputName,inputPw,inputIp,inputContent;
    JTextArea chatResult;
    JList lineFriend;
    DefaultListModel model;
    JScrollPane chatResultjs,lineFriendjs;
    JPanel jp;
    String name="";
    Socket socket=null;
    DataInputStream in=null;
    DataOutputStream out=null;

    Client()
    {
        //setLayout(new BorderLayout());

        Panel pNorth,pSouth;
        setTitle("登录界面");
        setLayout(new BorderLayout(2,2));
        pNorth=new Panel();
        pSouth=new Panel();
        inputName=new TextField(6);
        inputPw=new TextField(6);
        inputIp=new TextField(12);
      //  inputContent=new TextField(22);
       // send=new Button("发送");
        reg=new Button("注册");
        login=new Button("登录");
       // send.setEnabled(false);
        chatResult =new JTextArea();
        chatResult.setFont(new Font("宋体",Font.BOLD,20));
        chatResultjs=new JScrollPane(chatResult);
        pNorth.add(new Label("用户名:"));
        pNorth.add(inputName);
        pNorth.add(new Label("密码:"));
        pNorth.add(inputPw);
        pNorth.add(new Label("服务器IP:"));
        pNorth.add(inputIp);
        pNorth.add(login);
        pNorth.add(reg);
        pSouth.add(new Label(":"));
        //pSouth.add(inputContent);
      //  pSouth.add(send);
//        send.addActionListener(this);
        login.addActionListener(this);
        reg.addActionListener(this);
        inputName.addActionListener(this);
       // inputContent.addActionListener(this);
        add(pNorth,BorderLayout.NORTH);
        add(pSouth,BorderLayout.SOUTH);
/*

        model=new DefaultListModel();
        lineFriend=new JList(model);
        lineFriend.addMouseListener(new MyMouse());
        lineFriend.setBorder(BorderFactory.createTitledBorder("在线好友"));
        lineFriend.setPreferredSize(new Dimension(100,50));
        add(lineFriend,BorderLayout.EAST);
*/

        add(chatResultjs);
        jp=new JPanel();
        jp.setLayout(new BorderLayout());
        setBounds(100, 100, 650,300);
        setVisible(true);
        validate();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class MyMouse extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            if(e.getSource()==lineFriend&&e.getClickCount()==2)
            {
                inputContent.setText("@"+((JList)e.getSource()).getSelectedValue().toString()+":");
            }
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            name=inputName.getText();
//            send.setEnabled(true);

            try{if(socket==null){
                socket=new Socket(InetAddress.getByName(inputIp.getText()).getHostAddress(), 4331);
                in=new DataInputStream(socket.getInputStream());
                out=new DataOutputStream(socket.getOutputStream());
            }
                out.writeUTF("姓名:"+name+"#"+inputPw.getText());
            }
            catch(IOException exp){}
        }else  if(e.getSource()==reg){
            name=inputName.getText();
            String password=inputPw.getText();
            if(judgeId(name)&&judgePassword(password)){
                try{if(socket==null){
                    socket=new Socket(InetAddress.getByName(inputIp.getText()).getHostAddress(), 4331);
                    in=new DataInputStream(socket.getInputStream());
                    out=new DataOutputStream(socket.getOutputStream());
                }
                    out.writeUTF("注册:"+name+"#"+inputPw.getText());
                }
                catch(IOException exp){}
            }else{
                JOptionPane.showMessageDialog(null, "用户名或密码格式错误！！！" +
                        "格式为：用户名只能包含数字字母，密码长度必须大于6");
            }
        }
    }
    public void run(){
        String s=null;
        String[] a = null;
        while(true){
            try{
                Thread.sleep(100);
                if(in!=null){

                    s=in.readUTF();
                    if(s.startsWith("欢迎"))
                    {
                        a=s.split(":");
                        chatResult.append(a[0]+"\n");
                    }
                    else
                        chatResult.append(s+"\n");
                }

            }
            catch(IOException e){
                chatResult.setText("和服务器的连接关闭");
                break;
            } catch (InterruptedException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        Client c=new Client();
        new Thread(c).start();

    }
    public static boolean judgeId(String name){
        for(int i=0;i<name.length();i++){
            if((name.charAt(i)>'9'||name.charAt(i)<'0')&&(name.charAt(i)>'z'||name.charAt(i)<'a')&&
                    (name.charAt(i)>'Z'||name.charAt(i)<'A')
            )
                return false;
        }
        return true;
    }
    public static boolean judgePassword(String password){
        if(password.length()>=6)return true;
        else return false;
    }
}
