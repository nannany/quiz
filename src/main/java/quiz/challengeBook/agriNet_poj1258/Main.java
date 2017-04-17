package quiz.challengeBook.agriNet_poj1258;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int cost[][] = new int[N][N];
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		cost[i][j] = sc.nextInt();
	    }
	}

	boolean used[] = new boolean[N];
	Arrays.fill(used, false);
	int mincost[] = new int[N];
	Arrays.fill(mincost, Integer.MAX_VALUE);
	mincost[0] = 0;
	int ans = 0;
	while (true) {
	    int v = -1;
	    for (int u = 0; u < N; u++) {
		if (!used[u] && (v == -1 || mincost[u] < mincost[v])) {
		    v = u;
		}
	    }

	    if (v == -1) {
		break;
	    }
	    used[v] = true;
	    ans += mincost[v];

	    for (int u = 0; u < N; u++) {
		mincost[u] = Math.min(mincost[u], cost[u][v]);
	    }
	}
	System.out.println(ans);
	sc.close();
    }
}
