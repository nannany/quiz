package quiz.pQuiz.d.goShrine;

import java.util.Scanner;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int L = sc.nextInt();
	int M = sc.nextInt();
	int N = sc.nextInt();

	StringBuilder sb = new StringBuilder();

	BiConsumer<Integer, String> mojiCreator = (kazu, moji) -> {
	    for (int i = 0; i < kazu; i++) {
		sb.append(moji);
	    }
	};
	mojiCreator.accept(L, "A");
	mojiCreator.accept(M, "B");
	mojiCreator.accept(N, "A");

	System.out.println(mojiCreator.toString());
    }
}
