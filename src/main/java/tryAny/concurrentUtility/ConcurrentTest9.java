package tryAny.concurrentUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ConcurrentTest9 {
    public static void main(String[] args) {

        Runnable runner = new Runner();
        CyclicBarrier barrier = new CyclicBarrier(3, runner);

        List<Worker> workers = new ArrayList<Worker>();
        for (int i = 0; i < 3; i++) {
            workers.add(new Worker(barrier));
        }

        workers.stream().parallel().forEach(Worker::run);
        /**
         * 1<br>
         * 2<br>
         * 3<br>
         * All threads have run.
         *
         * 1,2,3の部分はそうならないこともある。1,2,1とかなったりする。
         */
    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        System.out.println("All threads have run.");
    }
}

class Worker extends Thread {
    private CyclicBarrier barrier;

    private static int count;

    public Worker(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(++count);
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}