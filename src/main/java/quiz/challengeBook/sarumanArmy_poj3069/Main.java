package quiz.challengeBook.sarumanArmy_poj3069;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
	    int R = sc.nextInt();
	    int N = sc.nextInt();
	    if (R == -1 && N == -1) {
		break;
	    }
	    int[] x = new int[N];
	    for (int i = 0; i < N; i++) {
		x[i] = sc.nextInt();
	    }
	    Arrays.sort(x);

	    int count = 0;
	    int include = 0;

	    while (include < N) {
		int tmpEnd = x[include] + R;
		for (int i = include + 1; i < N; i++) {
		    if (x[i] <= tmpEnd) {
			include++;
		    } else {
			break;
		    }
		}
		include++;
		count++;
	    }
	    System.out.println(count);
	}
    }
}
