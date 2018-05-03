package tryAny.concurrentUtility;

public class ConcurrentTest1 extends Thread {
    private final String name;

    public ConcurrentTest1(String name) {
	this.name = name;
    }

    @Override
    public void run() {
	for (int i = 0; i < 256; i++) {
	    System.out.println(name + " " + i);
	}
    }

    public static void main(String[] args) throws InterruptedException {
	Thread t1 = new ConcurrentTest1("one");
	Thread t2 = new ConcurrentTest1("two");

	t1.start();
	t2.start();

	for (int i = 0; i < 256; i++) {
	    System.out.println("main " + i);
	}

	t1.join();
	t2.join();
    }
}
