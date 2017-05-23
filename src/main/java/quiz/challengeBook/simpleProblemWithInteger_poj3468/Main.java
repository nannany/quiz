package quiz.challengeBook.simpleProblemWithInteger_poj3468;

import java.util.Scanner;

public class Main {
    static int DAT_SIZE = (1 << 18) - 1;
    static int N;
    static int Q;
    static int[] A;
    static String[] T;
    static int[] L;
    static int[] R;
    static int[] X;
    static long[] data = new long[DAT_SIZE];
    static long[] datb = new long[DAT_SIZE];

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	A = new int[N];
	Q = sc.nextInt();
	T = new String[Q];
	L = new int[Q];
	R = new int[Q];
	X = new int[Q];

	for (int i = 0; i < N; i++) {
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

	for (int i = 0; i < N; i++) {
	    add(i, i + 1, A[i], 0, 0, N);
	}
	// Arrays.stream(data).boxed().forEach(l -> System.out.print(l));

	for (int i = 0; i < Q; i++) {
	    if ("C".equals(T[i])) {
		add(L[i] - 1, R[i], X[i], 0, 0, N);
	    } else {
		System.out.println(sum(L[i] - 1, R[i], 0, 0, N));
	    }
	}
	sc.close();
    }

    static void add(int a, int b, int x, int k, int l, int r) {
	if (a <= l && r <= b) {
	    data[k] += x;
	} else if (l < b && a < r) {
	    datb[k] += (Math.min(b, r) - Math.max(a, l)) * x;
	    add(a, b, x, k * 2 + 1, l, (l + r) / 2);
	    add(a, b, x, k * 2 + 2, (l + r) / 2, r);
	}
    }

    static long sum(int a, int b, int k, int l, int r) {
	if (b <= l || r <= a) {
	    return 0;
	} else if (a <= l && r <= b) {
	    return data[k] * (r - l) + datb[k];
	} else {
	    long res = (Math.min(b, r) - Math.max(a, l)) * data[k];
	    res += sum(a, b, k * 2 + 1, l, (l + r) / 2);
	    res += sum(a, b, k * 2 + 2, (l + r) / 2, r);
	    return res;
	}
    }
}
