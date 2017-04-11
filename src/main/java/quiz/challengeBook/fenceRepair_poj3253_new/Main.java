package quiz.challengeBook.fenceRepair_poj3253_new;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();

	Queue que = new PriorityQueue();
	for (int i = 0; i < N; i++) {
	    que.add(sc.nextInt());
	}

	int ans = 0;
	while (!que.isEmpty()) {
	    int min1 = (int) que.poll();
	    int min2 = (int) que.poll();

	    int tmp_sum = min1 + min2;
	    ans += tmp_sum;
	    if (!que.isEmpty()) {
		que.add(tmp_sum);
	    }
	}
	System.out.println(ans);
    }
}
