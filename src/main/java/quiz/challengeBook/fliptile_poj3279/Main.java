package quiz.challengeBook.fliptile_poj3279;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int M;
    static int N;
    static int[][] tile;
    static int[] dx = { -1, 0, 0, 0, 1 };
    static int[] dy = { 0, 1, 0, -1, 0 };
    static int[][] opt;
    static int[][] flip;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	M = sc.nextInt();
	N = sc.nextInt();
	tile = new int[M][N];
	for (int i = 0; i < M; i++) {
	    for (int j = 0; j < N; j++) {
		tile[i][j] = sc.nextInt();
	    }
	}

	opt = new int[M][N];
	flip = new int[M][N];

	int res = -1;

	for (int i = 0; i < 1 << N; i++) {
	    for (int j = 0; j < M; j++) {
		Arrays.fill(flip[j], 0);
	    }

	    for (int j = 0; j < N; j++) {
		flip[0][N - j - 1] = i >> j & 1;
	    }
	    int num = calc();

	    if (0 <= num && (res < 0 || num < res)) {
		res = num;
		for (int j = 0; j < M; j++) {
		    opt[j] = Arrays.copyOf(flip[j], N);
		}
	    }
	}

	if (res < 0) {
	    System.out.println("IMPOSSIBLE");
	} else {
	    for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
		    System.out.printf("%d%c", opt[i][j], j + 1 == N ? '\n' : ' ');
		}
	    }
	}
    }

    static int get(int x, int y) {
	int c = tile[x][y];
	for (int d = 0; d < 5; d++) {
	    int x2 = x + dx[d];
	    int y2 = y + dy[d];
	    if (0 <= x2 && x2 < M && 0 <= y2 && y2 < N) {
		c += flip[x2][y2];
	    }
	}

	return c % 2;
    }

    static int calc() {
	for (int i = 1; i < M; i++) {
	    for (int j = 0; j < N; j++) {
		if (get(i - 1, j) != 0) {
		    flip[i][j] = 1;
		}
	    }
	}

	for (int j = 0; j < N; j++) {
	    if (get(M - 1, j) != 0) {
		return -1;
	    }
	}

	int res = 0;
	for (int i = 0; i < M; i++) {
	    for (int j = 0; j < N; j++) {
		res += flip[i][j];
	    }
	}

	return res;
    }

}
