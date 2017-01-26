package quiz.pQuiz.c.anime;

import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String line = sc.nextLine();

	String month = line.substring(0, 2);
	int day = Integer.parseInt(line.substring(3, 5));
	int hour = Integer.parseInt(line.substring(6, 8));
	String minutes = line.substring(9, 11);

	String newDay = String.valueOf(day + hour / 24);
	String newHour = String.valueOf(hour % 24);

	Function<String, String> f = s -> {
	    if (s.length() == 1) {
		return "0" + s;
	    } else {
		return s;
	    }
	};

	StringBuilder sb = new StringBuilder();

	sb.append(month);
	sb.append("/");
	sb.append(f.apply(newDay));
	sb.append(" ");
	sb.append(f.apply(newHour));
	sb.append(":");
	sb.append(minutes);

	System.out.println(sb.toString());
    }
}
