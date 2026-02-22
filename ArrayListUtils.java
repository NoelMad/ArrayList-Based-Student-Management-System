import java.util.ArrayList;

interface MyPredicate<T> {
    boolean test(T t);
}
public class ArrayListUtils {

    //swap method to be used in reverse method
    public static <T> void swap(ArrayList<T> list, int index1, int index2) {
        if (index1 < 0 || index1 >= list.size() || index2 < 0 || index2 >= list.size()) {
            return;
        }
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    //findMax method to find the maximum element in an ArrayList of Comparable types
    public static <T extends Comparable<T>> T findMax(ArrayList<T> list) {
        if (list == null || list.isEmpty()) return null;
        
        T max = list.get(0);
        for (T element : list) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    //filter method to filter elements based on a condition defined by MyPredicate
    public static <T> ArrayList<T> filter(ArrayList<T> list, MyPredicate<T> condition) {
        ArrayList<T> filteredList = new ArrayList<>();
        for (T item : list) {
            if (condition.test(item)) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    //reverse method to reverse the order of elements in an ArrayList
    public static <T> void reverse(ArrayList<T> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            swap(list, left, right);
            left++;
            right--;
        }
    }

    //merge method to combine two ArrayLists into one
    public static <T> ArrayList<T> merge(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> merged = new ArrayList<>(list1);
        merged.addAll(list2);
        return merged;
    }

    //sum method to calculate the sum of elements in an ArrayList of Number types
    public static <T extends Number> double sum(ArrayList<T> numbers) {
        if (numbers == null || numbers.isEmpty()) return 0.0;
        
        double total = 0;
        for (T num : numbers) {
            total += num.doubleValue();
        }
        return total;
    }

    //average method to calculate the average of elements in an ArrayList of Number types
    public static <T extends Number> double average(ArrayList<T> numbers) {
        if (numbers == null || numbers.isEmpty()) return 0.0;
        
        return sum(numbers) / numbers.size();
    }

    //filterAbove method to filter elements greater than a specified threshold in an ArrayList of Number types
    public static <T extends Number & Comparable<T>> ArrayList<T> filterAbove(ArrayList<T> numbers, T threshold) {
        ArrayList<T> result = new ArrayList<>();
        if (numbers == null || threshold == null) return result;

        for (T num : numbers) {
            // compareTo > 0 means num is greater than threshold
            if (num.compareTo(threshold) > 0) {
                result.add(num);
            }
        }
        return result;
    }
    
    //sumNumbers method to calculate the sum of elements in an ArrayList of any type that extends Number
    public static double sumNumbers(ArrayList<? extends Number> numbers) {
        double total = 0.0;
        for (Number n : numbers) {
            total += n.doubleValue();
        }
        return total;
    }

    //addNumbers method to add integers to an ArrayList that can accept Integer or any of its supertypes
    public static void addNumbers(ArrayList<? super Integer> list) {
        // We can safely add Integers because the list is guaranteed 
        // to be at least a list of Integer, Number, or Object.
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    //printList method to print the elements of an ArrayList
    public static void printList(ArrayList<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }



}