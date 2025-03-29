package generic_5;

import generic_1.GenericBox;
import generic_3.Device;
import generic_3.LightDevice;

public class GenericAndWildcardMethod<K> {
    private K value;

    public <T> void genericMethod(GenericBox<T> box) {
        System.out.println("box = " + box);
    }

    // ? → ? extends Object이다. 모든 타입이 들어갈 수 있다.
    public void wildcardMethod1(GenericBox<?> box) {
        Object value1 = box.getValue();
        System.out.println("value1 = " + value1);
    }

    public <T extends Device> void genericMethodLimit1(GenericBox<T> box) {
        T boxValue = box.getValue();
        System.out.println("boxValue = " + boxValue);
    }

    // 와일드 카드도 동일하게 상한 제한을 둘 수 있다.
    public void wildCardLimit1(GenericBox<? extends Device> box) {
        Device value = box.getValue();
        System.out.println("value = " + value);
    }

    // 타입 인자와 동일한 타입을 반환
    public <T extends Device> T genericMethodLimit2(GenericBox<T> box) {
        T boxValue = box.getValue();
        return boxValue;
    }

    // 타입 추론을 통해 Device로 타입을 받는다.
    public Device wildcardLimit2(GenericBox<? extends Device> box) {
        Device value = box.getValue();
        return value;
    }
}
