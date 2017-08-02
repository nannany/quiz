package quiz.challengeBook.euclidsGame_poj2348;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
	    int a = sc.nextInt();
	    int b = sc.nextInt();
	    if (a == 0 && b == 0) {
		break;
	    }
	    boolean f = true;
	    while (true) {
		if (a > b) {
		    int tmp = a;
		    a = b;
		    b = tmp;
		}
		if (b % a == 0) {
		    break;
		}
		if (a < b - a) {
		    break;
		}
		b -= a;
		f = !f;
	    }

	    if (f) {
		System.out.println("Stan wins");
	    } else {
		System.out.println("Ollie wins");
	    }
	}
    }
}
