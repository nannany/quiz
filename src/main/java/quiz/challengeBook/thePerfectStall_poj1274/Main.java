package quiz.challengeBook.thePerfectStall_poj1274;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // num of cow
    static int N;
    // num of stall
    static int M;
    static ArrayList<Integer>[] G;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	M = sc.nextInt();

	for (int i = 1; i <= N; i++) {
	    G[i] = new ArrayList<Integer>();
	    int si = sc.nextInt();
	    for (int j = 0; j < si; j++) {
		G[i].add(sc.nextInt());
	    }
	}

    }

    static int[] match;
    static boolean[] used;

    static boolean dfs(int v) {
	used[v] = true;
	for (int i = 0; i < G[v].size(); i++) {
	    // int u = G[v].
	}
    }
}
