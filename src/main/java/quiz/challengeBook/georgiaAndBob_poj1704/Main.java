package quiz.challengeBook.georgiaAndBob_poj1704;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for (int caseNo = 0; caseNo < T; caseNo++) {
	    int N = sc.nextInt();
	    int[] P = new int[1000];
	    Arrays.fill(P, Integer.MAX_VALUE);
	    for (int i = 0; i < N; i++) {
		P[i] = sc.nextInt();
	    }
	    if (N % 2 == 1) {
		P[N++] = 0;
	    }
	    Arrays.sort(P);
	    int x = 0;
	    for (int i = 0; i + 1 < N; i += 2) {
		x ^= (P[i + 1] - P[i] - 1);
	    }
	    if (x == 0) {
		System.out.println("Bob will win");
	    } else {
		System.out.println("Georgia will win");
	    }
	}
	sc.close();
    }

}
