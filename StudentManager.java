import java.util.ArrayList;

public class StudentManager {

    // Field
    private ArrayList<Student> students;

    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add student (check duplicate ID)
    public void addStudent(Student student) {
        if (student == null) {
            System.out.println("Error: Student cannot be null.");
            return;
        }

        if (findStudent(student.getStudentId()) != null) {
            System.out.println("Error: Student with ID " + student.getStudentId() + " already exists.");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Remove student by ID
    public boolean removeStudent(String studentId) {
        Student student = findStudent(studentId);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }

    // Find student by ID
    public Student findStudent(String studentId) {
        if (studentId == null || students.isEmpty()) {
            return null;
        }

        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(studentId)) {
                return s;
            }
        }

        return null;
    }

    // Get students by major
    public ArrayList<Student> getStudentsByMajor(String major) {
        ArrayList<Student> result = new ArrayList<>();

        if (major == null || students.isEmpty()) {
            return result;
        }

        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                result.add(s);
            }
        }

        return result;
    }

    // Get students by year
    public ArrayList<Student> getStudentsByYear(int year) {
        ArrayList<Student> result = new ArrayList<>();

        if (students.isEmpty()) {
            return result;
        }

        for (Student s : students) {
            if (s.getYear() == year) {
                result.add(s);
            }
        }

        return result;
    }

    // Get honor students (GPA >= minGpa)
    public ArrayList<Student> getHonorStudents(double minGpa) {
        ArrayList<Student> result = new ArrayList<>();

        if (students.isEmpty()) {
            return result;
        }

        for (Student s : students) {
            if (s.getGpa() >= minGpa) {
                result.add(s);
            }
        }

        return result;
    }

    // Get average GPA of all students
    public double getAverageGpa() {
        if (students.isEmpty()) {
            return 0.0;
        }

        double total = 0;

        for (Student s : students) {
            total += s.getGpa();
        }

        return total / students.size();
    }

    // Get average GPA by major
    public double getAverageGpaByMajor(String major) {
        if (major == null || students.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        int count = 0;

        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                total += s.getGpa();
                count++;
            }
        }

        return (count == 0) ? 0.0 : total / count;
    }

    // Print all students in formatted table
    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.printf("%-10s %-15s %-15s %-25s %-5s %-20s %-5s\n",
                "ID", "First Name", "Last Name", "Email", "GPA", "Major", "Year");

        System.out.println("---------------------------------------------------------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-10s %-15s %-15s %-25s %-5.2f %-20s %-5d\n",
                    s.getStudentId(),
                    s.getFirstName(),
                    s.getLastName(),
                    s.getEmail(),
                    s.getGpa(),
                    s.getMajor(),
                    s.getYear());
        }
    }

    // Get total number of students
    public int getTotalStudents() {
        return students.size();
    }

    // Get all unique majors
    public ArrayList<String> getAllMajors() {
        ArrayList<String> majors = new ArrayList<>();

        for (Student s : students) {
            if (!majors.contains(s.getMajor())) {
                majors.add(s.getMajor());
            }
        }

        return majors;
    }
}
