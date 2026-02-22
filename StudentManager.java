import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    //void addStudent(Student student) - adds student (check for duplicate studentId)
    public void addStudent(Student student) {
        if (student == null) {
            System.out.println("Error: Cannot add a null student.");
            return;
        }
        // boolean removeStudent(String studentId) - removes student by ID
        if (findStudent(student.getStudentId()) != null) {
            System.out.println("Error: Student ID " + student.getStudentId() + " already exists.");
            return;
        }
        students.add(student);
    }

    //boolean removeStudent(String studentId) - removes student by ID
    public boolean removeStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                students.remove(i);
                return true;
            }
        }
        System.out.println("Error: Student with ID " + studentId + " not found.");
        return false;
    }

    //Student findStudent(String studentId) - finds student, returns null if not found
    public Student findStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }

    //ArrayList<Student> getStudentsByMajor(String major) - returns students in major
    public ArrayList<Student> getStudentsByMajor(String major) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                result.add(s);
            }
        }
        return result;
    }

    //ArrayList<Student> getStudentsByYear(int year) - returns students in year
    public ArrayList<Student> getStudentsByYear(int year) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getYear() == year) {
                result.add(s);
            }
        }
        return result;
    }

    //ArrayList<Student> getHonorStudents(double minGpa) - returns students with GPA >= minGpa
    public ArrayList<Student> getHonorStudents(double minGpa) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getGpa() >= minGpa) {
                result.add(s);
            }
        }
        return result;
    }

    //double getAverageGpa() - calculates average GPA of all students
    public double getAverageGpa() {
        if (students.isEmpty()) return 0.0;
        double total = 0;
        for (Student s : students) {
            total += s.getGpa();
        }
        return total / students.size();
    }

    //double getAverageGpaByMajor(String major) - calculates average GPA for major
    public double getAverageGpaByMajor(String major) {
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

    //int getTotalStudents() - returns number of students
    public int getTotalStudents() {
        return students.size();
    }

    //ArrayList<String> getAllMajors() - returns list of all unique majors
    public ArrayList<String> getAllMajors() {
        ArrayList<String> uniqueMajors = new ArrayList<>();
        for (Student s : students) {
            if (!uniqueMajors.contains(s.getMajor())) {
                uniqueMajors.add(s.getMajor());
            }
        }
        return uniqueMajors;
    }

    //void printAllStudents() - prints all students in formatted table
    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("The student list is currently empty.");
            return;
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-15s | %-5s | %-4s%n", 
                          "ID", "Name", "Major", "GPA", "Year");
        System.out.println("-----------------------------------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-10s | %-20s | %-15s | %-5.2f | %-4d%n", 
                              s.getStudentId(), s.getFullName(), s.getMajor(), s.getGpa(), s.getYear());
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
}