import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private int credits;
    private String instructor;
    private int maxEnrollment;
    private ArrayList<String> prerequisites = new ArrayList<>();

    // Constructor
    public Course(String courseCode, String courseName, int credits, String instructor, int maxEnrollment, ArrayList<String> prerequisites) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.instructor = instructor;
        this.maxEnrollment = maxEnrollment;
        this.prerequisites = new ArrayList<>(prerequisites);
    }

    // Getters and Setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public ArrayList<String> getPrerequisites() {
        return new ArrayList<>(prerequisites);
    }

    public void setPrerequisites(ArrayList<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    // Method to add a prerequisite
    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", instructor='" + instructor + '\'' +
                ", maxEnrollment=" + maxEnrollment +
                ", prerequisites=" + prerequisites +
                '}';
    }

    // void addPrerequisite(String courseCode) - adds prerequisite
    public void addPrerequisite(String courseCode) {
        if (!prerequisites.contains(courseCode)) {
            prerequisites.add(courseCode);
        }
    }

    //boolean hasPrerequisite(String courseCode) - checks if courseCode is a prerequisite
    public boolean hasPrerequisite(String courseCode) {
        return prerequisites.contains(courseCode);
    }

    //ArrayList<String> getPrerequisites() - returns copy of prerequisites list
    public ArrayList<String> getPrerequisitesCopy() {
        return new ArrayList<>(prerequisites);
    }

}
