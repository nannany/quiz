package quiz.challengeBook.fenceRepair_poj3253;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	long L[] = new long[N];
	for (int i = 0; i < N; i++) {
	    L[i] = sc.nextInt();
	}
	Arrays.sort(L);

	long ans = 0;
	while (N > 1) {
	    long mii1 = 0, mii2 = 1;
	    if (L[(int) mii2] < L[(int) mii1]) {
		long tmp = mii2;
		mii2 = mii1;
		mii1 = tmp;
	    }

	    for (int i = 2; i < N; i++) {
		if (L[i] < L[(int) mii1]) {
		    mii2 = mii1;
		    mii1 = i;
		} else if (L[i] < L[(int) mii2]) {
		    mii2 = i;
		}
	    }

	    long t = L[(int) mii1] + L[(int) mii2];
	    ans += t;

	    if (mii1 == N - 1) {
		long tmp = mii2;
		mii2 = mii1;
		mii1 = tmp;
	    }
	    L[(int) mii1] = t;
	    L[(int) mii2] = L[N - 1];
	    N--;
	}
	System.out.println(ans);
	sc.close();
    }
}
