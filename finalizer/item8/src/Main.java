import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Room room = new Room(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}