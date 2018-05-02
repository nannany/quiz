package tryAny.io;

import java.io.Console;

/**
 * eclipse上だとうまくいかない。
 *
 * @author nannany
 *
 */
public class IOTest2 {
    public static void main(String[] args) {
	Console c = System.console();
	String str = "";
	if (c != null) {
	    str = c.readLine();
	}
	System.out.println("入力した文字数は" + str.length());
    }
}
