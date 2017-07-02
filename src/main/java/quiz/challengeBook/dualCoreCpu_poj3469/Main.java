package quiz.challengeBook.dualCoreCpu_poj3469;

import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] A, B, a, b, w;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	M = sc.nextInt();
	A = new int[N];
	B = new int[N];
	a = new int[M];
	b = new int[M];
	w = new int[M];
	for (int i = 0; i < N; i++) {
	    A[i] = sc.nextInt();
	    B[i] = sc.nextInt();
	}
	for (int i = 0; i < M; i++) {
	    a[i] = sc.nextInt();
	    b[i] = sc.nextInt();
	    w[i] = sc.nextInt();
	}


    }
}
