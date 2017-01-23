package quiz.pQuiz.d.trump;

import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String firstWord = sc.next();
	String secondWord = sc.next();

	BiPredicate<String,String> p = (f, s) -> f.equals("J") && s.equals("J");

	Consumer<String> c = System.out::println;

	if (!p.test(firstWord,secondWord)) {
	    c.accept(firstWord + " " + secondWord);
	} else {
	    c.accept(firstWord + " Q");
	}
	sc.close();
    }
}
