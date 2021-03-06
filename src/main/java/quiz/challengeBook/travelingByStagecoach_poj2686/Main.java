package quiz.challengeBook.travelingByStagecoach_poj2686;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int p;
    static int a;
    static int b;
    static int[] t;
    static int[][] d;
    static double[][] dp;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
	    N = sc.nextInt();
	    M = sc.nextInt();
	    p = sc.nextInt();
	    a = sc.nextInt();
	    b = sc.nextInt();
	    if (N == 0 && M == 0) {
		break;
	    }

	    dp = new double[1 << N][M];
	    t = new int[N];
	    for (int i = 0; i < N; i++) {
		t[i] = sc.nextInt();
	    }

	    d = new int[M][M];
	    for (int i = 0; i < M; i++) {
		Arrays.fill(d[i], -1);
	    }
	    for (int i = 0; i < p; i++) {
		int pos1 = sc.nextInt() - 1;
		int pos2 = sc.nextInt() - 1;
		int dis = sc.nextInt();
		d[pos1][pos2] = dis;
		d[pos2][pos1] = dis;
	    }

	    for (int i = 0; i < 1 << N; i++) {
		Arrays.fill(dp[i], Integer.MAX_VALUE);
	    }
	    dp[(1 << N) - 1][a - 1] = 0;
	    double res = Integer.MAX_VALUE;

	    for (int S = (1 << N) - 1; S >= 0; S--) {
		res = Math.min(res, dp[S][b - 1]);
		for (int v = 0; v < M; v++) {
		    for (int i = 0; i < N; i++) {
			if ((S >> i & 1) == 1) {
			    for (int u = 0; u < M; u++) {
				if (d[v][u] >= 0) {
				    dp[S & ~(1 << i)][u] = Math.min(dp[S & ~(1 << i)][u],
					    dp[S][v] + (double) d[v][u] / t[i]);
				}
			    }
			}
		    }
		}
	    }
//	    for (int i = 0; i < 1 << N; i++) {
//		for (int j = 0; j < M; j++) {
//		    System.out.printf("%f%c", dp[i][j], j == M - 1 ? '\n' : ' ');
//		}
//	    }
//	    for (int i = 0; i < M; i++) {
//		for (int j = 0; j < M; j++) {
//		    System.out.printf("%d%c", d[i][j], j == M - 1 ? '\n' : ' ');
//		}
//	    }
	    if (res == Integer.MAX_VALUE) {
		System.out.println("Impossible");
	    } else {
		System.out.printf("%.3f\n", res);
	    }
	}
    }
}