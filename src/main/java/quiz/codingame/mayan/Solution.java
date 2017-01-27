import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	int L = in.nextInt();
	int H = in.nextInt();
	Map<ArrayList<String>, Integer> map = new HashMap<ArrayList<String>, Integer>();

	String[][] tmp = new String[H][20];
	for (int i = 0; i < H; i++) {
	    String numeral = in.next();
	    for (int j = 0; j < 20; j++) {
		tmp[i][j] = numeral.substring(L * j, L * (j + 1));
	    }
	}

	for (int i = 0; i < 20; i++) {
	    List<String> l = new ArrayList<String>();
	    for (int j = 0; j < H; j++) {
		l.add(tmp[j][i]);
	    }
	    map.put((ArrayList<String>) l, i + 1);
	}

	int S1 = in.nextInt();
	for (int i = 0; i < S1; i++) {
	    String num1Line = in.next();
	}
	int S2 = in.nextInt();
	for (int i = 0; i < S2; i++) {
	    String num2Line = in.next();
	}
	String operation = in.next();

	// Write an action using System.out.println()
	// To debug: System.err.println("Debug messages...");

	System.out.println("result");
    }
}