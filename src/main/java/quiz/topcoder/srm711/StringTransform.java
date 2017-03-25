package quiz.topcoder.srm711;

import java.util.HashSet;
import java.util.Set;

public class StringTransform {
    public static String isPossible(String s, String t) {

	Set<String> hs = new HashSet<String>();
	for (int i = 0; i < s.length(); i++) {
	    hs.add(s.substring(i, i + 1));

	    if (!hs.contains(t.substring(i, i + 1))) {
		return "Impossible";
	    }
	}

	return "Possible";
    }
}
