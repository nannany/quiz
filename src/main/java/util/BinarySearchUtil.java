package util;

public class BinarySearchUtil {
    // インスタンスは作らせない。
    private BinarySearchUtil() {
    };

    static int[] intArrayTarget;
    static int targetNum;

    /**
     * int配列から特定の値を二分探索で求める。 targetは昇順ソートされている必要がある。
     * targetNumより大きい値がはじめて出現するindexを返す。
     *
     * @param target
     * @param num
     * @return start int
     */
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
