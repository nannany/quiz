package tryAny.concurrentUtility;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ConcurrentTest7 {
    public static void main(String[] args) throws InterruptedException {
	ForkJoinPool jfp = new ForkJoinPool();
	jfp.execute(new MyAction());
	System.out.println("①");
	Thread.sleep(3000);
	System.out.println("②");
	/**
	 * ①</br>
	 * ③</br>
	 * ②
	 */

	jfp.invoke(new MyAction());
	System.out.println("①");
	Thread.sleep(3000);
	System.out.println("②");
	/**
	 * ③</br>
	 * ①</br>
	 * ②
	 */
    }
}

class MyAction extends RecursiveAction {
    @Override
    protected void compute() {
	try {
	    Thread.sleep(2000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	System.out.println("③");
    }
}