package tryAny.effectiveJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetList {
    public static void main(String[] args) {
        Set<Integer> s = new TreeSet<>();
        List<Integer> l = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            s.add(i);
            l.add(i);
        }

        for (int i = 0; i < 3; i++) {
            s.remove(i);
            l.remove(i);
        }

        System.out.println(s + "" + l);// [-3, -2, -1] [-2, 0, 2]
    }
}
