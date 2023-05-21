import dao.StudentMapper;
import dao.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import utils.MybatisUtils;

import java.util.List;

public class MyTest {
    @Test
    public void test1(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> s = mapper.getStudent2();
        for(Student student:s) {
            System.out.println(student);
        }
    }

    @Test
    public void test2(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        }
}
