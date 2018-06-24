package tryAny.lambda;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LambdaTest4 {
    public static void main(String[] args) {
        int[][] data = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        IntStream s1 = Arrays.stream(data).flatMapToInt(Arrays::stream);
        s1.forEach(System.out::print);// 123456
    }
}
