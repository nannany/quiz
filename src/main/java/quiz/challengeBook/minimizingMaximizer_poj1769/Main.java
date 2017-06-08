package quiz.challengeBook.minimizingMaximizer_poj1769;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	int s[] = new int[n];
	int t[] = new int[n];

	int dp[] = new int[n + 1];

	for (int i = 0; i < m; i++) {
	    s[i] = sc.nextInt();
	    t[i] = sc.nextInt();
	}

	init(n);
	for (int i = 0; i <= n; i++) {
	    dp[i] = Integer.MAX_VALUE - 10;
	}
	dp[1] = 0;
	update(1, 0);

	for (int i = 0; i < m; i++) {
	    int v = Math.min(dp[t[i]], query(s[i], t[i] + 1, 0, 0, n) + 1);
	    System.out.println(v);
	    dp[t[i]] = v;
	    update(t[i], v);
	}

	Arrays.stream(dp).boxed().forEach(i -> System.out.print(i + " "));

	System.out.println(dp[n]);

	sc.close();
    }

    static int tmpN;
    static int[] dat = new int[1 << 20 - 1];

    static void init(int n) {
	tmpN = 1;
	while (tmpN < n) {
	    tmpN *= 2;
	}
	for (int i = 0; i < 2 * tmpN - 1; i++) {
	    dat[i] = Integer.MAX_VALUE - 10;
	}
    }

    static void update(int k, int a) {
	k += tmpN - 1;
	dat[k] = a;
	while (0 < k) {
	    k = (k - 1) / 2;
	    dat[k] = Math.min(dat[k * 2 + 1], dat[k * 2 + 2]);
	}
    }

    static int query(int a, int b, int k, int l, int r) {
	if (r <= a || b <= l) {
	    return Integer.MAX_VALUE;
	}
	if (a <= l && r <= b) {
	    return dat[k];
	} else {
	    int vl = query(a, b, k * 2 + 1, l, (l + r) / 2);
	    int vr = query(a, b, k * 2 + 2, (l + r) / 2, r);
	    return Math.min(vl, vr);
	}
    }
}
