package tryAny.stream;

import java.util.stream.Stream;

public class StreamTest7 {
    public static void main(String[] args) {
	Stream<Integer> s = Stream.of(1, 2, 3);
	System.out.println(s.reduce((v1, v2) -> v1 * v2).get());
    }
}
