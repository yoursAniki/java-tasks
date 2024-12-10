public final class Storage<T> {
    private final T value;

    public Storage(T value) {
        this.value = value;
    }

    public T getValue(T alternative) {
        return value != null ? value : alternative;
    }
}