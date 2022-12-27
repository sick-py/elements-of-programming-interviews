import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EnumeratePrimes {

    /**
     * 6.8
     * The natural brute-force algorithm is to iterate over all i from 2 to n, where n is the input to the program. For each i, we test if i is prime; if so we add it to the result. We can use "trial-division" to test if i is prime, i.e., by dividing i by each integer from 2 to the square root of i, and checking if the remainder is 0. (There is no need to test beyond the square root of i, since if i has a divisor other than 1 and itself, it must also have a divisor that is no greater than its square root.) Since each test has time complexity 0( yfn), the time complexity of the entire computation is upper bounded by 0(n X ), i.e., 0(n312).

     * Intuitively, the brute-force algorithm tests each number from 1 to n independently, and does not exploit the fact that we need to compute all primes from 1 to n. Heuris- tically, a better approach is to compute the primes and when a number is identified as a prime, to "sieve" it, i.e., remove all its multiples from future consideration.
     *
     * We use a Boolean array to encode the candidates, i.e., if the zth entry in the array is true, then i is potentially a prime. Initially, every number greater than or equal to 2 is a candidate. Whenever we determine a number is a prime, we will add it to the result, which is an array. The first prime is 2. We add it to the result. None of its multiples can be primes, so remove all its multiples from the candidate set by writing false in the corresponding locations. The next location set to true is 3. It must be a prime since nothing smaller than it and greater than 1 is a divisor of it. As before, we add it to result and remove its multiples from the candidate array. We continue till we get to the end of the array of candidates.

     * As an example, if n = 10, the candidate array is initialized to (F,F,T,T,T,T,T,T,T,T,T), where T is true and F is false. (Entries 0 and 1 are false, since 0 and 1 are not primes.) We begin with index 2. Since the corresponding en¬ try is one, we add 2 to the list of primes, and sieve out its multiples. The array is now (F,F,T,T,F, F,F,T,F,T,F). The next nonzero entry is 3, so we add it to the list of primes, and sieve out its multiples. The array is now (F,F, F, F,F, F,F, F,F,F,F). The next nonzero entries are 5 and 7, and neither of them can be used to sieve out more entries.
     *
     * We justified the sifting approach over the trial-division algorithm on heuristic grounds. The time to sift out the multiples of p is proportional to n/p, so the overall time complexity is 0(n/2 + n/3 + n/5 + n/7 + n/11 + ... ). Although not obvious, this sum asymptotically tends to n log log n, yielding an 0(n log log n) time bound. The space complexity is dominated by the storage for P, i.e., 0(n).
    */

    public static List<Integer> enumeratePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
        isPrime.set(0, false);
        isPrime.set(1, false);
        for (int p = 2; p <= n; p++){
            if (isPrime.get(p)) {
                primes.add(p);
                for (int j = p; j <= n; j += p) {
                    isPrime.set(j, false);
                }
            }
        }
        return primes;
    }
}
