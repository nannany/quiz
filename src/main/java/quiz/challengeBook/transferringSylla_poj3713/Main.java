package quiz.challengeBook.transferringSylla_poj3713;

import java.util.ArrayList;
import java.util.Scanner;

// 全ての頂点において、互いの最小カットが3以上であればよい
public class Main {
    static int N;
    static int M;
    static ArrayList<Edge>[] G;
    static int[] d;
    static boolean[] used;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
	    N = sc.nextInt();
	    M = sc.nextInt();
	    d = new int[N];
	    used = new boolean[N];
	    if (N == 0 && M == 0) {
		break;
	    }
	    for (int i = 0; i < N; i++) {
		G[i] = new ArrayList<Edge>();
	    }
	    for (int i = 0; i < M; i++) {
		int from = sc.nextInt();
		int to = sc.nextInt();
		G[from].add(new Edge(from, to));
		G[to].add(new Edge(to, from));
	    }

	    // for(int )
	}
	sc.close();
    }

    // static void dijkstra(int s) {
    // for (int i = 0; i < N; i++) {
    // d[i] = Integer.MAX_VALUE;
    // used[i] = false;
    // }
    //
    // d[s] = 0;
    // while (true) {
    // int v = -1;
    // for (int u = 0; u < N; u++) {
    // if (!used[u] && (v == -1 || d[u] < d[v])) {
    // v = u;
    // }
    // }
    // if (v == -1) {
    // break;
    // }
    // used[v] = true;
    //
    // for (int u = 0; u < N; u++) {
    // d[u] = Math.min(d[u], d[v] + 1);
    // }
    // }
    // }

    static class Edge {
	int from, to;

	public Edge(int from, int to) {
	    super();
	    this.from = from;
	    this.to = to;
	}

    }
}
