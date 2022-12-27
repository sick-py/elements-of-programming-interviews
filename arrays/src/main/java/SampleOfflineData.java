import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SampleOfflineData {

    /**
     * Let the input array be A, its length n, and the specified size k. A naive approach is to iterate through the input array, selecting entries with probability k/n. Although the average number of selected entries is k, we may select more or less than k entries in this way.
     * Another approach is to enumerate all subsets of size k and then select one at random from these. Since there are (") subsets of size k, the time and space complexity are huge. Furthermore, enumerating all subsets of size k is nontrivial (Problem 16.5 on Page 291).
     *
     * The key to efficiently building a random subset of size exactly k is to first build one of size k— 1 and then adding one more element, selected randomly from the rest.
     *
     * As a concrete example, let the input be A = (3, 7,5,11} and the size be 3. In the first iteration, we use the random number generator to pick a random integer in the interval [0,3], Let the returned random number be 2. We swap A[0] with A[2]— now the array is (5,7,3,11). Now we pick a random integer in the interval [1,3]. Let the returned random number be 3. We swap A[l] with A[3]—now the resulting array is (5,11,3,7). Now we pick a random integer in the interval [2,3]. Let the returned random number be 2. When we swap A[2] with itself the resulting array is unchanged. The random subset consists of the first three entries, i.e., (5,11,3}.
     *
     *The algorithm clearly runs in additional 0(1) space. The time complexity is 0(k) to select the elements.
     *
     * The algorithm makes k calls to the random number generator. When k is bigger than n/2, we can optimize by computing a subset of n-k elements to remove from the set. For example, when k = n —1, this replaces n —1 calls to the random number generator with a single call.
    */

    public static void randomSampling(int k, List<Integer> list) {
        Random gen = new Random();
        for (int i = 0; i < k; i++) {
            Collections.swap(list, i, i + gen.nextInt(list.size() - i));
        }

    }
}
