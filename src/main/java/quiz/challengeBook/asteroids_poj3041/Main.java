package quiz.challengeBook.asteroids_poj3041;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, K, V;
    static int[] R, C;
    static ArrayList<Integer>[] G;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	K = sc.nextInt();
	V = 2 * N;
	R = new int[K];
	C = new int[K];
	for (int i = 0; i < K; i++) {
	    R[i] = sc.nextInt();
	    C[i] = sc.nextInt();
	}
	G = new ArrayList[V];
	for (int i = 0; i < V; i++) {
	    G[i] = new ArrayList<Integer>();
	}

	for (int i = 0; i < K; i++) {
	    add_edge(R[i] - 1, N + C[i] - 1);
	}

	match = new int[V];
	used = new boolean[V];
	System.out.println(bipartiteMatching());

	sc.close();

    }

    static int[] match;
    static boolean[] used;

    static void add_edge(int u, int v) {
	G[u].add(v);
	G[v].add(u);
    }

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
	for (int i = 0; i < V; i++) {
	    match[i] = -1;
	}

	for (int v = 0; v < V; v++) {
	    if (match[v] < 0) {
		for (int i = 0; i < V; i++) {
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
