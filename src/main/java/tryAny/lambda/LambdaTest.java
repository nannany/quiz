package tryAny.lambda;

public class LambdaTest {
    public static void main(String[] args) {
	Runnable r1 = new Runnable() {
	    public void run() {
		System.out.println("run1");
	    }
	};

	// 同じ
	Runnable r2 = () -> System.out.println("run2");

	Thread t1 = new Thread(r1);
	Thread t2 = new Thread(r2);
	t1.start();
	t2.start();
    }
}
