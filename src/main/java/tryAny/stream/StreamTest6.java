package tryAny.stream;

import java.util.HashMap;
import java.util.Map;

public class StreamTest6 {
    public static void main(String[] args) {
	Map<String, Integer> m = new HashMap<>();
	m.put("A", 1);
	m.merge("A", 2, (v1, v2) -> v1 * v2);
	m.merge("b", 1, (v1, v2) -> v1 * v2);

	System.out.println(m);
	// {A=2, b=1}

    }
}