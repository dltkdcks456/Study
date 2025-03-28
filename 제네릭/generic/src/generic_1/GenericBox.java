package generic_1;

public class GenericBox<T> {
    T value;

    public GenericBox(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }
}
