import java.util.ArrayList;

public class CourseManager {
    // A list to store all available courses in the curriculum.
    private ArrayList<Course> courses = new ArrayList<>();

    // Adds a new course object to the system's collection.
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Searches for a course by its unique course code and returns it, or null if not found.
    public Course findCourse(String courseCode) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(courseCode)) return c;
        }
        return null; // Return null if the course code does not exist.
    }

    // Filters and returns a list of all courses taught by a specific instructor.
    public ArrayList<Course> getCoursesByInstructor(String instructor) {
        ArrayList<Course> instructorCourses = new ArrayList<>();
        for (Course c : courses) {
            if (c.getInstructor().equalsIgnoreCase(instructor)) instructorCourses.add(c);
        }
        return instructorCourses;
    }

    
    //Identifies courses a student is eligible for (not already enrolled and prerequisites met).
    public ArrayList<Course> getAvailableCourses(String studentId, EnrollmentManager enrollmentManager) {
        ArrayList<Course> available = new ArrayList<>();
        
        // Get the list of courses the student is currently or previously enrolled in.
        ArrayList<Enrollment> currentEnrollments = enrollmentManager.getEnrollmentsByStudent(studentId);

        for (Course course : courses) {
            boolean alreadyEnrolled = false;
            
            // Check if the student is already enrolled in this specific course.
            for (Enrollment e : currentEnrollments) {
                if (e.getCourseCode().equals(course.getCourseCode())) {
                    alreadyEnrolled = true;
                    break;
                }
            }

            // Logic Note: In a full system, you would also check if prerequisites are met here.
            if (!alreadyEnrolled) {
                available.add(course);
            }
        }
        return available;
    }

    // Iterates through the collection and prints the details of every course.
    public void printAllCourses() {
        if (courses.isEmpty()) System.out.println("No courses available in the system.");
        for (Course c : courses) System.out.println(c);
    }

    // Returns the total count of courses currently managed by the system.
    public int getTotalCourses() {
        return courses.size();
    }
}