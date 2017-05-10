package quiz.challengeBook.valueWhoseSumIs0_poj2785;

import java.util.Scanner;

public class Main {

    static int[] ab;
    static int[] cd;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int[] a = new int[N];
	int[] b = new int[N];
	int[] c = new int[N];
	int[] d = new int[N];
	for (int i = 0; i < N; i++) {
	    a[i] = sc.nextInt();
	    b[i] = sc.nextInt();
	    c[i] = sc.nextInt();
	    d[i] = sc.nextInt();
	}

	ab = new int[N * N];
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		ab[i * N + j] = a[i] + b[j];
	    }
	}
	// quickSort(ab, 0, N * N - 1);
	// Arrays.stream(ab).boxed().forEach(i -> System.out.println(i));

	cd = new int[N * N];
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N; j++) {
		cd[i * N + j] = c[i] + d[j];
	    }
	}
	quickSort(cd, 0, N * N - 1);

	long res = 0;
	for (int i = 0; i < N * N; i++) {
	    res += upperBound(cd, -ab[i]) - lowerBound(cd, -ab[i]);
	}

	System.out.println(res);
    }

    static boolean C(int mid, int abIndex) {
	if (cd[mid] <= -ab[abIndex]) {
	    return true;
	} else {
	    return false;
	}
    }

    // 配列a のa[i]からa[j]まで並べ替える
    static void quickSort(int[] a, int i, int j) {
	if (i == j) {
	    return;
	}
	int p = pivot(a, i, j);
	if (p != -1) {
	    int k = partition(a, i, j, a[p]);
	    quickSort(a, i, k - 1);
	    quickSort(a, k, j);
	}

    }

    static int partition(int[] a, int i, int j, int x) {
	int l = i, r = j;
	while (l <= r) {
	    while (l <= j && a[l] < x) {
		l++;
	    }
	    while (i <= r && x <= a[r]) {
		r--;
	    }
	    if (r < l) {
		break;
	    }
	    int t = a[l];
	    a[l] = a[r];
	    a[r] = t;
	    l++;
	    r--;
	}
	return l;
    }

    static int pivot(int[] a, int i, int j) {
	int k = i + 1;
	while (k <= j && a[i] == a[k]) {
	    k++;
	}
	// 全部同じ要素
	if (k > j) {
	    return -1;
	}
	if (a[i] >= a[k]) {
	    return i;
	}
	return k;
    }

    static int[] intArrayTarget;
    static int targetNum;

    static public int upperBound(int[] target, int num) {
	intArrayTarget = target;
	targetNum = num;
	int start = 0;
	int end = target.length - 1;

	while (start <= end) {
	    int mid = (start + end) / 2;
	    if (cForUpper(mid)) {
		start = mid + 1;
	    } else {
		end = mid - 1;
	    }
	}
	return start;
    }

    /**
     * int配列から特定の値を二分探索で求める。 targetは昇順ソートされている必要がある。
     * targetNum以上の値が初めて出現するindexを返す。
     *
     * @param target
     * @param num
     * @return start int
     */
    static public int lowerBound(int[] target, int num) {
	intArrayTarget = target;
	targetNum = num;
	int start = 0;
	int end = target.length - 1;

	while (start <= end) {
	    int mid = (start + end) / 2;
	    if (cForLower(mid)) {
		start = mid + 1;
	    } else {
		end = mid - 1;
	    }
	}
	return start;
    }

    /**
     * upperBoundにおける二分探索判定用に用いる。
     *
     * @param mid
     * @return boolean
     */
    static private boolean cForUpper(int mid) {
	if (intArrayTarget[mid] <= targetNum) {
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * lowerBoundにおける二分探索判定用に用いる。
     *
     * @param mid
     * @return boolean
     */
    static private boolean cForLower(int mid) {
	if (intArrayTarget[mid] < targetNum) {
	    return true;
	} else {
	    return false;
	}
    }
}
