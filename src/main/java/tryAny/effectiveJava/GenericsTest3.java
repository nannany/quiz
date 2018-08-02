package tryAny.effectiveJava;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenericsTest3 {

    public static void main(String[] args) {
        Set<?> s1 = Stream.of("2", "b", 1).collect(Collectors.toSet());
        Set s2 = Stream.of("2", "c", 1).collect(Collectors.toSet());

        // s1.add("c"); // このコードはコンパイルエラーとなる
        s2.add("b");

        // if (s2 instanceof Set<String>) { //このコードはコンパイルエラーとなる
        if (s2 instanceof Set || s2 instanceof Set<?>) {
            System.out.println("★");
        }

        System.out.println(numElementsInCommon(s1, s2));

        Set<String> s = new HashSet();
    }

    // Use of raw type for unknown element type - don't do this!
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }
}
