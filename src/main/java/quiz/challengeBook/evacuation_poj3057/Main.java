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

    static final int[] dx = { -1, 0, 0, 1 };
    static final int[] dy = { 0, -1, 1, 0 };

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for (int i = 0; i < T; i++) {
	    X = sc.nextInt();
	    Y = sc.nextInt();
	    field = new String[X][Y];
	    dist = new int[X][Y][X][Y];
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

	}
	sc.close();
    }

    static void solve() {
	int n = X * Y;
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
