package quiz.topcoder.srm712;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakePalindrome {
    public static String[] constructMinimal(String card) {
	String[] letters = card.split("");

	List<String> strList = new ArrayList<String>();

	for (int i = 0; i < card.length(); i++) {
	    strList.add(letters[i]);
	}
	Set<String> set = new HashSet<>(strList);
	List<String> strList2 = new ArrayList<>(set);
	List<Letter> letterList = new ArrayList<Letter>();
	for (String str : strList2) {
	    int count = 0;
	    for (int i = 0; i < letters.length; i++) {
		if (letters[i].equals("str")) {
		    count++;
		}
	    }
	    Letter letter = new Letter(str, count);
	    letterList.add(letter);
	}

	int ansCount = 0;
	for (Letter letter : letterList) {
	    if (letter.count % 2 == 1) {
		ansCount++;
	    }
	}

	String ans[] = new String[ansCount];

	for (Letter letter : letterList) {
	    String tmp = "";
	    boolean flg = true;
	    if (letter.count % 2 == 0) {
		for (int i = 0; i < letter.count / 2; i++) {
		    tmp = letter.str + tmp + letter.str;
		}
	    }else if(flg){
		flg = false;
	    }
	}
    }

    static class Letter {
	String str;
	int count;

	Letter(String str, int count) {
	    this.str = str;
	    this.count = count;
	}
    }
}
