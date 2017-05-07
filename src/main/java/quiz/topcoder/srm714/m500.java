package quiz.topcoder.srm714;

import java.util.Scanner;

public class m500 {
    public static void main(String[] args) {
	RemovingParenthesis rp = new RemovingParenthesis();
	Scanner sc = new Scanner(System.in);
	System.out.println(rp.countWays(sc.next()));
	sc.close();
    }
}
