package xianyu.Function;

import xianyu.database.ConnectDatabase;
import xianyu.database.Message;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends ConnectDatabase {
    //CreateDatabaseAndTable cdt = new CreateDatabaseAndTable();//创建数据库和数据表

    PreparedStatement sql;
    ResultSet rs;
    Message c[] ;
    public Message[] loginMessage(Message message) {
        connectDatabase();   //继承于父类，连接数据库，创建连接对象con，
        try {
            String SQL ="SELECT * FROM message where id=? and password=?";
            sql=con.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            PreparedStatement sta =con.prepareStatement(SQL,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


            //从左向右数第1个通配符的值是word.getID():
            sta.setString(1,message.getID());
            //从左向右数第2个通配符的值是word.getName():
            sta.setString(2,message.getPassword());

            rs=sta.executeQuery();//查询course表
            //控制结果集rs的游标移动到最后一行
            rs.last();
            //获取结果集最后一行的行号
            int rows = rs.getRow();
            //创建rows个课程对象存在在数组c中

            c = new Message[rows];
            for( int i = 0 ;i <rows; i++)
                c[i] = new Message();
            int i = 0 ;
            //控制结果集rs的游标移动到第一行之前
            rs.beforeFirst();
            while(rs.next()) {

                String ID=rs.getString(1);
                String password=rs.getString(2);


                c[i].setID(ID);
                c[i].setPassword( password);


                i++;
            }


            con.close();





        }
        catch(SQLException e) {

            System.out.printf(e.getMessage());
        }
        return c;
    }

}



   

