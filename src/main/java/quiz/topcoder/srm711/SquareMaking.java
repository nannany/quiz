package quiz.topcoder.srm711;

public class SquareMaking {
    public static int getMinimalPrice(int a, int b, int c, int d) {
	int maxV = Math.max(Math.max(a, b), Math.max(c, d));
	int minV = Math.min(Math.min(a, b), Math.min(c, d));
	int ans = 4000000;
	for (int i = minV; i <= maxV; i++) {
	    int tmp = Math.abs(a - i) + Math.abs(b - i) + Math.abs(c - i) + Math.abs(d - i);

	    if (tmp < ans) {
		ans = tmp;
	    }
	}
	return ans;
    }
}
