package tryAny.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest5 {
    public static void main(String[] args) {
	List<List<String>> l = Arrays.asList(Arrays.asList("banana", "apple"), Arrays.asList("banana", "orange"));

	l.stream().flatMap(li -> li.stream()).distinct().forEach(System.out::println);

	List<List<List<String>>> l2 = Arrays.asList(Arrays.asList(Arrays.asList("pineapple", "grape")));

	l2.stream().flatMap(li2 -> li2.stream()).flatMap(li3 -> li3.stream()).forEach(System.out::println);
    }
}
