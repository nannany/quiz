package quiz.challengeBook.theWindys_poj3686;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] Z;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for (int count = 0; count < T; count++) {
	    N = sc.nextInt();
	    M = sc.nextInt();
	    Z = new int[N][M];
	    for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
		    Z[i][j] = sc.nextInt();
		}
	    }

	    int s = N + N * M;
	    int t = s + 1;
	    V = t + 1;
	    G = new ArrayList[V];
	    for (int i = 0; i < V; i++) {
		G[i] = new ArrayList<Edge>();
	    }
	    dist = new int[V];
	    prevv = new int[V];
	    preve = new int[V];

	    for (int i = 0; i < N; i++) {
		addEdge(s, i, 1, 0);
	    }
	    for (int j = 0; j < M; j++) {
		for (int k = 0; k < N; k++) {
		    addEdge(N + j * N + k, t, 1, 0);
		    for (int i = 0; i < N; i++) {
			addEdge(i, N + j * N + k, 1, (k + 1) * Z[i][j]);
		    }
		}
	    }

	    System.out.printf("%.6f\n", (double) minCostFlow(s, t, N) / N);
	}
    }

    static ArrayList<Edge>[] G;
    static int V;
    static int[] dist;
    static int[] prevv;
    static int[] preve;

    static class Edge {
	int to, cap, cost, rev;

	public Edge(int to, int cap, int cost, int rev) {
	    super();
	    this.to = to;
	    this.cap = cap;
	    this.cost = cost;
	    this.rev = rev;
	}

    }

    // 辺加える。容量,コスト付きのもの
    static void addEdge(int from, int to, int cap, int cost) {
	G[from].add(new Edge(to, cap, cost, G[to].size()));
	G[to].add(new Edge(from, 0, -cost, G[from].size() - 1));
    }

    // sからtへの流量fの最小費用流求める
    static int minCostFlow(int s, int t, int f) {
	int res = 0;
	while (f > 0) {
	    for (int i = 0; i < V; i++) {
		dist[i] = Integer.MAX_VALUE;
	    }
	    dist[s] = 0;
	    boolean update = true;
	    while (update) {
		update = false;
		for (int v = 0; v < V; v++) {
		    if (dist[v] == Integer.MAX_VALUE) {
			continue;
		    }
		    for (int i = 0; i < G[v].size(); i++) {
			Edge edge = G[v].get(i);
			if (edge.cap > 0 && dist[edge.to] > dist[v] + edge.cost) {
			    dist[edge.to] = dist[v] + edge.cost;
			    prevv[edge.to] = v;
			    preve[edge.to] = i;
			    update = true;
			}
		    }
		}
	    }
	    if (dist[t] == Integer.MAX_VALUE) {
		return -1;
	    }

	    int d = f;
	    for (int v = t; v != s; v = prevv[v]) {
		d = Math.min(d, G[prevv[v]].get(preve[v]).cap);
	    }
	    f -= d;
	    res += d * dist[t];
	    for (int v = t; v != s; v = prevv[v]) {
		Edge edge = G[prevv[v]].get(preve[v]);
		edge.cap -= d;
		G[v].get(edge.rev).cap += d;
	    }
	}
	return res;

    }

}
