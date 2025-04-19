package hashcodeoverride;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
//        HashSet<Device> set = new HashSet<>();
//        Device device = new Device(1, "1", "1", "1", "dsafsfasdfsadf", "dasfasdfsafzcxvzxvxzcv", "1", "1", "1");
//        set.add(device);
//        System.out.println("✅✅" + device.hashCode());
//
//        SDevice sDevice = new SDevice(1, "adsfsafasdfas", "asdfsadfasdf");
//        System.out.println("✅✅" + sDevice.hashCode());
//        NoneHash noneHash = new NoneHash(1, 2);
//        NoneHash copyHash = new NoneHash(1, 2);
//        HashSet<NoneHash> set = new HashSet<>();
//        set.add(noneHash);
//        set.add(copyHash);
//        System.out.println("hashcode: " + noneHash.hashCode());
//        System.out.println("hashcode: " + copyHash.hashCode());
//        System.out.println("size:" + set.size());
        PhoneNumber phoneNumber = new PhoneNumber((short) 1, (short) 2, (short) 3);
        phoneNumber.hashCode();
    }
}