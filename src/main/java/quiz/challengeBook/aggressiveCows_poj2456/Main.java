package quiz.challengeBook.aggressiveCows_poj2456;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> x = new ArrayList<Integer>();
    static int N;
    static int C;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	C = sc.nextInt();

	for (int i = 0; i < N; i++) {
	    x.add(sc.nextInt());
	}

	x.sort(new Comparator<Integer>() {
	    public int compare(Integer i1, Integer i2) {
		return i1.intValue() - i2.intValue();
	    }
	});

	int lb = 0;
	int ub = Integer.MAX_VALUE;

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
	int tmp = x.get(0).intValue();
	int count = 0;
	for (int i = 0; i < N; i++) {
	    if (tmp + d <= x.get(i)) {
		count++;
		tmp = x.get(i);
		if (count == C - 1) {
		    break;
		}
	    }
	}
	if (count == C - 1) {
	    return true;
	} else {
	    return false;
	}
    }
}
