package generic_3;

public class PolymorphicMain {
    public static void main(String[] args) {
        Polymorphic polymorphic = new Polymorphic();
        polymorphic.setValue(new LightDevice("Light Device"));

        // 타입 안정성이 지켜지지 않는다.
        polymorphic.setValue(new BacnetDevice("Bacnet Device"));
    }
}
