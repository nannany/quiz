package quiz.topcoder.srm712;

import java.util.Arrays;
import java.util.Scanner;

public class m500 {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String s = sc.next();

	String[] ans = MakePalindrome.constructMinimal(s);
	System.out.println(Arrays.toString(ans));

    }
}
