package quiz.challengeBook.jackStraws_poj1127;

import java.util.Scanner;

public class Main {
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

    static boolean onSeg(P p1, P p2, P q) {
	return (p1.minus(q).det(p2.minus(q))) == 0 && (p1.minus(q).dot(p2.minus(q))) <= 0;
    }

    static P intersection(P p1, P p2, P q1, P q2) {
	return (p2.minus(p1)).multi((q2.minus(q1).det(q1.minus(p1))) / (q2.minus(q1).det(p2.minus(p1)))).plus(p1);
    }

    static int n, m;
    static P[] p, q;
    static int[] a, b;
    static boolean[][] g;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
	    n = sc.nextInt();
	    if (n == 0) {
		return;
	    }
	    p = new P[n];
	    q = new P[n];
	    a = new int[n * n];
	    b = new int[n * n];
	    g = new boolean[n][n];

	    for (int i = 0; i < n; i++) {
		p[i] = new P(sc.nextInt(), sc.nextInt());
		q[i] = new P(sc.nextInt(), sc.nextInt());
	    }
	    flag1: for (int i = 0;; i++) {
		m = i;
		int tmpA = sc.nextInt();
		int tmpB = sc.nextInt();
		if (tmpA == 0 && tmpB == 0) {
		    break flag1;
		}
		a[i] = tmpA;
		b[i] = tmpB;
	    }
	    for (int i = 0; i < n; i++) {
		g[i][i] = true;
		for (int j = 0; j < i; j++) {
		    // 平行か否か
		    if ((p[i].minus(q[i]).det(p[j].minus(q[j]))) == 0) {
			g[i][j] = g[j][i] = onSeg(p[i], q[i], p[j]) || onSeg(p[i], q[i], q[j])
				|| onSeg(p[j], q[j], p[i]) || onSeg(p[j], q[j], q[i]);
		    } else {
			P r = intersection(p[i], q[i], p[j], q[j]);
			g[i][j] = g[j][i] = onSeg(p[i], q[i], r) && onSeg(p[j], q[j], r);
		    }
		}
	    }

	    for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < n; j++) {
			g[i][j] |= g[i][k] && g[k][j];
		    }
		}
	    }

	    for (int i = 0; i < m; i++) {
		System.out.println(g[a[i] - 1][b[i] - 1] ? "CONNECTED" : "NOT CONNECTED");
	    }
	}
    }
}
