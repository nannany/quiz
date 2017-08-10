package quiz.atcoder.regularContest080;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] p;
    static SegTree evenSegTree;
    static SegTree oddSegTree;

    static class NumAndPos {
	int num, pos;

	public NumAndPos(int num, int pos) {
	    super();
	    this.num = num;
	    this.pos = pos;
	}

	public NumAndPos() {
	}

    }

    static class SegTree {
	NumAndPos[] dat;
	int N;

	public SegTree(int n) {
	    N = n;

	    this.dat = new NumAndPos[2 * N];
	    for (int i = 0; i < 2 * N; i++) {
		dat[i] = new NumAndPos(-1, -1);
	    }

	}

	// void init(int n) {
	// N = 1;
	// while (N < n) {
	// N *= 2;
	// }
	// for (int i = 0; i < 2 * N - 1; i++) {
	// dat[i] = Integer.MAX_VALUE - 10;
	// }
	// }

	void update(int k, NumAndPos a) {
	    k += N - 1;
	    dat[k] = a;
	    while (0 < k) {
		k = (k - 1) / 2;
		// dat[k] = Math.min(dat[k * 2 + 1], dat[k * 2 + 2]);
		if (dat[k * 2 + 1].num < dat[k * 2 + 2].num) {
		    dat[k] = dat[k * 2 + 1];
		} else {
		    dat[k] = dat[k * 2 + 2];
		}
	    }
	}

	NumAndPos query(int a, int b, int k, int l, int r) {
	    if (r <= a || b <= l) {
		return new NumAndPos(Integer.MAX_VALUE - 10, 0);
	    }
	    if (a <= l && r <= b) {
		return dat[k];
	    } else {
		NumAndPos vl = query(a, b, k * 2 + 1, l, (l + r) / 2);
		NumAndPos vr = query(a, b, k * 2 + 2, (l + r) / 2, r);
		// return Math.min(vl, vr);
		if (vl.num < vr.num) {
		    return vl;
		} else {
		    return vr;
		}
	    }
	}
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	p = new int[N];
	for (int i = 0; i < N; i++) {
	    p[i] = sc.nextInt();
	}

	evenSegTree = new SegTree(N);
	oddSegTree = new SegTree(N);

	for (int i = 0; i < N; i++) {
	    if (i % 2 == 0) {
		evenSegTree.update(i, new NumAndPos(p[i], i));
		oddSegTree.update(i, new NumAndPos(Integer.MAX_VALUE, i));
	    } else {
		oddSegTree.update(i, new NumAndPos(p[i], i));
		evenSegTree.update(i, new NumAndPos(Integer.MAX_VALUE, i));
	    }
	}

	Queue<Range> pq = new PriorityQueue<Range>(N, new MyComparator());
	pq.add(new Range(0, N));
	ArrayList<Integer> ans = new ArrayList<Integer>();
	while (ans.size() != N) {
	    Range tmpRange = pq.poll();
	    if (tmpRange.start % 2 == 0) {
		NumAndPos nap1 = evenSegTree.query(tmpRange.start, tmpRange.end, 0, 0, N);
		ans.add(nap1.num);
		NumAndPos nap2 = oddSegTree.query(tmpRange.start, tmpRange.end, 0, 0, N);
		ans.add(nap2.num);
		pq.add(new Range(tmpRange.start, nap1.pos));
		pq.add(new Range(nap1.pos + 1, nap2.pos));
		pq.add(new Range(nap2.pos + 1, tmpRange.end));
	    } else {
		NumAndPos nap1 = oddSegTree.query(tmpRange.start, tmpRange.end, 0, 0, N);
		ans.add(nap1.num);
		NumAndPos nap2 = evenSegTree.query(tmpRange.start, tmpRange.end, 0, 0, N);
		ans.add(nap2.num);
		pq.add(new Range(tmpRange.start, nap1.pos));
		pq.add(new Range(nap1.pos + 1, nap2.pos));
		pq.add(new Range(nap2.pos + 1, tmpRange.end));
	    }
	}
	ans.stream().forEach(ele -> System.out.print(ele + " "));
    }

    static class MyComparator implements Comparator<Range> {
	@Override
	public int compare(Range r1, Range r2) {
	    if (r1.start % 2 == 0) {
		return evenSegTree.query(r1.start, r1.end, 0, 0, N).num
			- evenSegTree.query(r2.start, r2.end, 0, 0, N).num;
	    } else {
		return oddSegTree.query(r1.start, r1.end, 0, 0, N).num
			- oddSegTree.query(r2.start, r2.end, 0, 0, N).num;
	    }
	}
    }

    static class Range {
	int start, end;

	public Range(int start, int end) {
	    super();
	    this.start = start;
	    this.end = end;
	}
    }

}
