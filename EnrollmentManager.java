import java.util.ArrayList;

public class EnrollmentManager {
    private ArrayList<Enrollment> enrollments;

    public EnrollmentManager() {
        this.enrollments = new ArrayList<>();
    }

    // void enrollStudent(String studentId, String courseCode, String semester) - creates enrollment
    public void enrollStudent(String studentId, String courseCode, String semester, Course course) {
        // Requirement: Check if course is at capacity
        if (getEnrollmentCount(courseCode) >= course.getMaxEnrollment()) {
            System.out.println("Error: Course " + courseCode + " is at maximum capacity.");
            return;
        }

        // Generate a simple unique ID (e.g., E1, E2...)
        String enrollmentId = "E" + (enrollments.size() + 1);
        Enrollment newEnrollment = new Enrollment(enrollmentId, studentId, courseCode, semester);
        enrollments.add(newEnrollment);
    }

    //boolean dropEnrollment(String enrollmentId) - removes enrollment
    public boolean dropEnrollment(String enrollmentId) {
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getEnrollmentId().equals(enrollmentId)) {
                enrollments.remove(i);
                return true;
            }
        }
        return false;
    }

    //Enrollment findEnrollment(String enrollmentId) - finds enrollment by ID
    public Enrollment findEnrollment(String enrollmentId) {
        for (Enrollment e : enrollments) {
            if (e.getEnrollmentId().equals(enrollmentId)) {
                return e;
            }
        }
        return null;
    }

    //void assignGrade(String enrollmentId, String grade) - assigns grade to enrollment
    public void assignGrade(String enrollmentId, String grade) {
        Enrollment e = findEnrollment(enrollmentId);
        if (e != null) {
            // Requirement: Validate grades
            String g = grade.toUpperCase();
            if (g.equals("A") || g.equals("B") || g.equals("C") || g.equals("D") || g.equals("F")) {
                e.setGrade(g);
            } else {
                System.out.println("Error: Invalid grade '" + grade + "'. Use A, B, C, D, or F.");
            }
        }
    }

    //double calculateStudentGpa(String studentId) - calculates GPA from enrollments
    public double calculateStudentGpa(String studentId) {
        ArrayList<Enrollment> studentClasses = getEnrollmentsByStudent(studentId);
        if (studentClasses.isEmpty()) {
            return 0.0;
        }

        double totalPoints = 0;
        int gradedCount = 0;

        for (Enrollment e : studentClasses) {
            // Only calculate if a grade has been assigned
            if (e.getGrade() != null) {
                totalPoints += e.getGradePoints();
                gradedCount++;
            }
        }

        return (gradedCount == 0) ? 0.0 : totalPoints / gradedCount;
    }

    // ArrayList<Enrollment> getEnrollmentsByStudent(String studentId) - returns enrollments for a student
    public ArrayList<Enrollment> getEnrollmentsByStudent(String studentId) {
        ArrayList<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId().equals(studentId)) {
                result.add(e);
            }
        }
        return result;
    }

    // ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode) - returns enrollments for a course
    public ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode) {
        ArrayList<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getCourseCode().equals(courseCode)) {
                result.add(e);
            }
        }
        return result;
    }

    // ArrayList<String> getStudentsInCourse(String courseCode) - returns student IDs in a course
    public ArrayList<String> getStudentsInCourse(String courseCode) {
        ArrayList<String> studentIds = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getCourseCode().equals(courseCode)) {
                studentIds.add(e.getStudentId());
            }
        }
        return studentIds;
    }

    // int getEnrollmentCount(String courseCode) - returns number of enrollments in a course
    public int getEnrollmentCount(String courseCode) {
        int count = 0;
        for (Enrollment e : enrollments) {
            if (e.getCourseCode().equals(courseCode)) {
                count++;
            }
        }
        return count;
    }

    // void printAllEnrollments() - prints all enrollments
    public void printAllEnrollments() {
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }
        for (Enrollment e : enrollments) {
            System.out.println(e.toString());
        }
    }
}