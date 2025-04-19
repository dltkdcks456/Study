package hashcodeoverride;

import java.util.Objects;

public class Device {

    private final int id;
    private final String name;
    private final String networkIp;
    private final String networkIp1;
    private final String networkIp2;
    private final String networkIp3;
    private final String networkIp4;
    private final String networkIp5;
    private final String networkIp6;

    public Device(final int id, final String name, final String networkIp, final String networkIp1, final String networkIp2, final String networkIp3, final String networkIp4, final String networkIp5, final String networkIp6) {
        this.id = id;
        this.name = name;
        this.networkIp = networkIp;
        this.networkIp1 = networkIp1;
        this.networkIp2 = networkIp2;
        this.networkIp3 = networkIp3;
        this.networkIp4 = networkIp4;
        this.networkIp5 = networkIp5;
        this.networkIp6 = networkIp6;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return id == device.id && Objects.equals(name, device.name) && Objects.equals(networkIp, device.networkIp) && Objects.equals(networkIp1, device.networkIp1) && Objects.equals(networkIp2, device.networkIp2) && Objects.equals(networkIp3, device.networkIp3) && Objects.equals(networkIp4, device.networkIp4) && Objects.equals(networkIp5, device.networkIp5) && Objects.equals(networkIp6, device.networkIp6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, networkIp, networkIp1, networkIp2, networkIp3, networkIp4, networkIp5, networkIp6);
    }
}
