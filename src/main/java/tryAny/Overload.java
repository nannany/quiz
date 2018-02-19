package tryAny;

public class Overload {
    public static void main(String[] args) {
	System.out.println(ret(1, 2)); // 3
	System.out.println(ret(1.0, 2));// 0
	System.out.println(ret(1, 2.0));// 2

    }

    private static String ret(int a, int b) {
	return Integer.toString(a + b);
    }

    private static int ret(int a, double b) {
	return a * (int) b;
    }

    private static int ret(double a, int b) {
	return (int) a / b;
    }
}
