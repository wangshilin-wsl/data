package selectcourse.pojo;

/**
 * @author
 * @version 1.0.0
 * @ClassName Course.java
 * @Description 课程的实体类
 * @createTime 2021年03月30日 10:04:00
 */
public class Course {
    private Integer id;//课程编号
    private String name;//课程名字
    private String nature;//课程性质，必修，选修。。
    private Integer totalHours;//课程总学时
    private Integer teacherHours;//授课学时
    private Integer experimentHours;//实验学时
    private Integer credit;//学分
    private String term;//开课学期,2021-2

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Integer getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Integer totalHours) {
        this.totalHours = totalHours;
    }

    public Integer getTeacherHours() {
        return teacherHours;
    }

    public void setTeacherHours(Integer teacherHours) {
        this.teacherHours = teacherHours;
    }

    public Integer getExperimentHours() {
        return experimentHours;
    }

    public void setExperimentHours(Integer experimentHours) {
        this.experimentHours = experimentHours;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nature='" + nature + '\'' +
                ", totalHours=" + totalHours +
                ", teacherHours=" + teacherHours +
                ", experimentHours=" + experimentHours +
                ", credit=" + credit +
                ", term='" + term + '\'' +
                '}';
    }

    public Course(Integer id, String name, String nature, Integer totalHours, Integer teacherHours, Integer experimentHours, Integer credit, String term) {
        this.id = id;
        this.name = name;
        this.nature = nature;
        this.totalHours = totalHours;
        this.teacherHours = teacherHours;
        this.experimentHours = experimentHours;
        this.credit = credit;
        this.term = term;
    }
}
