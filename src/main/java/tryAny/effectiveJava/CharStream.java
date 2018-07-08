package tryAny.effectiveJava;

public class CharStream {
    public static void main(String[] args) {
        "Hello, world!".chars().forEach(System.out::print);
        // 72101108108111443211911111410810033 が表示

        System.out.println();

        "Hello, world!".chars().forEach(x -> System.out.print((char) x));
        // Hello, world! が表示
    }
}
