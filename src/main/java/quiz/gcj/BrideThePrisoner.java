package quiz.gcj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BrideThePrisoner {
    static int P;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	for (int i = 1; i <= N; i++) {
	    P = sc.nextInt();
	    int Q = sc.nextInt();

	    List<Integer> A = new ArrayList<Integer>();
	    for (int j = 0; j < Q; j++) {
		A.add(sc.nextInt());
	    }

	    int ans = 0;
	    for (int j = Q; 0 < j; j--) {
		Queue<SumNexts> que = new PriorityQueue<SumNexts>(new Comparator<SumNexts>() {
		    public int compare(SumNexts sn1, SumNexts sn2) {
			return sn1.sum - sn2.sum;
		    }
		});
		for (int k = 0; k < j; k++) {
		    que.add(new SumNexts(k, A));
		}
		SumNexts tmpSumNexts = que.poll();
		ans += tmpSumNexts.sum;
		A.remove(tmpSumNexts.pos);
	    }

	    System.out.println("Case #" + i + ": " + ans);
	}
	sc.close();
    }

    static class SumNexts {
	int pos, sum;

	public SumNexts(int pos, List<Integer> a) {
	    this.pos = pos;

	    if (a.size() == 1) {
		this.sum = P - 1;
	    } else if (pos == 0) {
		this.sum = a.get(1) - 2;
	    } else if (pos == a.size() - 1) {
		this.sum = P - a.get(a.size() - 2) - 1;
	    } else {
		this.sum = a.get(pos + 1) - a.get(pos - 1) - 2;
	    }
	}
    }
}
