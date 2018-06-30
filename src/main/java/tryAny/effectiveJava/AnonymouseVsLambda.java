package tryAny.effectiveJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymouseVsLambda {
    public static void main(String[] args) {
        List<String> words1 = Arrays.asList("apple", "pen", "pineapple");
        // 匿名クラスで書く。
        Collections.sort(words1, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println(words1);

        // 型をRawにするとコンパイルエラーとなる。
        List<String> words2 = Arrays.asList("banana", "grape", "melon");
        // ラムダ式で書く。
        Collections.sort(words2, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(words2);
    }
}
