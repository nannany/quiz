package quiz.challengeBook.bestCowLine;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();

	LinkedList<String> S = new LinkedList<String>();
	LinkedList<String> T = new LinkedList<String>();

	for (int i = 0; i < N; i++) {
	    S.add(sc.next());
	}

	while (!S.isEmpty()) {
	    if (S.getFirst().compareTo(S.getLast()) < 0) {
		T.add(S.pollFirst());
	    } else if (0 < S.getFirst().compareTo(S.getLast())) {
		T.add(S.pollLast());
	    } else {
		if (Main.frontOrBack(S, 1) < 0) {
		    T.add(S.pollFirst());
		} else {
		    T.add(S.pollLast());
		}
	    }
	}
	// System.out.println(String.join("", T));
	StringBuilder sb = new StringBuilder();
	for (String s : T) {
	    if (sb.toString().length() != 0 && sb.toString().length() % 80 == 0) {
		sb.append("\r\n");
	    }
	    sb.append(s);
	}
	System.out.println(sb.toString());
    }

    private static int frontOrBack(LinkedList<String> s, int k) {
	if (s.size() == 1 || s.size() / 2 == k) {
	    return 1;
	} else if (s.get(k).equals(s.get(s.size() - k - 1))) {
	    return Main.frontOrBack(s, k + 1);
	} else {
	    return s.get(k).compareTo(s.get(s.size() - k - 1));
	}
    }
}
