package tryAny.concurrentUtility;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// １秒ごとにランダム値を生成し続ける。
public class ConcurrentTest6 {
    public static void main(String[] args) {
	ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(1);

	ScheduledFuture<?> sf = stpe.scheduleAtFixedRate(new Runnable() {
	    @Override
	    public void run() {
		System.out.println(Math.random());
	    }
	}, 1000, 1000, TimeUnit.MILLISECONDS);

	while (true) {
	    if (sf.isCancelled() || sf.isDone()) {
		stpe.shutdown();
		break;
	    }
	}
    }
}
