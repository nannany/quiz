package quiz.topcoder.srm712;

public class RepeatNumberCompare {
    public static String compare(int x1, int k1, int x2, int k2) {
	String v1 = "";
	for (int i = 0; i < k1; i++) {
	    v1 += x1;
	}
	String v2 = "";
	for (int i = 0; i < k2; i++) {
	    v2 += x2;
	}

	if (Integer.parseInt(v1) < Integer.parseInt(v2)) {
	    return "Less";
	} else if (Integer.parseInt(v1) > Integer.parseInt(v2)) {
	    return "Greater";
	} else {
	    return "Equal";
	}
    }
}
