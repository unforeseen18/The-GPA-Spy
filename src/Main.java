import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Performance Tracker ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Assign Grade");
            System.out.println("5. Generate Student Report");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent(db, sc);
                    break;
                case 2:
                    addCourse(db, sc);
                    break;
                case 3:
                    enrollStudent(db, sc);
                    break;
                case 4:
                    assignGrade(db, sc);
                    break;
                case 5:
                    generateReport(db, sc);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    db.close();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }

    private static void addStudent(DatabaseManager db, Scanner sc) {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        String roll = sc.nextLine();
        db.addStudent(new Student(0, name, roll));
    }

    private static void addCourse(DatabaseManager db, Scanner sc) {
        System.out.print("Enter Course Name: ");
        String cname = sc.nextLine();
        System.out.print("Enter Credits: ");
        int credits = sc.nextInt();
        sc.nextLine();
        db.addCourse(new Course(0, cname, credits));
    }

    private static void enrollStudent(DatabaseManager db, Scanner sc) {
        try {
            db.listStudents();
            db.listCourses();

            System.out.print("Enter Student ID: ");
            int sid = sc.nextInt();
            System.out.print("Enter Course ID: ");
            int cid = sc.nextInt();
            sc.nextLine();

            db.enrollStudent(sid, cid);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void assignGrade(DatabaseManager db, Scanner sc) {
        try {
            db.listEnrollments();

            System.out.print("Enter Enrollment ID: ");
            int eid = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Grade Type (Exam/Assignment): ");
            String gtype = sc.nextLine();
            System.out.print("Enter Score: ");
            double score = sc.nextDouble();
            System.out.print("Enter Max Score: ");
            double maxScore = sc.nextDouble();
            sc.nextLine();

            db.assignGrade(eid, new Grade(gtype, score, maxScore));
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void generateReport(DatabaseManager db, Scanner sc) {
        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();
        sc.nextLine();
        db.generateReport(sid);
    }
}
