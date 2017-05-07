package quiz.topcoder.srm714;

public class RemovingParenthesis {

    public int countWays(String s) {
	int sum = 0;
	return solve(s, sum);
    }

    static int solve(String s, int sum) {
	int ret = 0;
	if ("".equals(s)) {
	    ret = sum;
	} else {
	    if ("()".equals(s)) {
		sum++;
		return solve("", sum);
	    } else if ("()".equals(s.substring(0, 2))) {
		return solve(s.substring(2), sum);
	    } else {
		int parenthesisNum = s.length() / 2;
		System.out.println(s);
		for (int i = 0; i < parenthesisNum; i++) {
		    int pos = s.indexOf(")", i);
		    if (i == parenthesisNum - 1) {
			System.out.println("★" + i);
			System.out.println("parenthNum" + parenthesisNum);
			sum++;
			ret += solve(s.substring(1, i), sum);
		    } else {
			System.out.println("★★" + i);
			System.out.println("parenthNum" + parenthesisNum);

			sum++;
			ret += solve(s.substring(1, pos) + s.substring(pos + 1), sum);
		    }
		}
	    }
	}
	return ret;
    }
}
