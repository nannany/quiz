package quiz.challengeBook.faceTheRightWay_poj3276;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] dir;
    static int[] f;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	dir = new int[N];
	for (int i = 0; i < N; i++) {
	    if ("F".equals(sc.next())) {
		dir[i] = 0;
	    } else {
		dir[i] = 1;
	    }
	}
	f = new int[N];

	int K = 1;
	int M = N;
	for (int k = 1; k <= N; k++) {
	    int m = calc(k);
	    if (0 <= m && m < M) {
		M = m;
		K = k;
	    }
	}

	System.out.println(K + " " + M);

	sc.close();
    }

    static int calc(int K) {
	for (int i = 0; i < N; i++) {
	    f[i] = 0;
	}
	int res = 0;
	int sum = 0;
	for (int i = 0; i + K <= N; i++) {
	    if ((dir[i] + sum) % 2 != 0) {
		res++;
		f[i] = 1;
	    }
	    sum += f[i];
	    if (i - K + 1 >= 0) {
		sum -= f[i - K + 1];
	    }
	}

	for (int i = N - K + 1; i < N; i++) {
	    if ((dir[i] + sum) % 2 != 0) {
		return -1;
	    }

	    if (i - K + 1 >= 0) {
		sum -= f[i - K + 1];

	    }
	}
	return res;
    }
}
