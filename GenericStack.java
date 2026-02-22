import java.util.ArrayList;
import java.util.EmptyStackException;


public class GenericStack<T> {
    
    // Field: The internal storage
    private ArrayList<T> stackData;

    //Constructor: Initializes the stack
    public GenericStack() {
        this.stackData = new ArrayList<>();
    }

    //pushes an item onto the top of the stack
    public void push(T item) {
        if (item != null) {
            stackData.add(item);
        }
    }

    /**
     * Pops an item from the top of the stack and returns it.
     * @throws EmptyStackException if the stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // Remove and return the last element in the ArrayList
        return stackData.remove(stackData.size() - 1);
    }

    /**
     * Returns the top item without removing it.
     * @throws EmptyStackException if the stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // Access the last element in the ArrayList
        return stackData.get(stackData.size() - 1);
    }

    /**
     * Checks if the stack is empty.
     */
    public boolean isEmpty() {
        return stackData.isEmpty();
    }

    /**
     * Returns the number of elements in the stack.
     */
    public int size() {
        return stackData.size();
    }

    /**
     * Removes all elements from the stack.
     */
    public void clear() {
        stackData.clear();
    }
}