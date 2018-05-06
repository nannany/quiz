package tryAny.locale;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LocaleTest1 {
    public static void main(String[] args) {

	try (InputStream is = new FileInputStream("test.properties");
		InputStream is2 = new FileInputStream("test2.properties")) {
	    Properties p = new Properties();
	    p.load(is);
	    p.list(System.out);
	    System.out.println("★" + p.getProperty("fruit") + "★");

	    // ここでのロードは上書きでなく、追記のよう。
	    p.loadFromXML(is2);
	    p.forEach((k, v) -> System.out.println(k + "=" + v));
	    System.out.println("★" + p.getProperty("hoge") + "★");

	    /**
	     * -- listing properties --</br>
	     * fruit=apple</br>
	     * vegitable=carot</br>
	     * ★apple★</br>
	     * vegitable=carot</br>
	     * hoge=ほげ</br>
	     * fuga=ふが</br>
	     * fruit=apple</br>
	     * piyo=ぴよ</br>
	     * ★ほげ★</br>
	     *
	     */
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
