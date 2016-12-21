package util;

import java.util.Scanner;

// 標準入力に暗号文入れてカエサル暗号読解（コンマとか入ったら無理）
public class CaesarCryUtil {
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String crypt = scan.next();
	String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
		"s", "t", "u", "v", "w", "x", "y", "z" };
	for (int i = 1; i < 26; i++) {
	    String[] ele = new String[crypt.length()];
	    for (int j = 0; j < crypt.length(); j++) {
		char c = crypt.charAt(j);
		int numAlp = -1;
		for (int k = 0; k < 26; k++) {
		    if (String.valueOf(c).equals(alphabet[k])) {
			numAlp = k;
		    }
		}
		if (i + numAlp > 25) {
		    ele[j] = alphabet[i + numAlp - 26];
		} else {
		    ele[j] = alphabet[i + numAlp];
		}
	    }
	    System.out.println(i + ":" + String.join("", ele));
	}
    }
}
