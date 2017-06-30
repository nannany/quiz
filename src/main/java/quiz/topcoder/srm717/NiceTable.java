package quiz.topcoder.srm717;

public class NiceTable {
    static int[][] targetTable;
    static int[] y;
    static int[] y_rev;

    public String isNice(String[] t) {
	targetTable = new int[t.length][t[0].length()];
	for (int i = 0; i < t.length; i++) {
	    for (int j = 0; j < t[0].length(); j++) {
		targetTable[i][j] = Integer.parseInt(String.valueOf(t[i].charAt(j)));
	    }
	}

	y_rev = new int[t[0].length()];
	y = new int[t[0].length()];
	for (int i = 0; i < t[0].length(); i++) {
	    y[i] = targetTable[0][i];
	    y_rev[i] = Math.abs(targetTable[0][i] - 1);
	}
	for (int i = 0; i < y.length; i++) {
	    System.out.println("y" + y[i]);
	    System.out.println("y_rev" + y[i]);
	}
	for (int i = 0; i < t.length; i++) {
	    if (!isMatched(i)) {
		return "Not nice";
	    }
	}
	return "Nice";
    }

    static boolean isMatched(int k) {
	boolean normal_flg = true;
	for (int i = 0; i < y.length; i++) {
	    if (targetTable[k][i] != y[i]) {
		normal_flg = false;
	    }
	}
	boolean rev_flg = true;
	for (int i = 0; i < y.length; i++) {
	    if (targetTable[k][i] != y_rev[i]) {
		rev_flg = false;
	    }
	}

	if (normal_flg || rev_flg) {
	    return true;
	} else {
	    return false;
	}
    }
}
