package quiz.challengeBook.cableMaster_poj1064;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int K = sc.nextInt();

	List<Double> L = new ArrayList<Double>();
	for (int i = 0; i < N; i++) {
	    L.add(sc.nextDouble());
	}

	double lb = 0;
	double sum = 0;
	for (Double l : L) {
	    sum += l.intValue();
	}

	double ub = sum / K;

	// while (ub - lb > 0.01) {
	for (int i = 0; i < 100; i++) {
	    double mid = (ub + lb) / 2;
	    int count = 0;
	    for (Double l : L) {
		if (count >= K) {
		    break;
		}
		count += l.intValue() / mid;
	    }
	    if (count < K) {
		ub = mid;
	    } else {
		lb = mid;
	    }
	}
	BigDecimal ans = new BigDecimal(ub);
	ans = ans.setScale(2, BigDecimal.ROUND_FLOOR);

	System.out.println(ans);
    }
}
