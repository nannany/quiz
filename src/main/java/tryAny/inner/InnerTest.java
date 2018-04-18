package tryAny.inner;

public class InnerTest {
    class InnerA {
	void innerMethod() {
	    System.out.println("I am inner.");
	}
    }

    private void execInner() {
	InnerA ia = new InnerA();
	ia.innerMethod();
    }

    public static void main(String[] args) {
	InnerTest it = new InnerTest();
	it.execInner();
    }
}
