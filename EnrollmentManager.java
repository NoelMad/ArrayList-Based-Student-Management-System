import java.util.ArrayList;

public class EnrollmentManager {
    // List to store all enrollment records
    private ArrayList<Enrollment> enrollments = new ArrayList<>();
    
    // Counter to generate enrollment IDs in "E001", "E002", ...
    private int enrollmentCounter = 1;

    // Creates a new enrollment
    public void enrollStudent(String studentId, String courseCode, String semester) {
        String enrollmentId = String.format("E%03d", enrollmentCounter++);
        enrollments.add(new Enrollment(enrollmentId, studentId, courseCode, null, semester));
    }

    // Removes an enrollment by ID
    public boolean dropEnrollment(String enrollmentId) {
        return enrollments.removeIf(e -> e.getEnrollmentId().equals(enrollmentId));
    }

    // Finds enrollment by ID
    public Enrollment findEnrollment(String enrollmentId) {
        for (Enrollment e : enrollments) {
            if (e.getEnrollmentId().equals(enrollmentId)) return e;
        }
        return null;
    }

    // Returns all enrollments for a specific student
    public ArrayList<Enrollment> getEnrollmentsByStudent(String studentId) {
        ArrayList<Enrollment> studentList = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId().equals(studentId)) studentList.add(e);
        }
        return studentList;
    }

    // Returns all enrollments for a specific course
    public ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode) {
        ArrayList<Enrollment> courseList = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getCourseCode().equals(courseCode)) courseList.add(e);
        }
        return courseList;
    }

    // Assigns a grade to an enrollment
    public void assignGrade(String enrollmentId, String grade) {
        Enrollment e = findEnrollment(enrollmentId);
        if (e != null && grade.matches("^[ABCDF]$")) {
            e.setGrade(grade.toUpperCase());
        } else {
            System.out.println("Invalid grade or enrollment ID.");
        }
    }

    // Calculates GPA for a student
    public double calculateStudentGpa(String studentId) {
        ArrayList<Enrollment> studentEnrollments = getEnrollmentsByStudent(studentId);
        if (studentEnrollments.isEmpty()) return 0.0;

        double totalPoints = 0;
        int gradedCount = 0;

        for (Enrollment e : studentEnrollments) {
            double points = e.getGradePoints(); // Enrollment method to convert letter to points
            if (points != -1.0) { // skip ungraded
                totalPoints += points;
                gradedCount++;
            }
        }
        return (gradedCount == 0) ? 0.0 : totalPoints / gradedCount;
    }

    // Returns all student IDs in a course
    public ArrayList<String> getStudentsInCourse(String courseCode) {
        ArrayList<String> students = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getCourseCode().equals(courseCode)) students.add(e.getStudentId());
        }
        return students;
    }

    // Returns the total number of students in a course
    public int getEnrollmentCount(String courseCode) {
        return getEnrollmentsByCourse(courseCode).size();
    }

    // Prints all enrollments
    public void printAllEnrollments() {
        if (enrollments.isEmpty()) System.out.println("No enrollments found.");
        for (Enrollment e : enrollments) System.out.println(e);
    }
}
