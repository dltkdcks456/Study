package notoverride;

public class Main {
    public static void main(String[] args) {

        Device device_1 = new Device(1, "Device_name_1", "networkIp1");
        Device device_2 = new Device(1, "Device_name_2", "networkIp2");
        System.out.println("result1 = " + (device_1 == device_2));
        System.out.println("result2 = " + (device_1.equals(device_2)));
    }
}