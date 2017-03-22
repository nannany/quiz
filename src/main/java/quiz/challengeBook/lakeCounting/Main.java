package quiz.challengeBook.lakeCounting;

import java.util.Scanner;

public class Main {
    static char[][] ground;
    static int N;
    static int M;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	M = sc.nextInt();
	sc.nextLine();

	ground = new char[N][M];
	for (int i = 0; i < N; i++) {
	    String tmpStr = sc.nextLine();
	    for (int j = 0; j < M; j++) {
		ground[i][j] = tmpStr.charAt(j);
	    }
	}

	int lakeCount = 0;
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < M; j++) {
		if (String.valueOf(ground[i][j]).equals("W")) {
		    Main.search(i, j);
		    lakeCount++;
		}
	    }
	}
	System.out.println(lakeCount);
    }

    public static void search(int a, int b) {
	if (String.valueOf(ground[a][b]).equals(".")) {
	    return;
	} else {
	    ground[a][b] = '.';
	    for (int dx = -1; dx <= 1; dx++) {
		for (int dy = -1; dy <= 1; dy++) {
		    int nx = a + dx, ny = b + dy;
		    if (0 <= nx && 0 <= ny && nx < N && ny < M) {
			search(nx, ny);
		    }
		}
	    }
	}
    }
}
