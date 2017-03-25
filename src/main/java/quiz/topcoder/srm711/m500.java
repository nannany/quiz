package quiz.topcoder.srm711;

import java.util.Scanner;

public class m500 {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String s = sc.next();
	String t = sc.next();

	String ans = StringTransform.isPossible(s, t);
	System.out.println(ans);

    }
}
