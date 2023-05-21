package jiedan.job3;

import java.sql.*;

public class CourseDaoImpl implements CourseDao{
    private Connection con;
    {
        try {
            // 1.加载驱动
            String driverName = "com.mysql.jdbc.Driver"; // mysql
            // jdbc驱动描述符,实际上就是driver类在包中的完整路径
            Class.forName(driverName);

            // 2.建立与数据库的连接
            String url = "jdbc:mysql://127.0.0.1:3306/Course?useUnicode=true&characterEncoding=utf-8"; // 数据库连接字符串，一般使用统一资源定位符（url）的形式

            String user = "root"; // 连接数据库时的用户
            String password = "wangshilin"; // 连接数据库时的密码
            con = DriverManager.getConnection(url, user, password);
            //3.创建语句对象
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void insert(Course course) {
        String sql="insert into course(courseId,courseName,grade) values(?,?,?)";
        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1,course.getCourseId());
            prepareStatement.setString(2, course.getCourseName());
            prepareStatement.setInt(3, course.getGrage());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Course findCourseById(String courseId) {
        Course course=new Course();
        ResultSet resultSet ;
        int i=0;
        String sql="select courseId,courseName,grade from course where courseId=?";
        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1,courseId);
            resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                i++;
                course.setCourseId(resultSet.getString(1));
                course.setCourseName(resultSet.getString(2));
                course.setGrage(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       if(i==0)
           return  null;
        return course;
    }
}
