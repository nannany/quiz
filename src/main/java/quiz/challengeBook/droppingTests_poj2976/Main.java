package quiz.challengeBook.droppingTests_poj2976;

import java.util.Scanner;

public class Main {
    static int n;
    static int k;
    static int[] a;
    static int[] b;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
	    // 全テスト数
	    n = sc.nextInt();
	    // 取り除ける数
	    k = sc.nextInt();
	    if (n == 0 && k == 0) {
		break;
	    }

	    a = new int[n];
	    for (int i = 0; i < n; i++) {
		a[i] = sc.nextInt();
	    }
	    b = new int[n];
	    for (int i = 0; i < n; i++) {
		b[i] = sc.nextInt();
	    }

	    double lb = 0;
	    double ub = 100;

	    for (int i = 0; i < 100; i++) {
		double mid = (lb + ub) / 2;
		if (C(mid)) {
		    // System.out.println("lb" + lb);
		    lb = mid;
		} else {
		    // System.out.println("ub" + ub);
		    ub = mid;
		}
	    }
	    int ans = (int) Math.round(lb);
	    System.out.println(ans);
	}
    }

    static boolean C(double x) {
	double[] tmpList = new double[n];
	for (int i = 0; i < n; i++) {
	    tmpList[i] = a[i] - (x / 100) * b[i];
	}
	// 降順にソート
	for (int j = 0; j < n; j++) {
	    double tmpForSort = tmpList[0];
	    for (int i = 1; i < n; i++) {
		if (tmpList[i] <= tmpForSort) {
		    tmpForSort = tmpList[i];
		} else {
		    tmpList[i - 1] = tmpList[i];
		    tmpList[i] = tmpForSort;
		}
	    }
	}
	// for (int i = 0; i < n; i++) {
	// System.out.println(tmpList[i]);
	// }
	double sum = 0;
	for (int i = 0; i < n - k; i++) {
	    sum += tmpList[i];
	}
	if (0 <= sum) {
	    return true;
	} else {
	    return false;
	}
    }
}
