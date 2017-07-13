package quiz.challengeBook.beautyContest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int N;
    static P[] ps;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	ps = new P[N];
	for (int i = 0; i < N; i++) {
	    ps[i] = new P(sc.nextInt(), sc.nextInt());
	}

	P[] qs = convexHull(ps, N);
	double res = 0;
	for (int i = 0; i < qs.length; i++) {
	    for (int j = 0; j < i; j++) {
		res = Math.max(res, dist(qs[i], qs[j]));
	    }
	}
	System.out.printf("%.0f", res);
    }

    static class cmpX implements Comparator<P> {
	public int compare(P p, P q) {
	    if (q.x - p.x > 0) {
		return 1;
	    } else if (q.x - p.x == 0) {
		return 0;
	    } else {
		return -1;
	    }
	}
    }

    static P[] convexHull(P[] ps, int n) {
	Arrays.sort(ps, new cmpX());
	int k = 0;
	P[] qs = new P[n * 2];

	for (int i = 0; i < n; i++) {
	    while (k > 1 && (qs[k - 1].minus(qs[k - 2])).det(ps[i].minus(qs[k - 1])) <= 0) {
		k--;
	    }
	    qs[k++] = ps[i];
	}

	for (int i = n - 2, t = k; i >= 0; i--) {
	    while (k > t && (qs[k - 1].minus(qs[k - 2]).det(ps[i].minus(qs[k - 1]))) <= 0) {
		k--;
	    }
	    qs[k++] = ps[i];
	}

	P[] ret = Arrays.copyOf(qs, k);
	return ret;
    }

    static double dist(P p, P q) {
	return (p.minus(q).dot(p.minus(q)));
    }

    static final double EPS = 1e-10;

    static double add(double a, double b) {
	if (Math.abs(a + b) < EPS * (Math.abs(a) + Math.abs(b))) {
	    return 0;
	}
	return a + b;
    }

    static class P {
	double x, y;

	public P() {
	};

	public P(double x, double y) {
	    this.x = x;
	    this.y = y;
	}

	P plus(P p) {
	    return new P(add(this.x, p.x), add(this.y, p.y));
	}

	P minus(P p) {
	    return new P(add(this.x, -p.x), add(this.y, -p.y));
	}

	P multi(double d) {
	    return new P(this.x * d, this.y * d);
	}

	// 内積
	double dot(P p) {
	    return add(x * p.x, y * p.y);
	}

	// 外積
	double det(P p) {
	    return add(x * p.y, -y * p.x);
	}
    }

}
