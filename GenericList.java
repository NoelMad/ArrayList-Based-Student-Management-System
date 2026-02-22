import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericList<T> {
    
    // Field
    private ArrayList<T> items;

    // Constructor
    public GenericList() {
        this.items = new ArrayList<>();
    }

    //add an item to the list
    public void add(T item) {
        if (item != null) items.add(item);
    }

    //get an item by index
    public T get(int index) {
        return (index >= 0 && index < items.size()) ? items.get(index) : null;
    }

    //remove an item from the list
    public boolean remove(T item) {
        return items.remove(item);
    }

    //size of the list
    public int size() {
        return items.size();
    }

    //isEmpty check
    public boolean isEmpty() {
        return items.isEmpty();
    }

    //clear the list
    public void clear() {
        items.clear();
    }

    //contains an item
    public boolean contains(T item) {
        return items.contains(item);
    }

    //get all items as a new list (to prevent external modification)
    public ArrayList<T> getAll() {
        return new ArrayList<>(items);
    }

    //add all items from another list
    public void addAll(ArrayList<T> other) {
        if (other != null) items.addAll(other);
    }

    //addAllForm another GenericList with a compatible type
    public <U extends T> void addAllFrom(GenericList<U> other) {
        if (other != null) {
            this.items.addAll(other.getAll());
        }
    }

    //sort the list if elements are Comparable
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void sort() {
        if (items.size() < 2) return;

        if (items.get(0) instanceof Comparable) {
            // THE FIX: Cast to a raw List before passing to Collections.sort
            // This avoids the "Inconvertible types" error.
            Collections.sort((List) items);
        } else {
            System.out.println("Error: Elements are not Comparable.");
        }
    }

    //find the maximum element if elements are Comparable
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public T findMax() {
        if (items.isEmpty()) return null;

        if (items.get(0) instanceof Comparable) {
            T max = items.get(0);
            for (T item : items) {
                // Cast the item to a Comparable to access compareTo
                if (((Comparable) item).compareTo(max) > 0) {
                    max = item;
                }
            }
            return max;
        }
        return null;
    }
}