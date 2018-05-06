package tryAny.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleTest2 {
    public static void main(String[] args) {
	// test_ja_JP.properties に fruit=banana
	ResourceBundle rb1 = ResourceBundle.getBundle("test");
	System.out.println(rb1.getString("fruit"));// banana

	// test_en_US.properties に fruit=apple
	ResourceBundle rb2 = ResourceBundle.getBundle("test", Locale.US);
	System.out.println(rb2.getString("fruit"));// apple
    }
}
