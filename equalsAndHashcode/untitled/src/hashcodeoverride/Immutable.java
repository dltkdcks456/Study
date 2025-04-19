package hashcodeoverride;

public class Immutable {

    private final short areaCode, prefix, lineNum;
    private final int hashCode;

    public Immutable(final short areaCode, final short prefix, final short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
        this.hashCode = computeHashCode();
    }

    private int computeHashCode() {
        int result = Short.hashCode(areaCode);
        result = result * 31 + Short.hashCode(prefix);
        result = result * 31 + Short.hashCode(lineNum);
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Immutable immutable = (Immutable) o;
        return areaCode == immutable.areaCode && prefix == immutable.prefix && lineNum == immutable.lineNum;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }
}
