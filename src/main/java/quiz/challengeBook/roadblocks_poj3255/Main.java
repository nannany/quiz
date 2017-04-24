package quiz.challengeBook.roadblocks_poj3255;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int R = sc.nextInt();
	AdjacencyList[] graph = new AdjacencyList[N];
	for (int i = 0; i < N; i++) {
	    graph[i] = new AdjacencyList();
	}
	for (int i = 0; i < R; i++) {
	    int from = sc.nextInt();
	    int to = sc.nextInt();
	    int cost = sc.nextInt();
	    graph[from - 1].edges.add(new Edge(to - 1, cost));
	    graph[to - 1].edges.add(new Edge(from - 1, cost));
	}
	int dist[] = new int[N];
	Arrays.fill(dist, Integer.MAX_VALUE);
	int dist2[] = new int[N];
	Arrays.fill(dist2, Integer.MAX_VALUE);

	dist[0] = 0;
	PriorityQueue<P> que = new PriorityQueue<P>(new Comparator<P>() {
	    public int compare(P p1, P p2) {
		return p1.distance - p2.distance;
	    }
	});
	que.add(new P(0, 0));

	while (!que.isEmpty()) {
	    P p = que.poll();
	    int v = p.v, d = p.distance;
	    if (dist2[v] < d) {
		continue;
	    }
	    for (int i = 0; i < graph[v].edges.size(); i++) {
		Edge edge = graph[v].edges.get(i);
		int d2 = d + edge.cost;
		if (d2 < dist[edge.to]) {
		    int tmp = d2;
		    d2 = dist[edge.to];
		    dist[edge.to] = tmp;
		    que.add(new P(dist[edge.to], edge.to));
		}
		if (d2 < dist2[edge.to] && dist[edge.to] < d2) {
		    dist2[edge.to] = d2;
		    que.add(new P(dist2[edge.to], edge.to));
		}
	    }
	}
	System.out.println(dist2[N - 1]);
	sc.close();
    }

    // 始点からvまでの距離を保持
    static class P {
	int distance, v;

	P(int distance, int v) {
	    this.distance = distance;
	    this.v = v;
	}
    }

    static class AdjacencyList {
	List<Edge> edges = new ArrayList<Edge>();
    }

    static class Edge {
	int to, cost;

	Edge(int to, int cost) {
	    this.to = to;
	    this.cost = cost;
	}
    }
}
