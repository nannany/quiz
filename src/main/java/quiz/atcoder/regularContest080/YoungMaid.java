package quiz.atcoder.regularContest080;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class YoungMaid {
    static int N;
    static int[] p;
    static SegTree evenSegTree;
    static SegTree oddSegTree;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
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
	}
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
}

class Range {
    int start, end;

    public Range(int start, int end) {
	super();
	this.start = start;
	this.end = end;
    }
}

class NumAndPos {
    int num, pos;

    public NumAndPos(int num, int pos) {
	super();
	this.num = num;
	this.pos = pos;
    }

}

class SegTree {
    NumAndPos[] dat;
    int N;

    public SegTree(int n) {
	super();
	this.dat = new NumAndPos[n];
	N = n;
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
