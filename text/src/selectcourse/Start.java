package selectcourse;

import selectcourse.pojo.Course;
import selectcourse.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author
 * @version 1.0.0
 * @ClassName Start.java
 * @Description TODO
 * @createTime 2021年03月30日 09:26:00
 */
public class Start {
    //获取连接对象
    static Connection conn=JDBCUtils.getConnection();
    static PreparedStatement pst=null;
    static ResultSet rs=null;
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        int op;
        menu();
        System.out.print("请输入您的选项：");
        op=scanner.nextInt();
        while(op!=0){
            switch (op){
                case 1:
                    add();
                    break;
                case 2:
                    listAll();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
            }
            menu();
            System.out.print("请输入您的选项：");
            op=scanner.nextInt();
        }
        JDBCUtils.release(conn,pst,rs);
    }
    public static void menu(){
        System.out.println("*************menu**************");
        System.out.println("*1.课程信息录入 2.所有课程信息*");
        System.out.println("*3.查询课程     4.修改课程    *");
        System.out.println("*5.删除课程     0.退出        *");
        System.out.println("*******************************");
    }
    //向数据库添加记录的函数
    public static void add() throws SQLException {
        Integer id;//课程编号
        String name;//课程名字
        String nature;//课程性质，必修，选修。。
        Integer totalHours;//课程总学时
        Integer teacherHours;//授课学时
        Integer experimentHours;//实验学时
        Integer credit;//学分
        String term;//开课学期,2021-2
        System.out.print("请输入课程名字：");
        name=scanner.next();
        System.out.print("请输入课程性质：");
        nature=scanner.next();
        System.out.print("请输入课程总学时：");
        totalHours=scanner.nextInt();
        System.out.print("请输入课程授课学时：");
        teacherHours=scanner.nextInt();
        System.out.print("请输入课程实验学时：");
        experimentHours=scanner.nextInt();
        System.out.print("请输入课程学分：");
        credit=scanner.nextInt();
        System.out.print("请输入课程开课学期(年-1 or 2)：");
        term=scanner.next();
        Course course=new Course(null,name,nature,totalHours,teacherHours,experimentHours,credit,term);
        String sql="insert into course values(null,?,?,?,?,?,?,?)";
        pst=conn.prepareStatement(sql);
        pst.setString(1, course.getName());
        pst.setString(2, course.getNature());
        pst.setInt(3,course.getTotalHours());
        pst.setInt(4,course.getTeacherHours());
        pst.setInt(5,course.getExperimentHours());
        pst.setInt(6,course.getCredit());
        pst.setString(7, course.getTerm());
        pst.execute();
        System.out.println("添加成功！！！");
    }
    //列出所有课程信息的函数
    public static void listAll() throws SQLException {
        String sql="select * from course";
        pst=conn.prepareStatement(sql);
        rs = pst.executeQuery();
        System.out.println("课程编号 课程名字 课程性质 课程总学时 授课学时 实验学时 学分 开课学期");
        while (rs.next()){
            System.out.println(
                            rs.getInt(1)+
                            "        "+rs.getString(2)+
                            "   "+rs.getString(3)+
                            "     "+rs.getInt(4)+
                            "         "+rs.getInt(5)+
                            "         "+rs.getInt(6)+
                            "        "+rs.getInt(7)+
                            "     "+rs.getString(8));
        }
    }
    //更具课程名字，开课学期，性质来查找
    public static void search() throws SQLException {
        String name;
        System.out.print("请输入要查询课程的名字或者课程的性质或者课程的开课学期：");
        name=scanner.next();
        String sql="select * from course where name like ? or nature like ? or term like ?";
        pst=conn.prepareStatement(sql);
        pst.setString(1,"%"+name+"%");
        pst.setString(2,"%"+name+"%");
        pst.setString(3,"%"+name+"%");
        rs = pst.executeQuery();
        System.out.println("课程编号 课程名字 课程性质 课程总学时 授课学时 实验学时 学分 开课学期");
        while (rs.next()){
            System.out.println(
                    rs.getInt(1)+
                            "        "+rs.getString(2)+
                            "   "+rs.getString(3)+
                            "     "+rs.getInt(4)+
                            "         "+rs.getInt(5)+
                            "         "+rs.getInt(6)+
                            "        "+rs.getInt(7)+
                            "     "+rs.getString(8));
        }

    }
    //根据id来更新课程信息
    public static void update() throws SQLException {
        Integer id;//课程编号
        String name;//课程名字
        String nature;//课程性质，必修，选修。。
        Integer totalHours;//课程总学时
        Integer teacherHours;//授课学时
        Integer experimentHours;//实验学时
        Integer credit;//学分
        String term;//开课学期,2021-2
        System.out.print("请输入需要修改的课程编号：");
        id=scanner.nextInt();
        System.out.print("请输入修改后的课程名字：");
        name=scanner.next();
        System.out.print("请输入修改后的课程性质：");
        nature=scanner.next();
        System.out.print("请输入修改后的课程总学时：");
        totalHours=scanner.nextInt();
        System.out.print("请输入修改后的课程授课学时：");
        teacherHours=scanner.nextInt();
        System.out.print("请输入修改后的课程实验学时：");
        experimentHours=scanner.nextInt();
        System.out.print("请输入修改后的课程学分：");
        credit=scanner.nextInt();
        System.out.print("请输入修改后的课程开课学期(年-1 or 2)：");
        term=scanner.next();
        Course course=new Course(id,name,nature,totalHours,teacherHours,experimentHours,credit,term);
        String sql="update  course " +
                "set name=?,nature=?,totalHours=?,teacherHours=?,experimentHours=?,credit=?,term=?" +
                "where id=?";
        pst=conn.prepareStatement(sql);
        pst.setString(1, course.getName());
        pst.setString(2, course.getNature());
        pst.setInt(3,course.getTotalHours());
        pst.setInt(4,course.getTeacherHours());
        pst.setInt(5,course.getExperimentHours());
        pst.setInt(6,course.getCredit());
        pst.setString(7, course.getTerm());
        pst.setInt(8,course.getId());
        int execute = pst.executeUpdate();
        if(execute>0){
            System.out.println("修改成功！！！");
        }else{
            System.out.println("修改失败！！！");
        }

    }
    //更具id来删除课程信息
    public static void delete() throws SQLException {
        Integer id;
        System.out.print("请输入要删除课程的id：");
        id=scanner.nextInt();
        String sql="delete from course where id=?";
        pst=conn.prepareStatement(sql);
        pst.setInt(1,id);
        int execute = pst.executeUpdate();
        if(execute>0){
            System.out.println("删除成功！！！");
        }else{
            System.out.println("删除失败！！！");
        }
    }
}
