import java.util.ArrayList;
import java.util.List;

public class Enrollment {
    public int id;
    public Student student;
    public Course course;
    public List<Grade> grades = new ArrayList<>();

    public Enrollment(int id, Student student, Course course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }
}
