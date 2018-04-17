package tryAny.diamondExtends;

public interface A {
    default void x() {
	System.out.println("I am A.");
    }
}
