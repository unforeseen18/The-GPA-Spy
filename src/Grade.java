public class Grade {
    public String type; // e.g., Assignment, Exam
    public double score;
    public double maxScore;

    public Grade(String type, double score, double maxScore) {
        this.type = type;
        this.score = score;
        this.maxScore = maxScore;
    }
}
