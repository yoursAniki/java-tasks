public class Box<T> {
    private T item;

    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже занята!");
        }
        this.item = item;
    }

    public T take() {
        if (this.item == null) {
            throw new IllegalStateException("Коробка пуста!");
        }
        T temp = this.item;
        this.item = null;
        return temp;
    }

    public boolean isFull() {
        return this.item != null;
    }
}