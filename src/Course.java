import java.util.ArrayList;
import java.util.List;

public class Course {
    public int id;
    public String name;
    public int credits;
    public List<Enrollment> enrollments = new ArrayList<>();

    public Course(int id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }
}
