package quiz.challengeBook.woodenStick_poj1065;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int dp[];

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();

	for (int i = 0; i < T; i++) {
	    int n = sc.nextInt();
	    dp = new int[n];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    Pair[] pairs = new Pair[n];
	    for (int j = 0; j < n; j++) {
		int l = sc.nextInt();
		int w = sc.nextInt();
		pairs[j] = new Pair(l, w);
	    }
	    sort(pairs);
	    System.out.println(count(pairs));
	}
	sc.close();
    }

    static class Pair {
	int w;
	int l;

	public Pair(int l, int w) {
	    this.w = w;
	    this.l = l;
	}

	public String toString() {
	    return "l:[" + l + "] w:[" + w + "]";
	}
    }

    // pairs を第１キーlength、第2キーweightで昇順に並べ替える。
    static void sort(Pair[] pairs) {
	for (int i = 0; i < pairs.length; i++) {
	    for (int k = i + 1; k < pairs.length; k++) {
		if (pairs[k].l < pairs[i].l) {
		    Pair tmpPair = pairs[k];
		    pairs[k] = pairs[i];
		    pairs[i] = tmpPair;
		} else if (pairs[k].l == pairs[i].l) {
		    if (pairs[k].w < pairs[i].w) {
			Pair tmpPair = pairs[k];
			pairs[k] = pairs[i];
			pairs[i] = tmpPair;
		    }
		}
	    }
	}
    }

    static int count(Pair[] pairs) {
	int count = 0;
	for (int i = 0; i < dp.length; i++) {
	    for (int j = 0; j < dp.length; j++) {
		if (pairs[i].w < dp[j] && j == 0) {
		    shift(pairs[i].w);
		    count++;
		} else if (pairs[i].w < dp[j]) {
		    dp[j - 1] = pairs[i].w;
		    break;
		}
	    }
	}
	return count;
    }

    static void shift(int w) {
	for (int i = dp.length - 1; 0 < i; i--) {
	    dp[i] = dp[i - 1];
	}
	dp[0] = w;
    }
}
