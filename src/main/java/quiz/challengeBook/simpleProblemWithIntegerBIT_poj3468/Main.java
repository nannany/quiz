package quiz.challengeBook.simpleProblemWithIntegerBIT_poj3468;

import java.util.Scanner;

public class Main {
    static int N;
    static int Q;
    static int[] A;
    static String[] T;
    static int[] L;
    static int[] R;
    static int[] X;
    static long[] bit0;
    static long[] bit1;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	A = new int[N + 1];
	bit0 = new long[N + 1];
	bit1 = new long[N + 1];
	Q = sc.nextInt();
	T = new String[Q];
	L = new int[Q];
	R = new int[Q];
	X = new int[Q];

	for (int i = 1; i <= N; i++) {
	    A[i] = sc.nextInt();
	}
	for (int i = 0; i < Q; i++) {
	    T[i] = sc.next();
	    if ("Q".equals(T[i])) {
		L[i] = sc.nextInt();
		R[i] = sc.nextInt();
	    } else {
		L[i] = sc.nextInt();
		R[i] = sc.nextInt();
		X[i] = sc.nextInt();
	    }
	}

	for (int i = 1; i <= N; i++) {
	    add(bit0, i, A[i]);
	}

	for (int i = 0; i < Q; i++) {
	    if (T[i].equals("C")) {
		add(bit0, L[i], -X[i] * (L[i] - 1));
		add(bit1, L[i], X[i]);
		add(bit0, R[i] + 1, X[i] * R[i]);
		add(bit1, R[i] + 1, -X[i]);
	    } else {
		long res = 0;
		res += sum(bit0, R[i]) + sum(bit1, R[i]) * R[i];
		res -= sum(bit0, L[i] - 1) + sum(bit1, L[i] - 1) * (L[i] - 1);
		System.out.println(res);
	    }
	}
	sc.close();
    }

    static long sum(long[] b, int i) {
	long s = 0;
	while (i > 0) {
	    s += b[i];
	    i -= i & -i;
	}
	return s;
    }

    static void add(long[] b, int i, int v) {
	while (i <= N) {
	    b[i] += v;
	    i += i & -i;
	}
    }
}
