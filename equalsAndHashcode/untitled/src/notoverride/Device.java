package notoverride;

public class Device {

    private final int id;
    private final String name;
    private final String networkIp;

    public Device(final int id, final String name, final String networkIp) {
        this.id = id;
        this.name = name;
        this.networkIp = networkIp;
    }
}
