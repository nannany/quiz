package tryAny.effectiveJava;

import static java.util.Comparator.*;

import java.util.Comparator;
import java.util.stream.Stream;

public class CompareTest {
    public static void main(String[] args) {

	Stream<PhoneNum> s = Stream.of(new PhoneNum(111, 222, 333), new PhoneNum(111, 222, 222),
		new PhoneNum(111, 333, 111), new PhoneNum(000, 999, 1));

	s.sorted().forEach(System.out::println);
    }
}

class PhoneNum implements Comparable<PhoneNum> {
    int areaCode;
    int prefix;
    int lineNum;

    public PhoneNum(int areaCode, int prefix, int lineNum) {
	this.areaCode = areaCode;
	this.prefix = prefix;
	this.lineNum = lineNum;
    }

    private static final Comparator<PhoneNum> COMPARATOR = comparingInt((PhoneNum pn) -> pn.areaCode)
	    .thenComparingInt(pn -> pn.prefix).thenComparingInt(pn -> pn.lineNum);

    @Override
    public int compareTo(PhoneNum pn) {
	return COMPARATOR.compare(this, pn);
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("areaCode:").append(areaCode).append(",prefix:").append(prefix).append(",lineNum:").append(lineNum);
	return sb.toString();
    }
}