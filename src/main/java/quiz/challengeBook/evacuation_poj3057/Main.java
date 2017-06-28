package quiz.challengeBook.evacuation_poj3057;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int X, Y;
    static String[][] field;
    static ArrayList<Integer> dX = new ArrayList<Integer>();
    static ArrayList<Integer> dY = new ArrayList<Integer>();
    static ArrayList<Integer> pX = new ArrayList<Integer>();
    static ArrayList<Integer> pY = new ArrayList<Integer>();
    static int[][][][] dist;
    static boolean used[];
    static int match[];
    static ArrayList<Integer>[] G;

    static final int[] dx = { -1, 0, 0, 1 };
    static final int[] dy = { 0, -1, 1, 0 };

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for (int i = 0; i < T; i++) {
	    X = sc.nextInt();
	    Y = sc.nextInt();
	    int n = X * Y;
	    field = new String[X][Y];
	    dist = new int[X][Y][X][Y];
	    for (int j = 0; j < X; j++) {
		for (int k = 0; k < Y; k++) {
		    for (int l = 0; l < X; l++) {
			for (int m = 0; m < Y; m++) {
			    dist[j][k][l][m] = -1;
			}
		    }
		}
	    }
	    for (int j = 0; j < X; j++) {
		String tmp = sc.next();
		for (int k = 0; k < Y; k++) {
		    field[j][k] = String.valueOf(tmp.charAt(k));
		    if (field[j][k].equals("D")) {
			dX.add(j);
			dY.add(k);
			bfs(j, k, dist[j][k]);
		    }
		    if (field[j][k].equals(".")) {
			pX.add(j);
			pY.add(k);
		    }
		}
	    }

	    int d = dX.size();
	    int p = pX.size();
	    G = new ArrayList[n * d + p];
	    for (int j = 0; j < d; j++) {
		for (int k = 0; k < p; k++) {
		    if (dist[dX.get(j)][dY.get(j)][pX.get(k)][pY.get(k)] >= 0) {
			for (int l = dist[dX.get(j)][dY.get(j)][pX.get(k)][pY.get(k)]; l <= n; l++) {
			    addEdge((k - 1) * d + i, n * d + j);
			}
		    }
		}
	    }

	    if (p == 0) {
		System.out.println(0);
		return;
	    }
	    int num = 0;

	}
	sc.close();
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

    static void addEdge(int u, int v) {
	G[u].add(v);
	G[v].add(u);
    }

    static void bfs(int x, int y, int[][] d) {
	Queue<Integer> qx = new LinkedList<Integer>();
	Queue<Integer> qy = new LinkedList<Integer>();
	d[x][y] = 0;
	qx.add(x);
	qy.add(y);
	while (!qx.isEmpty()) {
	    x = qx.remove();
	    y = qy.remove();
	    for (int k = 0; k < 4; k++) {
		int x2 = x + dx[k];
		int y2 = y + dy[k];
		if (0 <= x2 && x2 < X && 0 <= y2 && y2 < Y && field[x2][y2] == "." && d[x2][y2] < 0) {
		    d[x2][y2] = d[x][y] + 1;
		    qx.add(x2);
		    qy.add(y2);
		}
	    }
	}
    }
}
