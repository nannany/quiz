package tryAny;

public class Lambda {
    public static void main(String[] args) {
	FI t = (a) -> {
	    System.out.println(a);
	};

	tmp3(Lambda::参照先メソッド, "hello,world");
	tmp3(t, "receive t");
    }

    static void tmp3(FI t, String s) {
	t.tmp(s);
    }

    static void 参照先メソッド(String s) {
	System.out.println(s);
    }

    @FunctionalInterface
    interface FI {
	public void tmp(String s);
    }
}