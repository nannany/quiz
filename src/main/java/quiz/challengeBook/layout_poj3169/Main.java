package quiz.challengeBook.layout_poj3169;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int ML = sc.nextInt();
	int MD = sc.nextInt();
	int[] AL = new int[ML];
	int[] BL = new int[ML];
	int[] DL = new int[ML];
	int[] AD = new int[MD];
	int[] BD = new int[MD];
	int[] DD = new int[MD];

	for (int i = 0; i < ML; i++) {
	    AL[i] = sc.nextInt();
	    BL[i] = sc.nextInt();
	    DL[i] = sc.nextInt();
	}
	for (int i = 0; i < MD; i++) {
	    AD[i] = sc.nextInt();
	    BD[i] = sc.nextInt();
	    DD[i] = sc.nextInt();
	}

	int[] d = new int[N];

	Arrays.fill(d, Integer.MAX_VALUE);

	d[0] = 0;

	for (int k = 0; k < N; k++) {
	    for (int i = 0; i + 1 < N; i++) {
		if (d[i + 1] < Integer.MAX_VALUE) {
		    d[i] = Math.min(d[i], d[i + 1]);
		}
	    }
	    for (int i = 0; i < ML; i++) {
		if (d[AL[i] - 1] < Integer.MAX_VALUE) {
		    d[BL[i] - 1] = Math.min(d[BL[i] - 1], d[AL[i] - 1] + DL[i]);
		}
	    }
	    for (int i = 0; i < MD; i++) {
		if (d[BD[i] - 1] < Integer.MAX_VALUE) {
		    d[AD[i] - 1] = Math.min(d[AD[i] - 1], d[BD[i] - 1] - DD[i]);
		}
	    }
	}

	int res = d[N - 1];
	if (d[N - 1] < 0) {
	    res = -1;
	} else if (res == Integer.MAX_VALUE) {
	    res = -2;
	}

	System.out.println(res);
    }
}
