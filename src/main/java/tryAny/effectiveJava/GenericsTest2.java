package tryAny.effectiveJava;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest2 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // Has compiler-generated cast
    }

    private static void unsafeAdd(List list, Object o) {
        // 以下のコードにするとコンパイルエラーにしてくれる。
        // private static void unsafeAdd(List<Object> list, Object o) {
        list.add(o);
    }

}
