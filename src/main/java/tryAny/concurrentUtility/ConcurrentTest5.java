package tryAny.concurrentUtility;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentTest5 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

	ExecutorService es = Executors.newFixedThreadPool(8);
	MyAtomCounter mac = new MyAtomCounter();

	Future<?> ret1 = es.submit(new MyAtomWorker(mac));
	Future<?> ret2 = es.submit(new MyAtomWorker(mac));

	ret1.get();
	ret2.get();
	es.shutdown();

	// 確実に200000になる。
	mac.show();

    }
}

class MyAtomCounter {
    private AtomicInteger count = new AtomicInteger();

    public void increment() {
	count.incrementAndGet();
    }

    public void show() {
	System.out.println("AtomicIntegerの場合：" + count);
    }
}

class MyAtomWorker implements Runnable {
    private static final int NUM_LOOP = 100000;
    private final MyAtomCounter counter;

    MyAtomWorker(MyAtomCounter counter) {
	this.counter = counter;
    }

    @Override
    public void run() {
	for (int i = 0; i < NUM_LOOP; i++) {
	    counter.increment();
	}
    }
}
