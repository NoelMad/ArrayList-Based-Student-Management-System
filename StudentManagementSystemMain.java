import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagementSystemMain {
    // Core data structures
    private static GenericList<Student> students = new GenericList<>();
    private static GenericList<Course> courses = new GenericList<>();
    private static ArrayList<Enrollment> enrollments = new ArrayList<>();
    
    // Tracks grades as (CourseCode, GradeValue)
    private static ArrayList<Pair<String, Double>> grades = new ArrayList<>(); 
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;

        while (choice != 10) {
            displayMenu();
            System.out.print("Select an option: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (1-10).");
                continue;
            }

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> findStudent();
                case 4 -> listStudents();
                case 5 -> addCourse();
                case 6 -> enrollStudent();
                case 7 -> assignGrade();
                case 8 -> calculateGPA();
                case 9 -> generateReports();
                case 10 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- STUDENT MANAGEMENT SYSTEM ---");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Find Student");
        System.out.println("4. List All Students");
        System.out.println("5. Add Course");
        System.out.println("6. Enroll Student in Course");
        System.out.println("7. Assign Grade");
        System.out.println("8. Calculate Student GPA");
        System.out.println("9. Generate Reports");
        System.out.println("10. Exit");
        System.out.println("---------------------------------");
    }

    //1. Add Student 
    private static void addStudent() {
        System.out.print("Enter ID: "); String id = scanner.nextLine();
        System.out.print("First Name: "); String fn = scanner.nextLine();
        System.out.print("Last Name: "); String ln = scanner.nextLine();
        System.out.print("GPA: "); double gpa = Double.parseDouble(scanner.nextLine());
        
        students.add(new Student(id, fn, ln, id + "@edu.com", gpa, "General", 1));
        System.out.println("Student added.");
    }

    //2. Remove Student 
    private static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        String id = scanner.nextLine();
        Student found = findStudentById(id);
        if (found != null) {
            students.remove(found);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    //3. Find Student 
    private static void findStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        Student s = findStudentById(id);
        System.out.println(s != null ? s : "Student not found.");
    }

    //4. List All Students 
    private static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        students.sort(); 
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    // 5. Add Course 
    private static void addCourse() {
        System.out.print("Course Code: ");
        String code = scanner.nextLine();

        System.out.print("Course Name: ");
        String name = scanner.nextLine();

        System.out.print("Credits: ");
        int credits = Integer.parseInt(scanner.nextLine());

        System.out.print("Instructor: ");
        String instructor = scanner.nextLine();

        System.out.print("Max Enrollment: ");
        int maxEnrollment = Integer.parseInt(scanner.nextLine());

        courses.add(new Course(code, name, credits, instructor, maxEnrollment));
        System.out.println("Course registered.");
    }

    // 6. Enroll Student in Course 
        private static void enrollStudent() {
            System.out.print("Student ID: ");
            String sId = scanner.nextLine();

            System.out.print("Course Code: ");
            String cCode = scanner.nextLine();

            System.out.print("Semester: ");
            String semester = scanner.nextLine();

            Student s = findStudentById(sId);
            Course c = findCourseByCode(cCode);

            if (s != null && c != null) {
                String enrollmentId = "E" + (enrollments.size() + 1);
                Enrollment e = new Enrollment(enrollmentId, sId, cCode, semester);
                enrollments.add(e);
                System.out.println("Enrollment successful.");
            } else {
                System.out.println("Error: Check ID and Code.");
            }
        }
    // 7. Assign Grade
    private static void assignGrade() {
        System.out.print("Course Code: "); String code = scanner.nextLine();
        System.out.print("Grade: "); double g = Double.parseDouble(scanner.nextLine());
        grades.add(new Pair<>(code, g));
        System.out.println("Grade assigned.");
    }

    // 8. Calculate Student GPA 
    private static void calculateGPA() {
        // Demonstrate usage of ArrayListUtils with wildcards
        ArrayList<Double> gradeValues = new ArrayList<>();
        for (Pair<String, Double> p : grades) {
            gradeValues.add(p.getSecond());
        }
        
        if (gradeValues.isEmpty()) {
            System.out.println("No grades available to calculate.");
        } else {
            double avg = ArrayListUtils.average(gradeValues);
            System.out.printf("Current Institutional Average GPA: %.2f%n", avg);
        }
    }

    //9. Generate Reports 
    private static void generateReports() {
        System.out.println("\n--- SYSTEM SUMMARY REPORT ---");
        System.out.println("Total Registered Students: " + students.size());
        System.out.println("Total Courses Offered:    " + courses.size());
        System.out.println("Total Active Enrollments: " + enrollments.size());
        
        if (!students.isEmpty()) {
            Student top = students.findMax();
            System.out.println("Highest Ranking Student:  " + top.getFullName() + " (" + top.getGpa() + ")");
        }
    }

    // finders for students and courses
    private static Student findStudentById(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(id)) return students.get(i);
        }
        return null;
    }

    // find course by code
    private static Course findCourseByCode(String code) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseCode().equals(code)) return courses.get(i);
        }
        return null;
    }
}