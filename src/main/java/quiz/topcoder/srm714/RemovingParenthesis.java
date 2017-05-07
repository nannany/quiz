package quiz.topcoder.srm714;

import java.util.LinkedList;
import java.util.Queue;

public class RemovingParenthesis {

    static int sum;
    static Queue<String> que;

    public int countWays(String s) {
	sum = 0;
	que = new LinkedList<String>();

	separate(s);
	// que.stream().forEach(str -> System.out.println("que" + str));
	int ans = 1;
	while (!que.isEmpty()) {
	    solve(que.poll());
	    int tmp = sum;
	    ans *= tmp;
	    sum = 0;
	}
	return ans;
    }

    // static void solve(String s) {
    // if ("()".equals(s.substring(0, 2))) {
    // solve(s.substring(2));
    // }else if("")
    // }

    static void solve(String s) {
	// System.out.println(s);
	if ("".equals(s)) {
	    sum++;
	} else {
	    if ("()".equals(s)) {
		solve("");
	    } else if ("()".equals(s.substring(0, 2))) {
		solve(s.substring(2));
	    } else {
		int parenthesisNum = s.length() / 2;
		for (int i = 1; i <= parenthesisNum; i++) {
		    if (i == parenthesisNum - 1) {
			solve(s.substring(1, s.length() - 1));
		    } else {
			int pos = getPos(s, i);
			solve(s.substring(1, pos) + s.substring(pos + 1));
		    }
		}
	    }
	}
    }

    static void separate(String str) {
	str += " ";
	int frontNum = 0;
	int backNum = 0;
	for (int i = 0; i < str.length(); i++) {
	    if ("(".equals(str.substring(i, i + 1))) {
		frontNum++;
	    } else {
		backNum++;
	    }
	    if (frontNum == backNum) {
		// System.out.println("★★" + str.substring(0, i + 1));
		que.add(str.substring(0, i + 1));
		str = str.substring(i + 1);
		if (str.charAt(0) == ' ') {
		    return;
		} else {
		    separate(str);
		    break;
		}
	    }

	}
    }

    static int getPos(String str, int num) {
	int pos = 0;
	for (int i = 0; i < num; i++) {
	    pos = str.indexOf(")", pos + 1);
	}
	return pos;
    }

}
