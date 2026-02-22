public class Enrollment {
    // Fields
    private String enrollmentId;
    private String studentId;
    private String courseCode;
    private String grade; 
    private String semester;

    // Constructor
    public Enrollment(String enrollmentId, String studentId, String courseCode, String semester) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.semester = semester;
        this.grade = null; 
    }

    //Getters and Setters 

    public String getEnrollmentId() { 
        return enrollmentId; 
    }
    public void setEnrollmentId(String enrollmentId) { 
        this.enrollmentId = enrollmentId; 
    }

    public String getStudentId() { 
        return studentId; 
    }
    public void setStudentId(String studentId) { 
        this.studentId = studentId; 
    }

    public String getCourseCode() { 
        return courseCode; 
    }
    public void setCourseCode(String courseCode) { 
        this.courseCode = courseCode; 
    }

    public String getGrade() { 
        return grade; 
    }
    public void setGrade(String grade) { 
        this.grade = grade; 
    }

    public String getSemester() { 
        return semester; 
    }
    public void setSemester(String semester) { 
        this.semester = semester; 
    }

    // --- Custom Methods ---

    /// Converts letter grade to grade points (A=4, B=3, C=2, D=1, F=0).
    public double getGradePoints() {
        if (this.grade == null) {
            return 0.0;
        }

        switch (this.grade.toUpperCase()) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
            default:  return 0.0;
        }
    }

    // Determines if the student is passing the course (grade A-D).
    public boolean isPassing() {
        if (this.grade == null) {
            return false;
        }
        String g = this.grade.toUpperCase();
        return g.equals("A") || g.equals("B") || g.equals("C") || g.equals("D");
    }

    @Override
    public String toString() {
        String displayGrade = (grade == null) ? "In Progress" : grade;
        return "Enrollment ID: " + enrollmentId + 
               " | Student: " + studentId + 
               " | Course: " + courseCode + 
               " | Semester: " + semester + 
               " | Grade: " + displayGrade;
    }
}