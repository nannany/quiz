package quiz.topcoder.srm711;

import java.util.Scanner;
public class m250 {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int a = sc.nextInt();
	int b = sc.nextInt();
	int c = sc.nextInt();
	int d = sc.nextInt();

//	int maxV = Math.max(Math.max(a, b), Math.max(c, d));
//	int minV = Math.min(Math.min(a, b), Math.min(c, d));
//	int ans = 4000000;
//	for (int i = minV; i <= maxV; i++) {
//	    int tmp = Math.abs(a - i) + Math.abs(b - i) + Math.abs(c - i) + Math.abs(d - i);
//
//	    if (tmp < ans) {
//		ans = tmp;
//	    }
//	}
	int ans = SquareMaking.getMinimalPrice(a,b,c,d);
	System.out.println(ans);

    }
}