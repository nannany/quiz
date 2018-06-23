package tryAny.lambda;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class LambdaTest3 {
    public static void main(String[] args) {
        IntStream s1 = IntStream.of(1, 2, 3);
        IntFunction<IntUnaryOperator> func = x -> y -> x + y;

        IntStream s2 = s1.map(func.apply(2));
        s2.forEach(System.out::println);
    }
}
