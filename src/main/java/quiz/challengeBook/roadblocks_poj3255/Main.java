package quiz.challengeBook.roadblocks_poj3255;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int R = sc.nextInt();
	Edge[] graph = new Edge[N];
	for (int i = 0; i < R; i++) {
	    int from = sc.nextInt();
	    int to = sc.nextInt();
	    int cost = sc.nextInt();
	    graph[from - 1] = new Edge(to - 1, cost);
	    graph[to - 1] = new Edge(from - 1, cost);
	}
	int dist[] = new int[N];
	Arrays.fill(dist, Integer.MAX_VALUE);
	int dist2[] = new int[N];
	Arrays.fill(dist2, Integer.MAX_VALUE);
    }

    static class Edge {
	int to, cost;

	Edge(int to, int cost) {
	    this.to = to;
	    this.cost = cost;
	}
    }
}
