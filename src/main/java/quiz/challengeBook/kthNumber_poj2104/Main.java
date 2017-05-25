package quiz.challengeBook.kthNumber_poj2104;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static final int B = 1000;
    static int N;
    static int M;
    static int[] A;
    static int[] I;
    static int[] J;
    static int[] K;
    static int[] nums;
    static ArrayList<Integer>[] bucket;

    static int targetNum;
    static ArrayList<Integer> intArrayTargetForArrayList;

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

	bucket = new ArrayList[N / B + 1];
	for (int i = 0; i < N / B + 1; i++) {
	    bucket[i] = new ArrayList<>();
	}

	for (int i = 0; i < N; i++) {
	    bucket[i / B].add(A[i]);
	    nums[i] = A[i];
	}
	Arrays.sort(nums);

	for (int i = 0; i < N / B; i++) {
	    Collections.sort(bucket[i]);
	}

	for (int i = 0; i < M; i++) {
	    int l = I[i];
	    int r = J[i] + 1;
	    int k = K[i];

	    int lb = -1;
	    int ub = N - 1;
	    while (ub - lb > 1) {
		int md = (lb + ub) / 2;
		int x = nums[md];
		int tl = l - 1;
		int tr = r - 1;
		int c = 0;
		while (tl < tr && tl % B != 0) {
		    if (A[tl++] <= x) {
			c++;
		    }
		}
		while (tl < tr && tr % B != 0) {
		    if (A[--tr] <= x) {
			c++;
		    }
		}

		while (tl < tr) {
		    int b = tl / B;
		    c += upperBound(bucket[b], x);
		    tl += B;
		}
		if (k <= c) {
		    ub = md;
		} else {
		    lb = md;
		}
	    }
	    System.out.println(nums[ub]);
	}
    }

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

}
