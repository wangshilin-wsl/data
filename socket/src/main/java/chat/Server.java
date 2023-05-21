package chat;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Server{

    public static void main(String args[]){
        Set<String> a1=new HashSet<String>();
        ServerSocket server=null;
        Socket you=null;
        Map<String,ServerThread> peopleList=null;
        peopleList=new HashMap<String, ServerThread>();
        while(true){
            try  {  server=new ServerSocket(4331);
            }
            catch(IOException e1){
                System.out.println("正在监听");
            }
            try  {
                you=server.accept();
                InetAddress address=you.getInetAddress();
                System.out.println("客户的IP:"+address);
            }
            catch (IOException e) {}
            if(you!=null){
                ServerThread peopleThread=new ServerThread(you,peopleList,a1);
                peopleThread.start();
            }
            else  continue;
        }
    }
}
class ServerThread extends Thread{
    Set<String> a=new HashSet<String>();
    String name=null;
    Socket socket=null;
    // File file=null;
    DataOutputStream out=null;
    DataInputStream  in=null;
    Map<String,ServerThread> peopleList=null;
    ServerThread(Socket t, Map<String,ServerThread> list,Set<String> a1){
        peopleList=list;
        socket=t;
        a=a1;
        try {  in=new DataInputStream(socket.getInputStream());
            out=new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException e) {}
    }
    public void run(){
        Connection conn;
        Statement stmt=null;
        ResultSet rs;
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf-8";
        String userName = "root";
        String password = "wangshilin";
        try {
            Class.forName(driverName);
            conn =  DriverManager.getConnection(url, userName, password);
            stmt=conn.createStatement();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Boolean success=false;
        while(true){
            String s,pw=null;
            try{  s=in.readUTF();
                if(s.startsWith("姓名:")){
                    name=s.substring(s.indexOf(":")+1, s.indexOf("#"));
                    pw=s.substring(s.indexOf("#")+1);
                    try {
                        rs=stmt.executeQuery("select * from user where name='"+name+"' and pw='"+pw+"'");
                        boolean boo=peopleList.containsKey(name);
                        if(boo!=false)
                        {out.writeUTF("用户已登录！");
                            System.out.println("用户已登录！");}
                        else if(rs.next()){
                            System.out.println("登陆");
                            success=true;
                            peopleList.put(name,this);
                            Collection<ServerThread> values=peopleList.values();
                            Iterator<ServerThread> chatPersonList=values.iterator();
                            while(chatPersonList.hasNext())
                            {
                                a.add(name);
                                String name1 ="";
                                for (String string: a) {
                                    name1+=":";
                                    name1+=string;

                                    //System.out.println(string);
                                }

                                ((ServerThread)chatPersonList.next()).out.writeUTF ("欢迎"+name+"上线"+name1);


                            }

                        }
                        else{
                            out.writeUTF("用户名或密码不对，请重新登录");
                        }
                    }  catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else if(s.startsWith("注册:")){
                    name=s.substring(s.indexOf(":")+1, s.indexOf("#"));
                    pw=s.substring(s.indexOf("#")+1);
                    try {
                        ResultSet rs1=stmt.executeQuery("select * "+"from user "+"where name= '"+name+"'");
                        if(rs1.next())
                        {
                            out.writeUTF("用户名重复，请重新注册");
                        }
                        else {
                            int result=stmt.executeUpdate("insert into user(name,pw) values('"+name+"' ,'"+pw+"')");
                            if(result>0)
                                success=true;
                            else
                                out.writeUTF("用户名重复，请重新注册");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                }
                else if(s.startsWith("聊天内容")&& success){
                    String message=s.substring(s.indexOf(":")+1);
                    Collection<ServerThread> values=peopleList.values();
                    Iterator<ServerThread> chatPersonList=values.iterator();
                    while(chatPersonList.hasNext()){
                        ((ServerThread)chatPersonList.next()).out.writeUTF (message);
                    }
                }
                else if(s.matches(".+私聊.+")){
                    String message=s;
                    Collection<ServerThread> values=peopleList.values();
                    Iterator<ServerThread> chatPersonList=values.iterator();
                    while(chatPersonList.hasNext()){
                        ((ServerThread)chatPersonList.next()).out.writeUTF (message);

                    }
                }
            }
            catch(IOException ee){
                Collection<ServerThread> values=peopleList.values();
                Iterator<ServerThread> chatPersonList=values.iterator();
                while(chatPersonList.hasNext()){
                    ServerThread  th=(ServerThread)chatPersonList.next();
                    if(th!=this&&th.isAlive())
                    {

                        a.remove(name);
                        String name1="";
                        for (String string : a)
                        {
                            name1+=":";
                            name1+=string;
                        }
                        try {
                            th.out.writeUTF(name+"离开了"+name1);
                        } catch (IOException e) {
                            // TODO 自动生成的 catch 块
                            e.printStackTrace();
                        }

                    }
                }
                peopleList.remove(name);
                try { socket.close();
                }
                catch(IOException eee){}
                System.out.println(name+"离开了");
                break;
            }
        }
    }
}
