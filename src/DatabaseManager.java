import java.sql.*;

public class DatabaseManager {
    private Connection conn;

    public DatabaseManager() {
        try {
            String url = "jdbc:mysql://localhost:3306/student_db";
            String user = "root"; // replace with your MySQL username
            String password = "Ramanath_21"; // replace with your MySQL password
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");
            e.printStackTrace();
        }
    }

    // Close connection
    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add student
    public void addStudent(Student student) {
        String sql = "INSERT INTO Students(name, roll_number) VALUES(?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.name);
            pstmt.setString(2, student.rollNumber);
            pstmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Add course
    public void addCourse(Course course) {
        String sql = "INSERT INTO Courses(name, credits) VALUES(?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, course.name);
            pstmt.setInt(2, course.credits);
            pstmt.executeUpdate();
            System.out.println("Course added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding course: " + e.getMessage());
        }
    }

    // Enroll student in course
    public void enrollStudent(int studentId, int courseId) {
        String sql = "INSERT INTO Enrollments(student_id, course_id) VALUES(?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            pstmt.setInt(2, courseId);
            pstmt.executeUpdate();
            System.out.println("Student enrolled successfully!");
        } catch (SQLException e) {
            System.out.println("Error enrolling student: " + e.getMessage());
        }
    }

    // Assign grade
    public void assignGrade(int enrollmentId, Grade grade) {
        String sql = "INSERT INTO grades (enrollment_id, grade_type, score, max_score) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, enrollmentId);
            pstmt.setString(2, grade.type);
            pstmt.setDouble(3, grade.score);
            pstmt.setDouble(4, grade.maxScore);
            pstmt.executeUpdate();
            System.out.println("Grade assigned successfully!");
        } catch (SQLException e) {
            System.out.println("Error assigning grade: " + e.getMessage());
        }
    }

    // Generate report
    public void generateReport(int studentId) {
        try {
            // Get student
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Students WHERE id = ?");
            ps.setInt(1, studentId);
            ResultSet rsStudent = ps.executeQuery();
            if (!rsStudent.next()) {
                System.out.println("Student not found!");
                return;
            }
            String studentName = rsStudent.getString("name");
            String roll = rsStudent.getString("roll_number");
            System.out.println("\nStudent: " + studentName + " (Roll: " + roll + ")");
            System.out.println("Enrolled Courses:");

            // Get enrollments
            PreparedStatement psEnroll = conn.prepareStatement(
                    "SELECT e.id as enrollment_id, c.name, c.credits " +
                            "FROM Enrollments e JOIN Courses c ON e.course_id = c.id " +
                            "WHERE e.student_id = ?"
            );
            psEnroll.setInt(1, studentId);
            ResultSet rsEnroll = psEnroll.executeQuery();

            while (rsEnroll.next()) {
                int enrollId = rsEnroll.getInt("enrollment_id");
                String courseName = rsEnroll.getString("name");
                int credits = rsEnroll.getInt("credits");
                System.out.println("- " + courseName + " (" + credits + " credits)");

                // Get grades
                PreparedStatement psGrades = conn.prepareStatement(
                "SELECT grade_type, score, max_score FROM Grades WHERE enrollment_id = ?"
                );
                psGrades.setInt(1, enrollId);
                ResultSet rsGrades = psGrades.executeQuery();
                while (rsGrades.next()) {
                    String type = rsGrades.getString("grade_type");
                    double score = rsGrades.getDouble("score");
                    double max = rsGrades.getDouble("max_score");
                    System.out.println("  " + type + ": " + score + " / " + max);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }

    // List all students
    public void listStudents() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, roll_number FROM Students");
        System.out.println("--- Students ---");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " : " + rs.getString("name") + " (Roll: " + rs.getString("roll_number") + ")");
        }
    }

    // List all courses
    public void listCourses() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, credits FROM Courses");
        System.out.println("--- Courses ---");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " : " + rs.getString("name") + " (" + rs.getInt("credits") + " credits)");
        }
    }

    // List all enrollments
    public void listEnrollments() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT e.id, s.name as student, c.name as course " +
                        "FROM Enrollments e " +
                        "JOIN Students s ON e.student_id = s.id " +
                        "JOIN Courses c ON e.course_id = c.id"
        );
        System.out.println("--- Enrollments ---");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " : " + rs.getString("student") + " -> " + rs.getString("course"));
        }
    }
}
