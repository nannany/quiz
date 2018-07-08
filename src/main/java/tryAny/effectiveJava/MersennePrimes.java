package tryAny.effectiveJava;

import static java.math.BigInteger.*;

import java.math.BigInteger;
import java.util.stream.Stream;

public class MersennePrimes {
    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE)).filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                // .forEach(System.out::println);
                .forEach(mp -> System.out.println(mp.bitLength() + ":" + mp));
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
