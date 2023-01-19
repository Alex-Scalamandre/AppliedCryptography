package Assignment_13;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class intFactor {
    /**
     * factor()
     * Finds the prime factors of the product of two prime numbers.
     */
    public static void factor() {
        // Variables
        BigInteger f = new BigInteger("3");
        BigInteger two = new BigInteger("2");
        BigInteger zero = new BigInteger("0");
        Random num = new Random();
        List<BigInteger> primes = new ArrayList<BigInteger>();
        BigInteger prime1, prime2, multPrime, multPrimeInit;
        long timeBefore, timeAfter, totalTime;

        // Loop to iterate from 10 bit numbers to 32 bit numbers
        for (int i = 10; i <= 32; i++) {
            timeBefore = System.currentTimeMillis(); // Start time -- Used when calculating total time of factoring.

            prime1 = BigInteger.probablePrime(i, num);
            prime2 = BigInteger.probablePrime(i, num);

            multPrimeInit = prime1.multiply(prime2);

            multPrime = prime1.multiply(prime2);

            // Loop for if the number is somehow not prime
            while ((multPrime.mod(two)).intValue() == 0) {
                System.out.println(two);
                multPrime = multPrime.divide(two);
            }

            // Comparative value to start loop.
            int compareValue = f.compareTo(multPrime.sqrt());

            // Loop to find the prime factors
            while (compareValue == -1 || compareValue == 0) {
                while (multPrime.mod(f).equals(zero)) {
                    primes.add(0, f);
                    multPrime = multPrime.divide(f);
                    f = f.add(two);
                }
                f = f.add(two);
                compareValue = f.compareTo(multPrime.sqrt());
            }
            timeAfter = System.currentTimeMillis(); // Time after operations -- -- Used when calculating total time of factoring.
            totalTime = timeAfter - timeBefore; // Total time of operations
            primes.add(1, multPrime);

            System.out.println(i + " bit primes. Duration=" + totalTime + "s: n=" + multPrimeInit + " => p=" + primes.get(0) + ", q=" + primes.get(1));
        }
        System.out.println("Finished!");
    }

    public static void main(String[] args) {
        factor();
    }
}
