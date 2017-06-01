package quiz.challengeBook.blocks_poj3734;

import java.util.Scanner;

public class Main {

    static int N;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	int[][] A = new int[3][3];
	A[0][0] = 2;
	A[0][1] = 1;
	A[0][2] = 0;
	A[1][0] = 2;
	A[1][1] = 2;
	A[1][2] = 2;
	A[2][0] = 0;
	A[2][1] = 1;
	A[2][2] = 2;
	A = pow(A, N);
	System.out.println(A[0][0]);
    }

    static int[][] mul(int[][] a, int[][] b) {
	int[][] ret = new int[a.length][b[0].length];
	for (int i = 0; i < a.length; i++) {
	    for (int k = 0; k < b.length; k++) {
		for (int j = 0; j < b[0].length; j++) {
		    ret[i][j] += a[i][k] * b[k][j];
		}
	    }
	}
	return ret;
    }

    static int[][] pow(int[][] a, long n) {
	int[][] ret = new int[a.length][a[0].length];
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
