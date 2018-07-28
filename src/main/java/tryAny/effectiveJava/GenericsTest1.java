package tryAny.effectiveJava;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class GenericsTest1 {

    public static void main(String[] args) {
        final Collection stamps = Arrays.asList(new Stamp(), new Stamp(), "");
        // 以下のコードだとコンパイルエラーとして検出してくれる。
        // final Collection<Stamp> stamps = Arrays.asList(new Stamp(), new Stamp(), "");
        for (Iterator i = stamps.iterator(); i.hasNext();) {
            Stamp stamp = (Stamp) i.next(); // 3つ目の要素をキャストするときにエラー送出。実行時に初めてわかる。
            System.out.println("cast success");
        }
    }

    static class Stamp {

    }
}
