package tryAny;

public class Lambda3 {
    public static void main(String[] args) {
	String val = "aaa";
	// ラムダ式内でローカル変数を参照することは可能。書き換えは不可
	Runnable r = () -> {
	    System.out.println(val);
	};

	r.run();
    }
}
