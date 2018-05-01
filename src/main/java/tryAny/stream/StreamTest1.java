package tryAny.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
	String[] strAry = { "a", "b", "c" };
	Stream<String> strStream = Arrays.stream(strAry);
	strStream.forEach(System.out::println);

	int[] intAry = { 1, 2, 3, 4, 5 };
	IntStream intStream = Arrays.stream(intAry);
	intStream.forEach(System.out::println);
	/**
	 * 1</br>
	 * 2</br>
	 * 3</br>
	 * 4</br>
	 * 5
	 */

	IntStream intStream2 = Arrays.stream(intAry, 2, 4);
	intStream2.forEach(System.out::println);
	/**
	 * 3</br>
	 * 4
	 */

	IntStream.range(0, 4).forEach(System.out::print);// 0123
	IntStream.rangeClosed(0, 4).forEach(System.out::print);// 01234

    }
}
