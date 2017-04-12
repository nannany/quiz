package quiz.challengeBook.foodChain_poj1182;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int k = sc.nextInt();
	int T[] = new int[k];
	int X[] = new int[k];
	int Y[] = new int[k];
	for (int i = 0; i < k; i++) {
	    T[i] = sc.nextInt();
	    X[i] = sc.nextInt();
	    Y[i] = sc.nextInt();
	}

	UnionFind uf = new UnionFind(N * 3);
	uf.init(N * 3);

	int ans = 0;
	for (int i = 0; i < k; i++) {
	    int t = T[i];
	    int x = X[i] - 1, y = Y[i] - 1;

	    if (x < 0 || N <= x || y < 0 || N <= y) {
		ans++;
		continue;
	    }
	    if (t == 1) {
		if (uf.same(x, y + N) || uf.same(x, y + 2 * N)) {
		    ans++;
		} else {
		    uf.unite(x, y);
		    uf.unite(x + N, y + N);
		    uf.unite(x + N * 2, y + N * 2);
		}
	    } else {
		 if (uf.same(x, y) || uf.same(x, y + N * 2)) {
		    ans++;
		} else {
		    uf.unite(x, y + N);
		    uf.unite(x + N, y + N * 2);
		    uf.unite(x + N * 2, y);
		}
	    }
	}

	System.out.println(ans);
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
