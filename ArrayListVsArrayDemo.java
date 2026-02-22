import java.util.ArrayList;
import java.util.Random;

public class ArrayListVsArrayDemo {
    public static void main(String[] args) {
        final int TEST_SIZE = 10000;
        final int ACCESS_COUNT = 1000;

        // 1. Demonstration of Limitations and Advantages
        System.out.println("--- Functional Comparison ---");
        
        // Array: Fixed size
        Student[] studentArray = new Student[2];
        studentArray[0] = new Student("S001", "Alice", "Smith", "a@edu.com", 3.8, "CS", 1);
        studentArray[1] = new Student("S002", "Bob", "Jones", "b@edu.com", 3.5, "Math", 2);
        
        System.out.println("Array: Fixed size of " + studentArray.length);

        // ArrayList: Dynamic size
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("S001", "Alice", "Smith", "a@edu.com", 3.8, "CS", 1));
        studentList.add(new Student("S002", "Bob", "Jones", "b@edu.com", 3.5, "Math", 2));
        studentList.add(new Student("S003", "Charlie", "Brown", "c@edu.com", 3.9, "CS", 3));
        
        System.out.println("ArrayList: Dynamically resized to " + studentList.size());
        
        // Removal
        studentList.remove(0); 
        System.out.println("ArrayList after removal: " + studentList.size() + " elements");

        // 2. Performance Measurement 
        System.out.println("\n--- Performance Benchmarking ---");

        // Benchmark ArrayList Addition
        long startAdd = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            studentList.add(new Student("ID" + i, "Test", "User", "test@edu.com", 3.0, "GenEd", 1));
        }
        long endAdd = System.nanoTime();
        double addTime = (endAdd - startAdd) / 1_000_000.0;

        // Benchmark Array Access (requires pre-filling)
        Student[] largeArray = studentList.toArray(new Student[0]);
        Random rand = new Random();
        
        // We use a checksum to "use" the variable s and prevent compiler optimization
        int checksum = 0;

        // Array Access Time
        long startArrayAcc = System.nanoTime();
        for (int i = 0; i < ACCESS_COUNT; i++) {
            Student s = largeArray[rand.nextInt(largeArray.length)];
            checksum += s.hashCode(); 
        }
        long endArrayAcc = System.nanoTime();
        double arrayAccTime = (endArrayAcc - startArrayAcc) / 1_000_000.0;

        // ArrayList Access Time
        long startListAcc = System.nanoTime();
        for (int i = 0; i < ACCESS_COUNT; i++) {
            Student s = studentList.get(rand.nextInt(studentList.size()));
            checksum += s.hashCode(); 
        }
        long endListAcc = System.nanoTime();
        double listAccTime = (endListAcc - startListAcc) / 1_000_000.0;

        // Use checksum at the end so the compiler doesn't skip the loops
        if (checksum == 0) System.out.print(""); 

        // 3. Comparison Report 
        System.out.println("\n--- Comparison Report ---");
        System.out.printf("%-20s | %-15s | %-15s%n", "Feature", "Array", "ArrayList");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-20s | %-15s | %-15s%n", "Resizing", "Manual/Impossible", "Automatic");
        System.out.printf("%-20s | %-15s | %-15s%n", "Add (10k items)", "N/A (Fixed)", String.format("%.4f ms", addTime));
        System.out.printf("%-20s | %-15s | %-15s%n", "Access (1k items)", String.format("%.4f ms", arrayAccTime), String.format("%.4f ms", listAccTime));
        System.out.println("------------------------------------------------------------");
        System.out.println("Note: Access speeds are similar because ArrayList is internally backed by an array.");
    }
}