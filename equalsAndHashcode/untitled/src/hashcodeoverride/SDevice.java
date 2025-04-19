package hashcodeoverride;

import java.util.Objects;

public class SDevice {

    private final int id;
    private final String name;
    private final String networkIp;

    public SDevice(final int id, final String name, final String networkIp) {
        this.id = id;
        this.name = name;
        this.networkIp = networkIp;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SDevice sDevice = (SDevice) o;
        return id == sDevice.id && Objects.equals(name, sDevice.name) && Objects.equals(networkIp, sDevice.networkIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, networkIp);
    }
}
