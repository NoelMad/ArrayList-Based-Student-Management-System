import java.util.ArrayList;

public class Course {
    // Fields
    private String courseCode;
    private String courseName;
    private int credits;
    private String instructor;
    private int maxEnrollment;
    private ArrayList<String> prerequisites;

    // Constructor
    public Course(String courseCode, String courseName, int credits, 
                  String instructor, int maxEnrollment) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.instructor = instructor;
        this.maxEnrollment = maxEnrollment;
        this.prerequisites = new ArrayList<>(); 
    }

    // Getters and Setters for all fields

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

    //Returns a copy of the prerequisites list to prevent external modification of the original list.
    public ArrayList<String> getPrerequisites() {
        return new ArrayList<>(this.prerequisites);
    }

    public void setPrerequisites(ArrayList<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    // Adds a prerequisite course code if it is not already in the list.
    public void addPrerequisite(String courseCode) {
        if (courseCode != null && !this.prerequisites.contains(courseCode)) {
            this.prerequisites.add(courseCode);
        }
    }

    // Checks if a specific courseCode is already a prerequisite.
    public boolean hasPrerequisite(String courseCode) {
        return this.prerequisites.contains(courseCode);
    }

    @Override
    public String toString() {
        return "Course: " + courseCode + " - " + courseName + "\n" +
               "Instructor: " + instructor + " | Credits: " + credits + "\n" +
               "Max Enrollment: " + maxEnrollment + " | Prerequisites: " + prerequisites;
    }
}