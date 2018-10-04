package tryAny.effectiveJava;

public class BoxedPrimitive2 {
    // Hideously slow program! Can you spot the object creation?
    public static void main(String[] args) {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

}
