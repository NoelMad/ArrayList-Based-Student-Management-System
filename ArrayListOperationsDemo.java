import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListOperationsDemo {
    public static void main(String[] args) {
        // Sample Data
        Student s1 = new Student("S001", "Alice", "Smith", "alice@edu.com", 3.8, "CS", 2);
        Student s2 = new Student("S002", "Bob", "Jones", "bob@edu.com", 3.5, "Math", 3);
        Student s3 = new Student("S003", "Charlie", "Brown", "charlie@edu.com", 3.9, "CS", 2);
        Student s4 = new Student("S004", "Diana", "Prince", "diana@edu.com", 4.0, "Physics", 4);

        // 1. Convert Array to ArrayList
        System.out.println("--- Array to ArrayList ---");
        Student[] studentArray = {s1, s2, s3};
        // Use new ArrayList<>() to ensure the list is mutable (can add/remove)
        ArrayList<Student> studentList = new ArrayList<>(Arrays.asList(studentArray));
        studentList.add(s4); 
        System.out.println("Added Diana. New size: " + studentList.size());

        // 2. ArrayList to Array
        System.out.println("\n--- ArrayList to Array ---");
        Student[] convertedArray = studentList.toArray(new Student[0]);
        System.out.println("Array length: " + convertedArray.length);
        System.out.println("First element in array: " + convertedArray[0].getFullName());

        // 3. SubList Operations
        System.out.println("\n--- SubList Operations ---");
        List<Student> sub = studentList.subList(0, 2); 
        System.out.println("Sublist size: " + sub.size());
        // Modification to sublist affects original
        sub.get(0).setFirstName("ALICE_MODIFIED");
        System.out.println("Original list name after sublist edit: " + studentList.get(0).getFirstName());

        // 4. ArrayList Sorting
        System.out.println("\n--- ArrayList Sorting ---");
        
        // Sort by GPA (Descending)
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return Double.compare(b.getGpa(), a.getGpa());
            }
        });
        System.out.println("Highest GPA first: " + studentList.get(0).getFullName() + " (" + studentList.get(0).getGpa() + ")");

        // Sort by Last Name (Alphabetical)
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return a.getLastName().compareTo(b.getLastName());
            }
        });
        System.out.println("First by Last Name: " + studentList.get(0).getLastName());

        // 5. ArrayList Searching
        System.out.println("\n--- ArrayList Searching ---");
        
        // indexOf and contains rely on the equals() method in the Student class
        System.out.println("Contains s3? " + studentList.contains(s3));
        System.out.println("Index of s3: " + studentList.indexOf(s3));

        // Binary Search (Must sort by the same criteria first)
        // Let's sort by ID first for binary search
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return a.getStudentId().compareTo(b.getStudentId());
            }
        });
        int index = Collections.binarySearch(studentList, s2, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return a.getStudentId().compareTo(b.getStudentId());
            }
        });
        System.out.println("Binary Search Result for S002: Index " + index);
    }
}