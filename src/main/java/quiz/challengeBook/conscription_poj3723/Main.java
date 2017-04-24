package quiz.challengeBook.conscription_poj3723;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for (int i = 0; i < T; i++) {
	    // girls
	    int N = sc.nextInt();
	    // boys
	    int M = sc.nextInt();
	    // relations num
	    int R = sc.nextInt();
	    List<Edge> edges = new ArrayList<Edge>();
	    for (int j = 0; j < R; j++) {
		edges.add(new Edge(sc.nextInt(), sc.nextInt() + N, sc.nextInt()));
	    }

	    edges.sort(new Comparator<Edge>() {
		public int compare(Edge e1, Edge e2) {
		    return e2.cost - e1.cost;
		}
	    });

	    UnionFind uf = new UnionFind(N + M);
	    uf.init(N + M);
	    int relationVal = 0;
	    for (int j = 0; j < R; j++) {
		Edge edge = edges.get(j);
		if (!uf.same(edge.u, edge.v)) {
		    relationVal += edge.cost;
		    uf.unite(edge.u, edge.v);
		}
	    }
	    System.out.println(10000 * (N + M) - relationVal);
	}
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
