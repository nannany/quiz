package quiz.challengeBook.asteroids_poj3041;

import java.util.Scanner;

public class Main {
    static int N,K;
    static int[] R,C;
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	K = sc.nextInt();
	R = new int[K];
	C = new int[K];
	for(int i = 0;i<K;i++){
	    R[i]  = sc.nextInt();
	    C[i] = sc.nextInt();
	}
    }
}
