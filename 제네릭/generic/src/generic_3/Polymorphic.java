package generic_3;

public class Polymorphic {
    private Device value;

    public Polymorphic() {
    }

    public Polymorphic(final Device value) {
        this.value = value;
    }

    public Device getValue() {
        return value;
    }

    public void setValue(final Device value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericTypePolymorphic{" +
                "value=" + value +
                '}';
    }
}
