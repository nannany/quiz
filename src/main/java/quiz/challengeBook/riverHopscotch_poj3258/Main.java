package quiz.challengeBook.riverHopscotch_poj3258;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int L = sc.nextInt();
	int N = sc.nextInt();
	int M = sc.nextInt();

	List<Integer> stones = new ArrayList<Integer>();
	stones.add(0);
	for (int i = 0; i < N; i++) {
	    stones.add(sc.nextInt());
	}
	stones.add(L);

	// stones.sort(new Comparator<Integer>() {
	// public int compare(Integer i1, Integer i2) {
	// return i1.intValue() - i2.intValue();
	// }
	// });
	int tmp = stones.get(1);
	for (int i = 2; i <= N; i++) {
	    if (stones.get(i).intValue() < tmp) {
		stones.set(i - 1, stones.get(i));
		stones.set(i, tmp);
	    }
	    tmp = stones.get(i);
	}
	// for (Integer i : stones) {
	// System.out.println(i.intValue());
	// }

	List<Integer> distance = new ArrayList<Integer>();
	for (int i = 1; i <= N + 1; i++) {
	    distance.add(stones.get(i) - stones.get(i - 1));
	}

	for (int i = 0; i < M; i++) {
	    int min = Integer.MAX_VALUE;
	    int removeTarget = -1;
	    for (int j = 0; j < distance.size(); j++) {
		if (distance.get(j).intValue() < min) {
		    min = distance.get(j).intValue();
		    removeTarget = j;
		}
	    }
	    distance.set(removeTarget + 1, distance.get(removeTarget) + distance.get(removeTarget) + 1);
	    distance.remove(removeTarget);
	}

	int ans = Integer.MAX_VALUE;
	for (Integer forAns : distance) {
	    if (forAns.intValue() < ans) {
		ans = forAns.intValue();
	    }
	}

	System.out.println(ans);
    }
}
