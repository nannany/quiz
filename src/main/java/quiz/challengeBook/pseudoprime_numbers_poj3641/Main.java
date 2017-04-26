package quiz.challengeBook.pseudoprime_numbers_poj3641;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
	    int p = sc.nextInt();
	    int a = sc.nextInt();
	    if (p == 0 && a == 0)
		break;

	    if (!isPrime(p) && modPow(a, p, p) == a) {
		System.out.println("yes");
	    } else {
		System.out.println("no");
	    }
	}
	sc.close();

    }

    static long modPow(long x, long n, long mod) {
	long res = 1;
	while (n > 0) {
	    if ((n & 1) == 1) {
		res = res * x % mod;
	    }
	    x = x * x % mod;

	    n >>= 1;
	}

	return res;
    }

    static boolean isPrime(long x) {
	for (int i = 2; i <= Math.sqrt(x); i++) {
	    if (x % i == 0)
		return false;
	}
	return true;
    }
}
