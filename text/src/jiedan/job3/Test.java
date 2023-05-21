package jiedan.job3;

public class Test {
    public static void main(String[] args) {
        CourseDao courseDao=new CourseDaoImpl();
       // courseDao.insert(new Course("001","张三",100));
        Course course = courseDao.findCourseById("001");
        System.out.println(course.getCourseId()+" "+course.getCourseName()+" "+course.getGrage());
    }
}
