public class Student implements Comparable<Student> {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private double gpa;
    private String major;
    private int year;

    public Student(String studentId, String firstName, String lastName, 
                   String email, double gpa, String major, int year) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gpa = gpa;
        this.major = major;
        this.year = year;
    }

    // --- Getters and Setters ---

    public String getStudentId() { 
        return studentId; 
    }
    public void setStudentId(String studentId) { 
        this.studentId = studentId; 
    }

    public String getFirstName() { 
        return firstName; 
    }
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }

    public String getEmail() { 
        return email; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }

    public double getGpa() { 
        return gpa; 
    }
    public void setGpa(double gpa) { 
        this.gpa = gpa; 
    }

    public String getMajor() { 
        return major; 
    }
    public void setMajor(String major) { 
        this.major = major; 
    }

    public int getYear() { 
        return year; 
    }
    public void setYear(int year) { 
        this.year = year; 
    }

    /**
     * Returns "firstName lastName"
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + 
               " | Name: " + getFullName() + 
               " | Major: " + major + 
               " | GPA: " + gpa + 
               " | Year: " + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Student other = (Student) obj;
        
        // Manual comparison of studentId to avoid Objects import
        if (this.studentId == null) {
            return other.studentId == null;
        }
        return this.studentId.equals(other.studentId);
    }

    @Override
    public int hashCode() {
        // Simple hash calculation based on studentId
        return (studentId == null) ? 0 : studentId.hashCode();
    }

    // Double.compare returns:
        //  1 if this.gpa > other.gpa
        //  0 if they are equal
        // -1 if this.gpa < other.gpa
    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);
    }
}