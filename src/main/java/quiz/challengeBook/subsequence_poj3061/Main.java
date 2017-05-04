package quiz.challengeBook.subsequence_poj3061;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int caseNo = sc.nextInt();
	for (int i = 0; i < caseNo; i++) {
	    int n = sc.nextInt();
	    int S = sc.nextInt();
	    int[] a = new int[n];
	    for (int j = 0; j < n; j++) {
		a[j] = sc.nextInt();
	    }

	    int res = n + 1;
	    int s = 0;
	    int t = 0;
	    int sum = 0;
	    while (true) {
		while (t < n && sum < S) {
		    sum += a[t++];
		}
		if (sum < S) {
		    break;
		}
		res = Math.min(res, t - s);
		sum -= a[s++];
	    }

	    if (n < res) {
		res = 0;
	    }
	    System.out.println(res);
	}
    }
}
