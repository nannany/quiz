package tryAny.effectiveJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("paper", "strong", "java", "pepper");
        List<String> l2 = new ArrayList<>();

        System.out.println(max(l1).get());
        System.out.println(max(l2).orElse("no words"));
        try {
            max(l2).orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(max(l1).filter(str -> str.length() == 6).map(str -> str.toUpperCase()).get());
    }

    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        if (c.isEmpty()) {
            return Optional.empty();
        }

        E result = null;
        for (E ele : c) {
            if (result == null || ele.compareTo(result) > 0) {
                result = Objects.requireNonNull(ele);
            }
        }

        return Optional.of(result);
    }
}
