package tryAny.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest2 {
    public static void main(String[] args) {
	Supplier<String> s = () -> "supplier";
	Predicate<String> p = str -> "supplier".equals(str);
	Consumer<String> c = str -> System.out.println(str);
	Function<String, Integer> f = str -> str.length();

	// "supplier" の文字数だす。
	if (p.test(s.get())) {
	    c.accept(f.apply(s.get()).toString());
	}
    }
}
