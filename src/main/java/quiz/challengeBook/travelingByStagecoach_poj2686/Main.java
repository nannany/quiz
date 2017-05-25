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
	N = sc.nextInt();
	M = sc.nextInt();
	dp = new double[1 << N][M];
	p = sc.nextInt();
	a = sc.nextInt();
	b = sc.nextInt();
	t = new int[N];
	for (int i = 0; i < N; i++) {
	    t[i] = sc.nextInt();
	}

	d = new int[M][M];
	for (int i = 0; i < M; i++) {
	    Arrays.fill(d[i], -1);
	}
	for (int i = 0; i < p; i++) {
	    d[sc.nextInt()][sc.nextInt()] = sc.nextInt();
	}

    }
}