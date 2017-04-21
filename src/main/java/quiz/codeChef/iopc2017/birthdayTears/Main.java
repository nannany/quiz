package quiz.codeChef.iopc2017.birthdayTears;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for (int i = 0; i < T; i++) {
	    String S = sc.next();
	    Queue<String> que = new LinkedList<String>();
	    que.add(S);
	    String ans = "";
	    while (!que.isEmpty()) {
		String tmp = que.poll();
		if (Arrays.stream(tmp.split("")).distinct().count() == 1) {
		    ans = tmp;
		    break;
		}
		if (tmp.length() % 2 == 0) {
		    que.add(tmp.substring(0, tmp.length() / 2));
		    que.add(tmp.substring(tmp.length() / 2));
		}
	    }
	    if ("".equals(ans)) {
		System.out.println(-1);
	    } else {
		int cal = (int) (Math.log(S.length() / ans.length()) / Math.log(2));
		System.out.println(cal);
	    }
	}
    }
}
