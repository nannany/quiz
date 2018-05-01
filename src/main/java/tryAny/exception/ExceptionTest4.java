package tryAny.exception;

public class ExceptionTest4 {
    public static void main(String[] args) {
	int x = 1;

	assert (x == 2) : "Error Message出すで！";
	/**
	 * VM引数に-eaを入れてやると、以下のエラーが出る。
	 *
	 * Exception in thread "main" java.lang.AssertionError: Error Message出すで！
	 * at tryAny.exception.ExceptionTest4.main(ExceptionTest4.java:7)
	 *
	 */
    }
}
