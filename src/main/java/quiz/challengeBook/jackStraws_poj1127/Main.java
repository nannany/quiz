package quiz.challengeBook.jackStraws_poj1127;

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



    static int n, m;

    public static void main(String[] args) {

    }
}
