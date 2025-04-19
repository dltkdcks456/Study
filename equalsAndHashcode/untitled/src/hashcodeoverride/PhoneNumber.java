package hashcodeoverride;

import java.util.Objects;

public class PhoneNumber {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(final short areaCode, final short prefix, final short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        long startNum = System.nanoTime();
//        int result = Short.hashCode(areaCode);
//        result = result * 31 + Short.hashCode(prefix);
//        result = result * 31 + Short.hashCode(lineNum);
        int result = Objects.hash(areaCode, prefix, lineNum);
        long endNum = System.nanoTime();
        System.out.println("time: " + (endNum - startNum));
        return result;
    }
}
