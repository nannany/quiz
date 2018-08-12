package tryAny.effectiveJava;

import java.util.HashSet;
import java.util.Set;

public class GenericTest6 {
    // Simple program to exercise generic method
    public static void main(String[] args) {
        Set<String> guys = Set.of("Tom", "Dick", "Harry");
        Set<String> stooges = Set.of("Larry", "Moe", "Curly");
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);
    }

    private static <E> Set<E> union(Set<E> set1, Set<E> set2) {
        Set<E> ret = new HashSet<>(set1);
        ret.addAll(set2);
        return ret;
    }
}
