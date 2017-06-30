package quiz.challengeBook.dining_poj3281;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static int F;
    static int D;
    static boolean[][] likeF;
    static boolean[][] likeD;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	F = sc.nextInt();
	D = sc.nextInt();
	likeF = new boolean[N][F];
	likeD = new boolean[N][D];

	for (int i = 0; i < N; i++) {
	    int tmpF = sc.nextInt();
	    int tmpD = sc.nextInt();
	    for (int j = 0; j < tmpF; j++) {
		likeF[i][sc.nextInt() - 1] = true;
	    }
	    for (int j = 0; j < tmpD; j++) {
		likeD[i][sc.nextInt() - 1] = true;
	    }
	}

	// スタートの位置決め
	int s = N * 2 + F + D;
	// ゴールの位置決め
	int t = s + 1;

	G = new ArrayList[t + 1];
	used = new boolean[t + 1];
	for (int i = 0; i <= t; i++) {
	    G[i] = new ArrayList<Edge>();
	}

	for (int i = 0; i < F; i++) {
	    addEdge(s, N * 2 + i, 1);
	}
	for (int i = 0; i < D; i++) {
	    addEdge(N * 2 + F + i, t, 1);
	}
	for (int i = 0; i < N; i++) {
	    addEdge(i, N + i, 1);

	    for (int j = 0; j < F; j++) {
		if (likeF[i][j]) {
		    addEdge(N * 2 + j, i, 1);
		}
	    }
	    for (int j = 0; j < D; j++) {
		if (likeD[i][j]) {
		    addEdge(N + i, N * 2 + F + j, 1);
		}
	    }
	}

	System.out.println(maxFlow(s, t));
    }

    static ArrayList<Edge>[] G;
    static boolean used[];

    static class Edge {
	int to, cap, rev;

	public Edge(int to, int cap, int rev) {
	    super();
	    this.to = to;
	    this.cap = cap;
	    this.rev = rev;
	}
    }

    // 辺加える。容量付きのもの
    static void addEdge(int from, int to, int cap) {
	G[from].add(new Edge(to, cap, G[to].size()));
	G[to].add(new Edge(from, 0, G[from].size() - 1));
    }

    // 深さ優先(通常)
    static int dfs(int v, int t, int f) {
	if (v == t) {
	    return f;
	}
	used[v] = true;

	for (int i = 0; i < G[v].size(); i++) {
	    Edge edge = G[v].get(i);
	    if (!used[edge.to] && edge.cap > 0) {
		int d = dfs(edge.to, t, Math.min(f, edge.cap));
		if (d > 0) {
		    edge.cap -= d;
		    G[edge.to].get(edge.rev).cap += d;
		    return d;
		}
	    }
	}
	return 0;
    }

    // sからtへの最大費用流を求める
    static int maxFlow(int s, int t) {
	int flow = 0;
	while (true) {
	    int f = dfs(s, t, Integer.MAX_VALUE);
	    if (f == 0) {
		return flow;
	    }
	    flow += f;
	}
    }

}
