import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GenericQueue<T> {
    private ArrayList<T> items;

    public GenericQueue() {
        this.items = new ArrayList<>();
    }

    // Adds an item to the back of the queue
    public void enqueue(T item) {
        if (item != null) {
            items.add(item);
        }
    }

    // Removes and returns the front item
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        // FIFO: Always remove the first element (index 0)
        return items.remove(0);
    }

    // Returns the front item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return items.get(0);
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Returns the number of items in the queue
    public int size() {
        return items.size();
    }
}