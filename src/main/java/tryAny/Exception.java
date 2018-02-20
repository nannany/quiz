package tryAny;

public class Exception {
    public static void main(String[] args) {
	int ret = test();
	System.out.println(ret); // 20
    }

    private static int test() {
	try {
	    int[] tmp = {};
	    int a = tmp[0];
	} catch (RuntimeException e) {
	    return 10;
	} finally {
	    return 20;
	}
    }

}
