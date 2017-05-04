package quiz.challengeBook.mooUniversity_poj2010;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int C;
    static int F;
    static csatAid[] a;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	C = sc.nextInt();
	F = sc.nextInt();

	for (int i = 0; i < C; i++) {
	    a[i] = new csatAid(sc.nextInt(), sc.nextInt());
	}

	quickSort(a, 0, C - 1);

	int maxMid = -1;
	for (int i = 0; i < C; i++) {
	    if (maxMid < a[i].csat) {
		Queue<Integer> que1 = new PriorityQueue<Integer>();
	    }
	}
    }

    // 配列a のa[i]からa[j]まで並べ替える
    static void quickSort(csatAid[] a, int i, int j) {
	if (i == j) {
	    return;
	}
	int p = pivot(a, i, j);
	if (p != -1) {
	    int k = partition(a, i, j, a[p].csat);
	    quickSort(a, i, k - 1);
	    quickSort(a, k, j);
	}

    }

    static int partition(csatAid[] a, int i, int j, int x) {
	int l = i, r = j;
	while (l <= r) {
	    while (l <= j && a[l].csat < x) {
		l++;
	    }
	    while (i <= r && x <= a[r].csat) {
		r--;
	    }
	    if (r < l) {
		break;
	    }
	    csatAid t = a[l];
	    a[l] = a[r];
	    a[r] = t;
	    l++;
	    r--;
	}
	return l;
    }

    static int pivot(csatAid[] a, int i, int j) {
	int k = i + 1;
	while (k <= j && a[i].csat == a[k].csat) {
	    k++;
	}
	// 全部同じ要素
	if (k > j) {
	    return -1;
	}
	if (a[i].csat >= a[k].csat) {
	    return i;
	}
	return k;
    }

    static class csatAid {
	int csat, aid;

	csatAid(int csat, int aid) {
	    this.csat = csat;
	    this.aid = aid;
	}
    }
}
