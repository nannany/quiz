package tryAny.effectiveJava;

import java.math.BigInteger;
import java.util.stream.LongStream;

import org.apache.commons.lang3.time.StopWatch;

public class ParallelTest1 {
    // Prime-counting stream pipeline - benefits from parallelization
    static long pi(long n) {
        return LongStream.rangeClosed(2, n).parallel().mapToObj(BigInteger::valueOf).filter(i -> i.isProbablePrime(50))
                .count();
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        sw.start();
        System.out.println(pi(10000000));
        sw.stop();
        System.out.println(sw.getTime());
    }
}
