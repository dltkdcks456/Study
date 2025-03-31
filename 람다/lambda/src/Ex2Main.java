import java.util.Random;

public class Ex2Main {

    public static void hello(Procedure procedure) {
        long startTime = System.nanoTime();

        procedure.run();

        long endTime = System.nanoTime();
        System.out.println("실행 시간: " + (endTime - startTime) + "ns");
    }

    public static void main(String[] args) {
        hello(() -> {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 놀이: " + randomValue);
        });

        hello(() -> {
            for (int i = 0; i <3; i++) {
                System.out.println(i);
            }
        });
    }
}
