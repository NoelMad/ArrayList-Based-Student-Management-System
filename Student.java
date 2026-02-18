public class Student {

    // Fields
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private double gpa;
    private String major;
    private int year;

    // Constructor with all parameters
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

    // Getters and Setters
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

    // Returns full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // equals() compares by studentId
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Student other = (Student) obj;

        return studentId != null && studentId.equals(other.studentId);
    }

    // hashCode() consistent with equals()
    @Override
    public int hashCode() {
        return studentId == null ? 0 : studentId.hashCode();
    }

    // toString() formatted output
    @Override
    public String toString() {
        return "Student ID: " + studentId +
                "\nName: " + getFullName() +
                "\nEmail: " + email +
                "\nMajor: " + major +
                "\nYear: " + year +
                "\nGPA: " + gpa;
    }
}
