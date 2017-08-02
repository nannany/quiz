package quiz.challengeBook.aFunnyGame_poj2484;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while (true) {
	    int n = sc.nextInt();
	    if (n == 0) {
		break;
	    }

	    if (n <= 2) {
		System.out.println("Alice");
	    } else {
		System.out.println("Bob");

	    }
	}
    }
}
