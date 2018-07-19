package tryAny.effectiveJava;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Callable<String>> tasks = Arrays.asList(() -> "first", () -> "second");

        ExecutorService es = Executors.newFixedThreadPool(2);
        List<Future<String>> rets = es.invokeAll(tasks);

        for (Future<String> r : rets) {
            System.out.println(r.get());
        }

        System.out.println(es.invokeAny(tasks));// first か second ランダムで

    }
}
