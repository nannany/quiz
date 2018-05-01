package tryAny.stream;

import java.util.stream.Stream;

public class StreamTest4 {
    public static void main(String[] args) {
	Stream<String> s = Stream.of("north", "south", "west", "east");
	long l = s.sorted(String.CASE_INSENSITIVE_ORDER)
		.peek(System.out::println)
		.map(String::toUpperCase)
		.peek(System.out::println).count();
    }
}
