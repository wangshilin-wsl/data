package jiedan.job3;

public interface CourseDao {
    void insert(Course course);
    Course findCourseById(String courseId);
}
