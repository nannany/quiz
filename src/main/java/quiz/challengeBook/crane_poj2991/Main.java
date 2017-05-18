package quiz.challengeBook.crane_poj2991;

import java.util.Scanner;

public class Main {
    static int N;
    static int C;
    static int[] L;
    static int[] S;
    static int[] A;
    static double[] vx;
    static double[] vy;
    static double[] ang;
    static double[] prv;
    static int stSize = 1 << 15 - 1;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
	    int N = sc.nextInt();
	    int C = sc.nextInt();
	    L = new int[N];
	    for (int i = 0; i < N; i++) {
		L[i] = sc.nextInt();
	    }
	    S = new int[C];
	    A = new int[C];
	    for (int i = 0; i < C; i++) {
		S[i] = sc.nextInt();
		A[i] = sc.nextInt();
	    }

	    prv = new double[N];
	    vx = new double[stSize];
	    vy = new double[stSize];
	    ang = new double[stSize];
	    init(0, 0, N);
	    for (int i = 1; i < N; i++) {
		prv[i] = Math.PI;
	    }

	    for (int i = 0; i < C; i++) {
		int s = S[i];
		double a = A[i] / 360.0 * 2 * Math.PI;
		change(s, a - prv[s], 0, 0, N);
		prv[s] = a;

		System.out.printf("%.2f %.2f\n", vx[0], vy[0]);
	    }
	}
    }

    /**
     * セグメント木の初期化
     *
     * @param k:接点の番号
     * @param l:
     * @param r:
     */
    static void init(int k, int l, int r) {
	ang[k] = vx[k] = 0.0;

	if (r - l == 1) {
	    vy[k] = L[l];
	} else {
	    int chl = k * 2 + 1;
	    int chr = k * 2 + 2;
	    init(chl, l, (l + r) / 2);
	    init(chr, (l + r) / 2, r);
	    vy[k] = vy[chl] + vy[chr];
	}
    }

    /**
     *
     * @param s:場所
     * @param a:角度の変更
     * @param v:接点番号
     * @param l:
     * @param r:
     */
    static void change(int s, double a, int v, int l, int r) {
	if (s <= l) {
	    return;
	} else if (s < r) {
	    // 左の子ノード
	    int chl = v * 2 + 1;
	    // 右の子ノード
	    int chr = v * 2 + 2;
	    int m = (l + r) / 2;
	    change(s, a, chl, l, m);
	    change(s, a, chr, m, r);
	    if (s <= m) {
		ang[v] += a;
	    }
	    double sin = Math.sin(ang[v]);
	    double cos = Math.cos(ang[v]);

	    vx[v] = vx[chl] + (cos * vx[chr] - sin * vy[chr]);
	    vy[v] = vy[chl] + (sin * vx[chr] + cos * vy[chr]);

	}
    }
}
