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
		if (letters[i].equals(str)) {
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
	String tmp = "";
	// 文字数が偶数のもののみで組み立てる
	for (Letter letter : letterList) {
	    if (letter.count % 2 == 0) {
		for (int i = 0; i < letter.count / 2; i++) {
		    tmp = letter.str + tmp + letter.str;
		}
	    }
	}
	if (ansCount == 0) {
	    String[] ansOnlyEven = new String[1];
	    ansOnlyEven[0] = tmp;
	    return ansOnlyEven;
	}
	List<String> oddList = new ArrayList<String>();
	for (Letter letter : letterList) {
	    if (letter.count % 2 == 1) {
		String tmpOdd = "";
		for (int i = 0; i < letter.count; i++) {
		    tmpOdd += letter.str;
		}
		oddList.add(tmpOdd);
	    }
	}
	String ans = tmp.substring(0, tmp.length() / 2) + oddList.get(0) + tmp.substring(tmp.length() / 2);
	String[] ansArray = new String[ansCount];
	ansArray[0] = ans;
	for (int i = 1; i < ansCount; i++) {
	    ansArray[i] = oddList.get(i);
	}
	return ansArray;
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
