package quiz.challengeBook.coins_poj1742;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    if (n == 0 && m == 0)
		break;
	    int a[] = new int[n];
	    for (int i = 0; i < n; i++) {
		a[i] = sc.nextInt();
	    }
	    int c[] = new int[n];
	    for (int i = 0; i < n; i++) {
		c[i] = sc.nextInt();
	    }

	    int dp[] = new int[m + 1];
	    Arrays.fill(dp, -1);
	    dp[0] = 0;
	    for (int i = 0; i < n; i++) {
		for (int j = 0; j <= m; j++) {
		    if (0 <= dp[j]) {
			dp[j] = c[i];
		    } else if (j - a[i] < 0 || dp[j - a[i]] <= -1) {
			dp[j] = -1;
		    } else {
			dp[j] = dp[j - a[i]] - 1;
		    }
		}
	    }
	    int ans = 0;
	    for (int i = 1; i <= m; i++) {
		if (dp[i] >= 0) {
		    ans++;
		}
	    }
	    System.out.println(ans);
	}

	sc.close();
    }
}
