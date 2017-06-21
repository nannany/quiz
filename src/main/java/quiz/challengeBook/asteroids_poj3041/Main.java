package quiz.challengeBook.asteroids_poj3041;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] R, C;
    static ArrayList<Integer>[] G;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	K = sc.nextInt();
	R = new int[K];
	C = new int[K];
	for (int i = 0; i < K; i++) {
	    R[i] = sc.nextInt();
	    C[i] = sc.nextInt();
	}
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

    static void add_edge(int u ,int v){
	G[u].add(v);
	G[v].add(u);
    }

    static int bipartiteMatching() {
	int res = 0;
	for (int i = 0; i < N *2; i++) {
	    match[i] = -1;
	}

	for (int v = 0; v < N *2; v++) {
	    if (match[v] < 0) {
		for (int i = 0; i < N *2; i++) {
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
