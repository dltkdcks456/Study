package generic_4;

import generic_1.GenericBox;
import generic_3.Device;

public class GenericMethod<K> {
    private K value;

    public <T> T genericMethod(GenericBox<T> box) {
        T boxValue = box.getValue();
        return boxValue;
    }

    public static <T> T genericStaticMethod(GenericBox<T> box) {
        T boxValue = box.getValue();
        return boxValue;
    }

    public <T extends Device> T genericMethodLimit(GenericBox<T> box) {
        T boxValue = box.getValue();
        return boxValue;
    }
}
