package generic_3;

public class GenericTypeLimitMain {

    public static void main(String[] args) {
        GenericTypeLimit<Device> device = new GenericTypeLimit<Device>(new Device("Device"));
        GenericTypeLimit<LightDevice> lightDevice = new GenericTypeLimit<LightDevice>(new LightDevice("LightDevice"));
        GenericTypeLimit<BacnetDevice> BacnetDevice = new GenericTypeLimit<BacnetDevice>(new BacnetDevice("BacnetDevice"));
        // GenericTypeLimit<Object> object = new GenericTypeLimit<Object>(new Object()); 타입 에러 발생
    }
}
