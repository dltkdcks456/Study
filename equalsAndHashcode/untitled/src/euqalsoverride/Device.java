package euqalsoverride;

public class Device {

    private final int id;
    private final String name;
    private final String networkIp;

    public Device(final int id, final String name, final String networkIp) {
        this.id = id;
        this.name = name;
        this.networkIp = networkIp;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return id == device.id;
    }
}
