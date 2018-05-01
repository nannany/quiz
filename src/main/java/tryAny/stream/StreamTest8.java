package tryAny.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest8 {
    public static void main(String[] args) {
	/**
	 * Collectors.toList()で生成されるCollectorオブジェクトは</br>
	 * 入力要素をListに蓄積する。
	 */
	List<String> l = Stream.of("paper", "book", "photo").collect(Collectors.toList());

	l.stream().forEach(System.out::println);

	// Collector<Integer,Map<String,Integer>,Map<String,List<Integer>>>
	// collector
	// = Collectors.groupingBy(Integer;]

	// 文字数毎にグルーピングする
	Map<Integer, List<String>> map = l.stream().collect(Collectors.groupingBy(e -> e.length()));
	map.forEach((v1, v2) -> System.out.println(v1 + ":" + v2));
	/**
	 * 4:[book]</br>
	 * 5:[paper, photo]
	 */

	// 頭文字後にグルーピングする
	Map<Character, List<String>> map2 = l.stream().collect(Collectors.groupingBy(e -> e.charAt(0)));
	map2.forEach((v1, v2) -> System.out.println(v1 + ":" + v2));
    }
}
