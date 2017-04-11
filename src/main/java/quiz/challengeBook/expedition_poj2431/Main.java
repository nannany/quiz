package quiz.challengeBook.expedition_poj2431;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int distance[] = new int[N + 1];
	int gas[] = new int[N + 1];
	for (int i = 0; i < N; i++) {
	    distance[i] = sc.nextInt();
	    gas[i] = sc.nextInt();
	}
	distance[N] = sc.nextInt();
	gas[N] = 0;
	int tank = sc.nextInt();
	Queue queue = new PriorityQueue(N, new MyComparator());

	int pos = 0, ans = 0;

	for (int i = 0; i < N; i++) {
	    int d = distance[i] - pos;

	    while (tank - d < 0) {
		if (queue.isEmpty()) {
		    System.out.println(-1);
		    return;
		}
		tank += (int) queue.poll();
		ans++;
	    }

	    tank -= d;
	    pos = distance[i];
	    queue.add(gas[i]);
	}
	System.out.println(ans);

    }

    static class MyComparator implements Comparator {

	public int compare(Object obj1, Object obj2) {

	    int num1 = (int) obj1;
	    int num2 = (int) obj2;

	    if (num1 < num2) {
		return 1;
	    } else if (num1 > num2) {
		return -1;
	    } else {
		return 0;
	    }
	}
    }
}
