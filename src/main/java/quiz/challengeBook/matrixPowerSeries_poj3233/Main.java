package quiz.challengeBook.matrixPowerSeries_poj3233;

import java.util.Scanner;

public class Main {
    static int n, k;
    static long[][] A;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();
	A = new long[n][n];
	k = sc.nextInt();
	int m = sc.nextInt();
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		A[i][j] = sc.nextInt();
	    }
	}

	long[][] B = new long[n * 2][n * 2];
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		B[i][j] = A[i][j];
	    }
	    B[n + i][i] = B[n + i][n + i] = 1;
	}

	B = pow(B, k + 1);
	for (int i = 0; i < 2 * n; i++) {
	    for (int j = 0; j < 2 * n; j++) {
		System.out.printf("%d%c", B[i][j], j + 1 == 2 * n ? '\n' : ' ');
	    }
	}
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
		long a = B[n + i][j] % m;
		if (i == j) {
		    a = (a + m - 1) % m;
		}
		System.out.printf("%d%c", a, j + 1 == n ? '\n' : ' ');
	    }
	}
	sc.close();
    }

    static long[][] mul(long[][] a, long[][] b) {
	long[][] ret = new long[a.length][b[0].length];
	for (int i = 0; i < a.length; i++) {
	    for (int k = 0; k < b.length; k++) {
		for (int j = 0; j < b[0].length; j++) {
		    ret[i][j] += a[i][k] * b[k][j];
		}
	    }
	}
	return ret;
    }

    static long[][] pow(long[][] a, long n) {
	long[][] ret = new long[a.length][a.length];
	for (int i = 0; i < a.length; i++) {
	    ret[i][i] = 1;
	}
	while (n > 0) {
	    if ((n & 1) == 1) {
		ret = mul(ret, a);
	    }
	    a = mul(a, a);
	    n >>= 1;
	}
	return ret;
    }

}
