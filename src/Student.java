import java.util.ArrayList;
import java.util.List;

public class Student {
    public int id;
    public String name;
    public String rollNumber;
    public List<Enrollment> enrollments = new ArrayList<>();

    public Student(int id, String name, String rollNumber) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
    }
}
