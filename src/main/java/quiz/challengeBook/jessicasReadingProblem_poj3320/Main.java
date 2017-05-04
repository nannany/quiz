package quiz.challengeBook.jessicasReadingProblem_poj3320;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int P = sc.nextInt();
	int[] a = new int[P];
	for (int i = 0; i < P; i++) {
	    a[i] = sc.nextInt();
	}

	Set<Integer> all = new HashSet<Integer>();
	for (int i = 0; i < P; i++) {
	    all.add(a[i]);
	}
	int n = all.size();

	int s = 0;
	int t = 0;
	int num = 0;
	Map<Integer, Integer> count = new HashMap<Integer, Integer>();
	int res = P;
	while (true) {
	    while (t < P && num < n) {
		if (count.get(a[t]) == null || count.get(a[t]) == 0) {
		    count.put(a[t], 1);
		    t++;
		    num++;
		} else {
		    count.put(a[t], count.get(a[t]).intValue() + 1);
		    t++;
		}
	    }
	    if (num < n) {
		break;
	    }
	    res = Math.min(res, t - s);
	    count.put(a[s], count.get(a[s]).intValue() - 1);
	    if (count.get(a[s]).intValue() == 0) {
		num--;
	    }
	    s++;
	}

	System.out.println(res);
    }
}
