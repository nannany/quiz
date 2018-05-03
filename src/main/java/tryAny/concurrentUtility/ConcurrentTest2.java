package tryAny.concurrentUtility;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentTest2 {
    private static class Worker1 implements Runnable {
	private final String name;

	public Worker1(String name) {
	    this.name = name;
	}

	@Override
	public void run() {
	    for (int i = 0; i < 256; i++) {
		System.out.println(name + " " + i);
	    }
	}
    }

    private static class Worker2 implements Callable<String> {
	private final String name;

	public Worker2(String name) {
	    this.name = name;
	}

	@Override
	public String call() {
	    return name;
	}
    }

    public static void main(String[] args) throws Exception {
	ExecutorService es = Executors.newFixedThreadPool(8);

	es.execute(new Worker1("run1"));
	es.execute(new Worker1("run2"));

	Future<String> ret1 = es.submit(new Worker2("call1"));
	Future<String> ret2 = es.submit(new Worker2("call2"));

	for (int i = 0; i < 256; i++) {
	    System.out.println("main " + i);
	}

	System.out.println(ret1.get());
	System.out.println(ret2.get());

	es.shutdown();

    }
}
