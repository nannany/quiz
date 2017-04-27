package quiz.topcoder.srm713;

public class PowerEquationEasy {
    public int count(int n) {
	if (n == 1) {
	    return 1;
	}
	long ret = count(n - 1);

	ret += ((n - 1) * 4 + 1);

	int k = 1;
	while (1 < Math.pow(n, 1 / k)) {
	    k++;
	    if (n % k == 0) {
		for (int i = 2; i < Math.pow(n, 1 / k); i++) {
		    ret += 2;
		}
	    }
	}

	return (int) (ret % Math.pow(10, 9) + 7);
    }
}
