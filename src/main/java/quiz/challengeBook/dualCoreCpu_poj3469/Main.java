package quiz.challengeBook.dualCoreCpu_poj3469;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] A, B, a, b, w;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	M = sc.nextInt();
	A = new int[N];
	B = new int[N];
	a = new int[M];
	b = new int[M];
	w = new int[M];
	for (int i = 0; i < N; i++) {
	    A[i] = sc.nextInt();
	    B[i] = sc.nextInt();
	}
	for (int i = 0; i < M; i++) {
	    a[i] = sc.nextInt();
	    b[i] = sc.nextInt();
	    w[i] = sc.nextInt();
	}

	int s = N;
	int t = s + 1;
	G = new ArrayList[t + 1];
	for (int i = 0; i <= t; i++) {
	    G[i] = new ArrayList<Edge>();
	}

	for (int i = 0; i < N; i++) {
	    addEdge(i, t, A[i]);
	    addEdge(s, i, B[i]);
	}
	for (int i = 0; i < M; i++) {
	    addEdge(a[i], b[i], w[i]);
	    addEdge(b[i], a[i], w[i]);
	}

	level = new int[t + 1];
	iter = new int[t + 1];

	System.out.println(maxFlow(s, t));
    }

    static ArrayList<Edge>[] G;

    // sからの距離
    static int[] level;
    // どこまで調べ終わったか
    static int[] iter;

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

    static void bfs(int s) {
	for (int i = 0; i < level.length; i++) {
	    level[i] = -1;
	}
	Queue<Integer> que = new LinkedList<Integer>();
	level[s] = 0;
	que.add(s);
	while (!que.isEmpty()) {
	    int v = que.poll();
	    for (int i = 0; i < G[v].size(); i++) {
		Edge edge = G[v].get(i);
		if (edge.cap > 0 && level[edge.to] < 0) {
		    level[edge.to] = level[v] + 1;
		    que.add(edge.to);
		}
	    }
	}
    }

    static int dfs(int v, int t, int f) {
	if (v == t) {
	    return f;
	}
	for (int i = iter[v]; i < G[v].size(); i++) {
	    iter[v]++;
	    Edge edge = G[v].get(i);
	    if (edge.cap > 0 && level[v] < level[edge.to]) {
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

    // dinic法
    static int maxFlow(int s, int t) {
	int flow = 0;
	while (true) {
	    bfs(s);
	    if (level[t] < 0) {
		return flow;
	    }
	    for (int i = 0; i < iter.length; i++) {
		iter[i] = 0;
	    }
	    int f;
	    while ((f = dfs(s, t, Integer.MAX_VALUE)) > 0) {
		flow += f;
	    }
	}
    }
}
