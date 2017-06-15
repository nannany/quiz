package quiz.challengeBook.thePerfectStall_poj1274;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // num of cow
    static int N;
    // num of stall
    static int M;
    static ArrayList<Integer>[] G;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
	    N = sc.nextInt();
	    M = sc.nextInt();
	    G = new ArrayList[N + M];
	    for (int i = 0; i < N + M; i++) {
		G[i] = new ArrayList<Integer>();
	    }
	    for (int i = 0; i < N; i++) {
		int si = sc.nextInt();
		for (int j = 0; j < si; j++) {
		    int tmp = sc.nextInt() + (N - 1);
		    G[i].add(tmp);
		    G[tmp].add(i);
		}
	    }

	    match = new int[N + M];
	    used = new boolean[N + M];

	    System.out.println(bipartiteMatching());
	}
//	sc.close();
    }

    static int[] match;
    static boolean[] used;

    static boolean dfs(int v) {
	used[v] = true;
	for (int i = 0; i < G[v].size(); i++) {
	    int u = G[v].get(i);
	    int w = match[u];

	    if (w < 0 || !used[w] && dfs(w)) {
		match[v] = u;
		match[u] = v;
		return true;
	    }
	}
	return false;
    }

    static int bipartiteMatching() {
	int res = 0;
	for (int i = 0; i < N + M; i++) {
	    match[i] = -1;
	}

	for (int v = 0; v < N + M; v++) {
	    if (match[v] < 0) {
		for (int i = 0; i < N + M; i++) {
		    used[i] = false;
		}
		if (dfs(v)) {
		    res++;
		}
	    }
	}
	return res;
    }
}
