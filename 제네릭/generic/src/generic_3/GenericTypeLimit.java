package generic_3;

public class GenericTypeLimit<T extends Device> {
    private T value;

    public GenericTypeLimit(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericTypeLimit{" +
                "value=" + value +
                '}';
    }
}
