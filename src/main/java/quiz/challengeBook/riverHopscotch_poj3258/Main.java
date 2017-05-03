package quiz.challengeBook.riverHopscotch_poj3258;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static List<Integer> stones = new ArrayList<Integer>();

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int L = sc.nextInt();
	N = sc.nextInt();
	M = sc.nextInt();

	stones.add(0);
	for (int i = 0; i < N; i++) {
	    stones.add(sc.nextInt());
	}
	stones.add(L);

	int tmp = stones.get(1);
	for (int i = 2; i <= N; i++) {
	    if (stones.get(i).intValue() < tmp) {
		stones.set(i - 1, stones.get(i));
		stones.set(i, tmp);
	    }
	    tmp = stones.get(i);
	}

	int min = Integer.MAX_VALUE;
	for (int i = 1; i <= N + 1; i++) {
	    if (stones.get(i) - stones.get(i - 1) < min) {
		min = stones.get(i) - stones.get(i - 1);
	    }
	}

	int ub = L;
	int lb = min;

	while (ub - lb > 1) {
	    int mid = (ub + lb) / 2;
	    if (C(mid)) {
		lb = mid;
	    } else {
		ub = mid;
	    }
	}
	System.out.println(lb);
    }

    static boolean C(int d) {
	int count = 0;
	int tmpBase = d;
	for (int i = 1; i <= N; i++) {
	    if (stones.get(i).intValue() < tmpBase) {
		count++;
	    } else {
		tmpBase = stones.get(i) + d;
	    }
	}
	if (count <= M) {
	    return true;
	} else {
	    return false;
	}
    }
}
