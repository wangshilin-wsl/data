import dao.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Teacher;
import utils.MybatisUtils;

public class MyTest {
    @Test
    public void test2(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teachers=mapper.getTeacher2(1);

            System.out.println(teachers);
        }
}
