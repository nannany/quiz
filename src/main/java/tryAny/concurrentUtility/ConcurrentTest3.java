package tryAny.concurrentUtility;

import java.util.concurrent.CompletableFuture;

public class ConcurrentTest3 {
    private static class Worker {
	public String exec() {
	    emulateLongTask();
	    return "JAPAN";
	}

	public Integer aggregate(String input) {
	    return input.length();
	}

	public void showResult(Integer result, Throwable error) {
	    if (error != null) {
		System.out.println("error");
		return;
	    }
	    System.out.println("ret=" + result);
	}

	private void emulateLongTask() {
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {

	    }
	}
    }

    public static void main(String[] args) {
	Worker w = new Worker();
	CompletableFuture<Integer> future = CompletableFuture.supplyAsync(w::exec)
		.thenComposeAsync(s -> CompletableFuture.supplyAsync(w::exec))
		.thenApplyAsync(w::aggregate)
		.whenCompleteAsync(w::showResult);

	future.join();
    }
}
