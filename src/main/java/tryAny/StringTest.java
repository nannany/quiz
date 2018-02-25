package tryAny;

public class StringTest {
    public static void main(String[] args) {
	String tmp = null;
	System.out.println(tmp + "a"); // nulla
	try {
	    System.out.println(tmp.concat("a"));// ヌルぽが出る
	} catch (NullPointerException e) {
	    System.out.println("ヌルぽ発生");
	}

	StringBuilder sb = new StringBuilder();
	System.out.println(sb.capacity());// 16

	char[] char1 = { 'a', 'b', 'c', 'd' };
	System.out.println(sb.append(char1));// abcd
    }
}
