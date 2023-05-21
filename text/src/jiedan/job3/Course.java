package jiedan.job3;

public class Course {
    private String courseId;
    private String courseName;
    private int grage;

    public Course() {
    }

    public Course(String courseId, String courseName, int grage) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.grage = grage;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getGrage() {
        return grage;
    }

    public void setGrage(int grage) {
        this.grage = grage;
    }
}
