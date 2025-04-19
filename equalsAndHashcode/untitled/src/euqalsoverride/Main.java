package euqalsoverride;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Device device_1 = new Device(1, "Device_name_1", "networkIp1");
        Device device_2 = new Device(1, "Device_name_2", "networkIp2");
        System.out.println("result = " + (device_1.equals(device_2)));

        HashSet<Device> deviceHashSet = new HashSet<>();
        deviceHashSet.add(device_1);
        deviceHashSet.add(device_2);
        System.out.println("deviceHashSet.size() = " + deviceHashSet.size());
    }
}