package dao;

import pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有的学生的信息，以及对应的老师的信息,方法一,子查询
   List<Student> getStudent();
    //查询所有的学生的信息，以及对应的老师的信息,方法二,嵌套查询
    List<Student> getStudent2();
}
