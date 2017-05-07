package quiz.topcoder.srm714;

public class RangeEncoding {
    public int minRanges(int[] arr) {
	int ret = 1;
	if (arr.length == 1) {
	    return 1;
	}
	int beforeNum = arr[0];
	for (int i = 1; i < arr.length; i++) {
	    if ((beforeNum + 1) != arr[i]) {
		ret++;
		beforeNum = arr[i];
	    }
	    beforeNum = arr[i];
	}
	return ret;

    }
}
