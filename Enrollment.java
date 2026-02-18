public class Enrollment {
    private String enrollmentId;                         
    private String studentId; 
    private String courseCode; 
    private String grade; 
    private String semester; 

    // Constructor to initialize all fields for a new enrollment record.
    public Enrollment(String enrollmentId, String studentId, String courseCode, String grade, String semester) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.grade = grade;
        this.semester = semester;
    }

    // Methods
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

    // Converts the letter grade into a numeric value for GPA calculations.
    public double getGradePoints() {
        if (this.grade == null) return -1.0; 

        return switch (this.grade.toUpperCase()) {
            case "A" -> 4.0;
            case "B" -> 3.0;
            case "C" -> 2.0;
            case "D" -> 1.0;
            case "F" -> 0.0;
            default  -> -1.0;
        };
    }

    // Determines if the student's grade qualifies as a passing mark.
    public boolean isPassing() {
        if (this.grade == null) return false;
        
        String g = this.grade.toUpperCase();
        return g.equals("A") || g.equals("B") || g.equals("C") || g.equals("D");
    }

    // Returns a formatted string representation of the enrollment data.
    @Override
    public String toString() {
        return "Enrollment{" +
                "ID='" + enrollmentId + '\'' +
                ", Student='" + studentId + '\'' +
                ", Course='" + courseCode + '\'' +
                ", Grade='" + (grade == null ? "N/A" : grade) + '\'' +
                ", Semester='" + semester + '\'' +
                '}';
    }
}