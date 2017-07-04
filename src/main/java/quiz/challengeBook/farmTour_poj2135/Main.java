package quiz.challengeBook.farmTour_poj2135;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] a, b, c;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	M = sc.nextInt();
	a = new int[M];
	b = new int[M];
	c = new int[M];
	for (int i = 0; i < M; i++) {
	    a[i] = sc.nextInt();
	    b[i] = sc.nextInt();
	    c[i] = sc.nextInt();
	}

	int s = 0;
	int t = N - 1;
	V = N;
	G = new ArrayList[V];
	for (int i = 0; i < V; i++) {
	    G[i] = new ArrayList<Edge>();
	}
	dist = new int[V];
	prevv = new int[V];
	preve = new int[V];
	for (int i = 0; i < M; i++) {
	    addEdge(a[i] - 1, b[i] - 1, 1, c[i]);
	    addEdge(b[i] - 1, a[i] - 1, 1, c[i]);
	}

	System.out.println(minCostFlow(s, t, 2));
	sc.close();
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
