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
		int s = x[include];
		include++;
		while (include < N && x[include] <= s + R) {
		    include++;
		}
		int p = x[include - 1];
		while (include < N && x[include] <= p + R) {
		    include++;
		}
		count++;
	    }
	    System.out.println(count);
	}
    }
}
