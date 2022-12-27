public class GenerateUniformRandomNumbers {

    /**
    5.10
     Note that it is easy to produce a random integer between 0 and 2' - 1,
     inclusive: concatenate i bits produced by the random number generator.
     For example, two calls to the random number generator will produce one of (00)2, (01)2, (10)2, (11)2.
     These four possible outcomes encode the four integers 0, 1,2,3, and all of them are equally likely.

     For the general case, first note that it is equivalent to produce a random integer between 0 and b- a,
     If b- a is equal to 2' - 1, for some i, then we can use the approach in the previous paragraph.

     If b- a is not of the form 2' - 1, we find the smallest number of the form 2' - 1 that is greater than b- a.
     We generate an i-bit number as before. This i-bit number may or may not lie between 0 and b - a, inclusive.
     If it is within the range, we return it—all such numbers are equally likely. If it is not within the range, we try again with i new random bits. We keep trying until we get a number within the range.

     To analyze the time complexity, let f = b — a + 1. The probability that we succeed in the first try is t / 2 ^ i. Since 2' is the smallest power of 2 greater than or equal to f, it must be less than 2t. (An easy way to see this is to consider the binary representation of t and 2y.) This implies that t / 2 ^ i > t/2t = (1/2). Hence the probability that we do not succeed on the first try is 1 - f/2' < 1/2. Since successive tries are independent,
     _ the probability that more than k tries are needed is less than or equal to l/2k. Hence,
     the expected number of tries is not more than 1 + 2(1/2)' + 3(l/2)2 + The series converges, so the number of tries is 0(1). Each try makes flg(i) - a + 1)1 calls to the 0/1-valued random number generator. Assuming the 0/1-valued random number generatortakes0(1)time,thetimecomplexityis0(lg(b - a + 1)).
     */

    public static int uniformRandom(int lowerBound, int upperBound) {
        int numbers = upperBound - lowerBound + 1, res;
        do {
            res = 0;
            for (int i = 0; (1 << i) < numbers; ++i) {
                res = (res << 1) | zeroOneRandom();
            }
        } while (res >= numbers);
        return res + lowerBound;
    }

    private static int zeroOneRandom() {

        //return 0 or 1
        return 1;
    }
}
