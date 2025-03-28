package generic_1;

public class ObjectBox {
    private Object value;

    public ObjectBox(final Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(final Object value) {
        this.value = value;
    }
}
