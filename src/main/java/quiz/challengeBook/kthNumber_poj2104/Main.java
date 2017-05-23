package quiz.challengeBook.kthNumber_poj2104;

import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] A;
    static int[] I;
    static int[] J;
    static int[] K;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	M = sc.nextInt();
	A = new int[N + 1];
	for (int i = 1; i <= N; i++) {
	    A[i] = sc.nextInt();
	}
	I = new int[M + 1];
	J = new int[M + 1];
	K = new int[M + 1];
	for (int i = 1; i <= M; i++) {
	    I[i] = sc.nextInt();
	    J[i] = sc.nextInt();
	    K[i] = sc.nextInt();
	}
    }
}
