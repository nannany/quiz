package quiz.challengeBook.median_poj3579;

import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int medOfM;
    static int[] x;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	while (true) {
	    n = sc.nextInt();
	    m = n * (n - 1) / 2;
	    medOfM = (m + 1) / 2;
	    x = new int[n];

	    for (int i = 0; i < n; i++) {
		x[i] = sc.nextInt();
	    }

	    int lb = 0;
	    int ub = Integer.MAX_VALUE;
	    while (ub - lb > 1) {
		int mid = (ub + lb) / 2;
		if (C(mid)) {
		    lb = mid;
		} else {
		    ub = mid;
		}
	    }
	    System.out.println(lb);
	}

    }

    static boolean C(int k) {
	int count = 0;
	for (int i = 0; i < n - 1; i++) {
	    for (int j = i + 1; j < n; j++) {
		if (Math.abs(x[i] - x[j]) <= k) {
		    count++;
		    if (medOfM < count) {
			return false;
		    }
		}
	    }
	}
	if (count <= medOfM) {
	    return true;
	} else {
	    return false;
	}
    }
}
