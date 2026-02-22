public class Pair<K, V> {
    private K first;
    private V second;

    // Constructor
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    // Getters and Setters
    public K getFirst() { return first; }
    public void setFirst(K first) { this.first = first; }

    public V getSecond() { return second; }
    public void setSecond(V second) { this.second = second; }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        // Manual null-safe comparison for 'first'
        if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
        // Manual null-safe comparison for 'second'
        return second != null ? second.equals(pair.second) : pair.second == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}