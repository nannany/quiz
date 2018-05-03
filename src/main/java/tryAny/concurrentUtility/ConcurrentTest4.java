package tryAny.concurrentUtility;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentTest4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

	ExecutorService es = Executors.newFixedThreadPool(8);
	MyCounter mc = new MyCounter();

	Future<?> ret1 = es.submit(new MyWorker(mc));
	Future<?> ret2 = es.submit(new MyWorker(mc));

	ret1.get();
	ret2.get();
	es.shutdown();

	// ばらつく
	mc.show();

    }
}

class MyCounter {
    private int count = 0;

    public void increment() {
	count++;
    }

    public void show() {
	System.out.println("intの場合：" + count);
    }
}

class MyWorker implements Runnable {
    private static final int NUM_LOOP = 100000;
    private final MyCounter counter;

    MyWorker(MyCounter counter) {
	this.counter = counter;
    }

    @Override
    public void run() {
	for (int i = 0; i < NUM_LOOP; i++) {
	    counter.increment();
	}
    }
}