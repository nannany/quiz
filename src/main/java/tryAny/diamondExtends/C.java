package tryAny.diamondExtends;

public interface C extends A {
    default void x() {
	System.out.println("I am C.");
    }
}
