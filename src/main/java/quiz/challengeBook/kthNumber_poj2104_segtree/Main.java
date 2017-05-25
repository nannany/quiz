package quiz.challengeBook.kthNumber_poj2104_segtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int ST_SIZE = (1 << 18) - 1;
    static int N;
    static int M;
    static int[] A;
    static int[] I;
    static int[] J;
    static int[] K;
    static int[] nums;
    static ArrayList<Integer>[] dat;

    static void init(int k, int l, int r) {
	if (r - l == 1) {
	    dat[k].add(A[l]);
	} else {
	    int lch = k * 2 + 1;
	    int rch = k * 2 + 2;
	    init(lch, l, (l + r) / 2);
	    init(rch, (l + r) / 2, r);

	    dat[k] = merge(dat[lch], dat[rch]);
	}
    }

    static int query(int i, int j, int x, int k, int l, int r) {
	if (j <= l || r <= i) {
	    return 0;
	} else if (i <= l && r <= i) {
	    return upperBound(dat[k], x);
	} else {
	    int lc = query(i, j, x, k * 2 + 1, l, (l + r) / 2);
	    int rc = query(i, j, x, k * 2 + 2, (l + r) / 2, r);
	    return lc + rc;
	}
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	M = sc.nextInt();
	A = new int[N];
	nums = new int[N];
	for (int i = 0; i < N; i++) {
	    A[i] = sc.nextInt();
	}
	I = new int[M];
	J = new int[M];
	K = new int[M];
	for (int i = 0; i < M; i++) {
	    I[i] = sc.nextInt();
	    J[i] = sc.nextInt();
	    K[i] = sc.nextInt();
	}

	for (int i = 0; i < N; i++) {
	    nums[i] = A[i];
	}
	Arrays.sort(nums);

	init(0, 0, N);

	for (int i = 0; i < M; i++) {
	    int l = I[i] - 1;
	    int r = J[i];
	    int k = K[i];
	    int lb = -1;
	    int ub = N - 1;

	    while (ub - lb > 1) {
		int md = (ub + lb) / 2;
		int c = query(l, r, nums[md], 0, 0, N);
		if (k <= c) {
		    ub = md;
		} else {
		    lb = md;
		}
	    }
	    System.out.println(nums[ub]);
	}

    }

    static int targetNum;
    static ArrayList<Integer> intArrayTargetForArrayList;

    static public int upperBound(ArrayList<Integer> target, int num) {
	intArrayTargetForArrayList = target;
	targetNum = num;
	int start = 0;
	int end = target.size() - 1;

	while (start <= end) {
	    int mid = (start + end) / 2;
	    if (cForUpperForArrayList(mid)) {
		start = mid + 1;
	    } else {
		end = mid - 1;
	    }
	}
	return start;
    }

    static private boolean cForUpperForArrayList(int mid) {
	if (intArrayTargetForArrayList.get(mid) <= targetNum) {
	    return true;
	} else {
	    return false;
	}
    }

    // マージソートの一端
    static public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
	ArrayList<Integer> ret = new ArrayList<Integer>();

	int i = 0;
	int j = 0;
	while (i < list1.size() || j < list2.size()) {
	    if (list2.size() <= j || (i < list1.size() && list1.get(i) < list2.get(j))) {
		ret.add(list1.get(i));
	    } else {
		ret.add(list2.get(j));
	    }
	}
	return ret;
    }

}
