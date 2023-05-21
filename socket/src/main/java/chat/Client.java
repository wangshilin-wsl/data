package chat;
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
        setTitle("聊天客户端");
        setLayout(new BorderLayout(2,2));
        pNorth=new Panel();
        pSouth=new Panel();
        inputName=new TextField(6);
        inputPw=new TextField(6);
        inputIp=new TextField(12);
        inputContent=new TextField(22);
        send=new Button("发送");
        reg=new Button("注册");
        login=new Button("登录");
        send.setEnabled(false);
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
        pSouth.add(new Label("输入聊天内容:"));
        pSouth.add(inputContent);
        pSouth.add(send);
        send.addActionListener(this);
        login.addActionListener(this);
        reg.addActionListener(this);
        inputName.addActionListener(this);
        inputContent.addActionListener(this);
        add(pNorth,BorderLayout.NORTH);
        add(pSouth,BorderLayout.SOUTH);

        model=new DefaultListModel();
        lineFriend=new JList(model);
        lineFriend.addMouseListener(new MyMouse());
        lineFriend.setBorder(BorderFactory.createTitledBorder("在线好友"));
        lineFriend.setPreferredSize(new Dimension(100,50));
        add(lineFriend,BorderLayout.EAST);

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
            send.setEnabled(true);

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
            try{if(socket==null){
                socket=new Socket(InetAddress.getByName(inputIp.getText()).getHostAddress(), 4331);
                in=new DataInputStream(socket.getInputStream());
                out=new DataOutputStream(socket.getOutputStream());
            }
                out.writeUTF("注册:"+name+"#"+inputPw.getText());
            }
            catch(IOException exp){}
        }else if(e.getSource()==send || e.getSource()==inputContent)
        {  String s=inputContent.getText();
            if(s!=null)
            {  try {
                if(!s.matches(".*@.+"))
                {
                    out.writeUTF("聊天内容:"+name+":"+s);
                }
                else
                {
                    String[] b=s.split(":");
                    String[] b1=b[0].split("@");
                    out.writeUTF(name+":"+"私聊:"+b1[1]+":"+b[1]);
                }
            }
            catch(IOException e1){System.out.println(e1);}
            }
            inputContent.setText("");
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
                    if(s.startsWith("欢迎")||s.matches(".+离开了.+"))
                    {
                        a=s.split(":");
                        model.clear();
                        for(int i=1;i<a.length;i++)
                            model.addElement(a[i]);
                        chatResult.append(a[0]+"\n");
                    }
                    else if(s.matches(".+私聊.+"))
                    {
                        a=s.split(":");
                        if(a[2].equals(name)||a[0].equals(name))
                        {
                            chatResult.append(a[0]+a[1]+":"+a[3]+"\n");
                        }
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


}
