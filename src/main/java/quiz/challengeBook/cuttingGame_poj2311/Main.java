package quiz.challengeBook.cuttingGame_poj2311;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int MAX_WH = 200;
    static int[][] mem = new int[MAX_WH + 1][MAX_WH + 1];;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
	    int W = sc.nextInt();
	    int H = sc.nextInt();
	    for (int i = 0; i < MAX_WH + 1; i++) {
		Arrays.fill(mem[i], -1);
	    }

	    if (grundy(W, H) != 0) {
		System.out.println("WIN");
	    } else {
		System.out.println("LOSE");
	    }
	}
    }

    static int grundy(int w, int h) {
	if (mem[w][h] != -1) {
	    return mem[w][h];
	}

	Set<Integer> s = new HashSet<Integer>();

	for (int i = 2; w - i >= 2; i++) {
	    s.add(grundy(i, h) ^ grundy(w - i, h));
	}
	for (int i = 2; h - i >= 2; i++) {
	    s.add(grundy(w, i) ^ grundy(w, h - i));
	}

	int res = 0;
	while (s.contains(res)) {
	    res++;
	}
	return mem[w][h] = res;
    }
}
