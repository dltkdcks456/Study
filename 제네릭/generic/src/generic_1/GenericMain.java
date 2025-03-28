package generic_1;

public class GenericMain {
    public static void main(String[] args) {
        // 타입안정성 O, 재사용성 X
        StringBox stringBox = new StringBox("문자");
        IntegerBox integerBox = new IntegerBox(1);

        // 타입안정성 X, 재사용성 O
        ObjectBox objectStringBox = new ObjectBox("문자");
        ObjectBox objectIntegerBox = new ObjectBox(1);

        // 타입안정성 O, 재사용성 O
        GenericBox<String> stringGenericBox = new GenericBox<String>("문자");
        GenericBox<Integer> integerGenericBox = new GenericBox<Integer>(1);
    }
}
