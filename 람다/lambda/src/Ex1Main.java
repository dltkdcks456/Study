import java.util.Random;

public class Ex1Main {

    public static void helloDice() {
        long startTime = System.nanoTime();

        int randomValue = new Random().nextInt(6) + 1;
        System.out.println("주사위 놀이: " + randomValue);

        long endTime = System.nanoTime();
        System.out.println("실행 시간: " + (endTime - startTime) + "ns");
    }

    public static void helloSum() {
        long startTime = System.nanoTime();

        for (int i = 0; i <3; i++) {
            System.out.println(i);
        }

        long endTime = System.nanoTime();
        System.out.println("실행 시간: " + (endTime - startTime) + "ns");
    }

    public static void main(String[] args) {

    }
}
