package tryAny.effectiveJava;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.time.StopWatch;

public class RandomTest {
    public static void main(String[] args) {
	int n = 2 * (Integer.MAX_VALUE / 3);
	int low1 = 0;
	StopWatch sw1 = new StopWatch();
	sw1.start();
	for (int i = 0; i < 1000000; i++) {
	    if (random(n) < n / 2) {
		low1++;
	    }
	}
	sw1.stop();

	System.out.println(low1); // 500000位になると思いきやならない。666666位になる。
	System.out.println(sw1.getTime());

	int low2 = 0;
	StopWatch sw2 = new StopWatch();
	sw2.start();
	for (int i = 0; i < 1000000; i++) {
	    if (tlr.nextInt(n) < n / 2) {
		low2++;
	    }
	}
	sw2.stop();
	System.out.println(low2);// 500000位になる。
	System.out.println(sw2.getTime());// 速度はあまり変わらない
    }

    static Random rnd = new Random();

    static int random(int n) {
	return Math.abs(rnd.nextInt()) % n;
    }

    static ThreadLocalRandom tlr = ThreadLocalRandom.current();

}
