package quiz.challengeBook.woodenStick_poj1065;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();

	for (int i = 0; i < T; i++) {
	    int n = sc.nextInt();
	    int pairs[][] = new int[n][2];
	    for (int j = 0; j < n; j++) {
		int pair[] = new int[2];
		pair[0] = sc.nextInt();
		pair[1] = sc.nextInt();
		pairs[j] = pair;
	    }


	}
    }
}
