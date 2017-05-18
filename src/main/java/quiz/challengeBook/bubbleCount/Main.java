package quiz.challengeBook.bubbleCount;

import java.util.Scanner;

public class Main {
    static int[] bit;
    static int n;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();
	bit = new int[n + 1];
	int[] a = new int[n];
	for (int i = 0; i < n; i++) {
	    a[i] = sc.nextInt();
	}

	long ans = 0;
	for (int j = 0; j < n; j++) {
	    ans += j - sum(a[j]);
	    add(a[j], 1);
	    for (int i = 0; i < bit.length; i++) {
		System.out.print(i != bit.length - 1 ? bit[i] : bit[i] + "\r\n");
	    }
	}
	System.out.println(ans);
    }

    static int sum(int i) {
	int s = 0;
	while (i > 0) {
	    s += bit[i];
	    i -= i & -i;
	}
	return s;
    }

    static void add(int i, int x) {
	while (i <= n) {
	    bit[i] += x;
	    i += i & -i;
	}
    }

}
