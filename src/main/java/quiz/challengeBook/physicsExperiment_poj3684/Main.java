package quiz.challengeBook.physicsExperiment_poj3684;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static int H;
    static int R;
    static int T;
    static double t;
    static double g = 10.0;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int C = sc.nextInt();
	for (int i = 0; i < C; i++) {
	    N = sc.nextInt();
	    H = sc.nextInt();
	    R = sc.nextInt();
	    T = sc.nextInt();

	    t = Math.sqrt(2 * H / g);

	    List<Double> tmpList = new ArrayList<Double>();
	    for (int j = 0; j < N; j++) {
		tmpList.add(getHeight(T - j));
	    }

	    for (int k = 0; k < N; k++) {
		double tmp = tmpList.get(0);
		for (int j = 1; j < N; j++) {
		    if (tmpList.get(j) < tmp) {
			tmpList.set(j - 1, tmpList.get(j));
			tmpList.set(j, tmp);
		    } else {
			tmp = tmpList.get(j);
		    }
		}
	    }

	    for (int j = 0; j < N; j++) {
		System.out.printf("%.2f%c", tmpList.get(j).doubleValue() + 2 * R * j / 100.0, j == N - 1 ? '\n' : ' ');
	    }
	}
	sc.close();
    }

    static double getHeight(int time) {
	if (time < 0)
	    return H;
	int k = (int) (time / t);
	if (k % 2 == 0) {
	    return H - g * Math.pow((time - (k * t)), 2) / 2;
	} else {
	    return H - g * Math.pow(((k * t) - time + t), 2) / 2;
	}
    }
}
