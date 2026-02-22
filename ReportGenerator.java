import java.util.ArrayList;

/**
 * Handles complex reporting logic for the Student Management System.
 */
public class ReportGenerator {

    /**
     * Prints full details for a specific student, including their enrolled courses.
     */
    public void generateStudentReport(String studentId, GenericList<Student> sm, ArrayList<Pair<Student, Course>> em) {
        Student s = findStudent(studentId, sm);
        if (s == null) {
            System.out.println("Error: Student " + studentId + " not found.");
            return;
        }

        System.out.println("\n--- INDIVIDUAL STUDENT REPORT ---");
        System.out.println("ID: " + s.getStudentId());
        System.out.println("Name: " + s.getFullName());
        System.out.println("GPA: " + s.getGpa());
        System.out.println("Major: " + s.getMajor());
        System.out.println("Enrolled Courses:");
        
        boolean hasCourses = false;
        for (Pair<Student, Course> enrollment : em) {
            if (enrollment.getFirst().getStudentId().equals(studentId)) {
                System.out.println(" - " + enrollment.getSecond().getCourseCode() + ": " + enrollment.getSecond().getCourseName());
                hasCourses = true;
            }
        }
        if (!hasCourses) System.out.println(" - No courses currently enrolled.");
    }

    /**
     * Prints details for a course and lists all students enrolled in it.
     */
    public void generateCourseReport(String courseCode, GenericList<Course> cm, ArrayList<Pair<Student, Course>> em) {
        Course c = null;
        for (int i = 0; i < cm.size(); i++) {
            if (cm.get(i).getCourseCode().equals(courseCode)) {
                c = cm.get(i);
                break;
            }
        }

        if (c == null) {
            System.out.println("Error: Course " + courseCode + " not found.");
            return;
        }

        System.out.println("\n--- COURSE ENROLLMENT REPORT ---");
        System.out.println("Course: " + c.getCourseCode() + " (" + c.getCourseName() + ")");
        System.out.println("Enrolled Students:");
        
        int count = 0;
        for (Pair<Student, Course> enrollment : em) {
            if (enrollment.getSecond().getCourseCode().equals(courseCode)) {
                System.out.println(" - " + enrollment.getFirst().getFullName() + " (ID: " + enrollment.getFirst().getStudentId() + ")");
                count++;
            }
        }
        System.out.println("Total Enrollment: " + count);
    }

    /**
     * Filters students by major and calculates the average GPA for that specific group.
     */
    public void generateMajorReport(String major, GenericList<Student> sm) {
        System.out.println("\n--- MAJOR REPORT: " + major.toUpperCase() + " ---");
        ArrayList<Double> majorGpas = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < sm.size(); i++) {
            Student s = sm.get(i);
            if (s.getMajor().equalsIgnoreCase(major)) {
                System.out.println(" - " + s.getFullName() + " | GPA: " + s.getGpa());
                majorGpas.add(s.getGpa());
                count++;
            }
        }

        if (count > 0) {
            double avg = ArrayListUtils.average(majorGpas);
            System.out.printf("Total Students in Major: %d | Average GPA: %.2f%n", count, avg);
        } else {
            System.out.println("No students found in major: " + major);
        }
    }

    /**
     * Prints students whose GPA is greater than or equal to the minGpa.
     */
    public void generateHonorRollReport(GenericList<Student> sm, double minGpa) {
        System.out.println("\n--- HONOR ROLL REPORT (Min GPA: " + minGpa + ") ---");
        
        // Sorting ensures the report is professional (top students first)
        sm.sort(); 
        
        boolean found = false;
        for (int i = 0; i < sm.size(); i++) {
            Student s = sm.get(i);
            if (s.getGpa() >= minGpa) {
                System.out.println("HONORS: " + s.getFullName() + " [" + s.getGpa() + "] - " + s.getMajor());
                found = true;
            }
        }
        if (!found) System.out.println("No students currently meet the Honor Roll criteria.");
    }

    // Helper to find a student by ID
    private Student findStudent(String id, GenericList<Student> sm) {
        for (int i = 0; i < sm.size(); i++) {
            if (sm.get(i).getStudentId().equals(id)) return sm.get(i);
        }
        return null;
    }
}