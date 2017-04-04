package quiz.challengeBook.cowBowling_poj3176;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int line[][] = new int[N][N];
	sc.nextLine();
	for (int i = 0; i < N; i++) {
	    String[] tmp = sc.nextLine().split(" ");
	    for (int j = 0; j <= i; j++) {
		line[i][j] = Integer.parseInt(tmp[j]);
	    }
	}
	System.out.println(Arrays.toString(line[0]));


    }
}
