import java.util.ArrayList;

public class CourseManager {
    private ArrayList<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

   //addCourse method with validation for null and duplicate course codes
    public void addCourse(Course course) {
        if (course == null) {
            System.out.println("Error: Cannot add a null course.");
            return;
        }
        // Check for duplicate courseCode
        if (findCourse(course.getCourseCode()) != null) {
            System.out.println("Error: Course code " + course.getCourseCode() + " already exists.");
            return;
        }
        courses.add(course);
    }

    //findCourse method to search for a course by its code
    public Course findCourse(String courseCode) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(courseCode)) {
                return c;
            }
        }
        return null;
    }

    //getCoursesByInstructor method to retrieve all courses taught by a specific instructor
    public ArrayList<Course> getCoursesByInstructor(String instructor) {
        ArrayList<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getInstructor().equalsIgnoreCase(instructor)) {
                result.add(c);
            }
        }
        return result;
    }

    //ArrayList<Course> getAvailableCourses method to determine which courses a student can enroll in based on their current enrollments and course prerequisites
    public ArrayList<Course> getAvailableCourses(String studentId, StudentManager studentManager, EnrollmentManager enrollmentManager) {
        ArrayList<Course> available = new ArrayList<>();
        
        // 1. Get student's current enrollments to check for completed/in-progress courses
        ArrayList<Enrollment> studentEnrollments = enrollmentManager.getEnrollmentsByStudent(studentId);
        
        for (Course course : courses) {
            // Check A: Is the student already enrolled in this course?
            boolean alreadyEnrolled = false;
            ArrayList<String> completedCourseCodes = new ArrayList<>();
            
            for (Enrollment e : studentEnrollments) {
                if (e.getCourseCode().equals(course.getCourseCode())) {
                    alreadyEnrolled = true;
                }
                // Track courses where they have a passing grade
                if (e.isPassing()) {
                    completedCourseCodes.add(e.getCourseCode());
                }
            }

            if (alreadyEnrolled) continue;

            // Check B: Are prerequisites met?
            ArrayList<String> prereqs = course.getPrerequisites();
            boolean prereqsMet = true;
            
            for (String prereqCode : prereqs) {
                if (!completedCourseCodes.contains(prereqCode)) {
                    prereqsMet = false;
                    break;
                }
            }

            if (prereqsMet) {
                available.add(course);
            }
        }
        return available;
    }

    //printAllCourses method to display all courses in a formatted table
    public void printAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-10s | %-25s | %-15s | %-3s%n", "Code", "Course Name", "Instructor", "Max");
        System.out.println("----------------------------------------------------------------------");
        for (Course c : courses) {
            System.out.printf("%-10s | %-25s | %-15s | %-3d%n", 
                c.getCourseCode(), c.getCourseName(), c.getInstructor(), c.getMaxEnrollment());
        }
    }

    //getTotalCourses method to return the total number of courses currently registered
    public int getTotalCourses() {
        return courses.size();
    }
}