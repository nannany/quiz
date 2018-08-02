package tryAny.effectiveJava;

public class GenericsTest5 {
    public static void main(String[] args) {

        Object[] objAry = new Long[1];
        objAry[0] = "aa";

        // Won't compile!
        // List<Object> ol = new ArrayList<Long>(); // Incompatible

    }
}
