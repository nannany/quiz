package quiz.challengeBook.cowBowling_poj3176;

import java.util.Scanner;

public class Main {
    int[][] line;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int line[][] = new int[N][N];
	sc.nextLine();
	for (int i = 0; i < N; i++) {
	    String[] tmp = sc.nextLine().split(" ");
	    for (int j = 0; j <= i; j++) {
		line[i][j] = Integer.parseInt(tmp[j]);
	    }
	}

	int dp[][] = new int[N][N];

	dp[0][0] = line[0][0];

	for (int i = 1; i < N; i++) {
	    for (int j = 0; j <= i; j++) {
		if (j == 0) {
		    dp[i][j] = dp[i - 1][j] + line[i][j];
		} else {
		    dp[i][j] = Math.max(dp[i - 1][j - 1] + line[i][j], dp[i - 1][j] + line[i][j]);
		}
	    }
	}

	int ans = 0;
	for (int i = 0; i < N; i++) {
	    if (ans < dp[N - 1][i]) {
		ans = dp[N - 1][i];
	    }
	}
	System.out.println(ans);
	sc.close();
    }
}
