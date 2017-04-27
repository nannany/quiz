package quiz.topcoder.srm713;

public class SymmetryDetection {
    public String detect(String[] board) {
	int n = board.length;
	int m = board[0].length();

	boolean isVerticalSymmetric = true;
	boolean isHorizontallySymmetric = true;

	for (int i = 0; i < n / 2; i++) {
	    if (!board[i].equals(board[n - i - 1])) {
		isHorizontallySymmetric = false;
	    }
	}

	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < m / 2; j++) {
		if (!(board[i].charAt(j) == board[i].charAt(m - j - 1))) {
		    isVerticalSymmetric = false;
		}
	    }
	}

	if (isHorizontallySymmetric && isVerticalSymmetric) {
	    return "Both";
	} else if (isHorizontallySymmetric) {
	    return "Horizontally symmetric";
	} else if (isVerticalSymmetric) {
	    return "Vertically symmetric";
	} else {
	    return "Neither";
	}
    }
}
