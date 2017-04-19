package quiz.challengeBook.agriNet_poj1258_kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	List<Edge> edges = new ArrayList<Edge>();
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		Edge edge = new Edge(i, j, sc.nextInt());
		edges.add(edge);
	    }
	}

	Collections.sort(edges, new Comparator<Edge>() {
	    public int compare(Edge e1, Edge e2) {
		return e1.cost - e2.cost;
	    }
	});
	UnionFind uf = new UnionFind(N);
	uf.init(N);

	int ans = 0;
	for (int i = 0; i < N * N; i++) {
	    Edge edge = edges.get(i);
	    if (!uf.same(edge.u, edge.v)) {
		uf.unite(edge.u, edge.v);
		ans += edge.cost;
	    }
	}

	System.out.println(ans);
	sc.close();
    }

    static class Edge {
	int u, v, cost;

	Edge(int u, int v, int cost) {
	    this.u = u;
	    this.v = v;
	    this.cost = cost;
	}

    }

    static class UnionFind {
	int[] par;
	int[] rank;

	UnionFind(int n) {
	    this.par = new int[n];
	    this.rank = new int[n];
	}

	void init(int n) {
	    for (int i = 0; i < n; i++) {
		par[i] = i;
		rank[i] = 0;
	    }
	}

	int find(int x) {
	    if (par[x] == x) {
		return x;
	    } else {
		return par[x] = find(par[x]);
	    }
	}

	void unite(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x == y)
		return;

	    if (rank[x] < rank[y]) {
		par[x] = y;
	    } else {
		par[y] = x;
		if (rank[x] == rank[y]) {
		    rank[x]++;
		}
	    }
	}

	boolean same(int x, int y) {
	    return find(x) == find(y);
	}
    }

}
