import java.text.CollationElementIterator;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    /**
     *  A brute-force approach might be to find all permutations whose length equals that of the input array, sort them according to the dictionary order, then find the successor of the input permutation in that ordering. Apart from the enormous space and time complexity this entails, simply computing all permutations of length n is a nontrivial problem;
     *
     *  key insight is that we want to increase the permutation by as little as possible. The loose analogy is how a car's odometer increments; the difference is that we cannot change values, only reorder them. We will use the permutation (6,2,1,5,4,3,0} to develop this approach.
     * Specifically, we start from the right, and look at the longest decreasing suffix, which is (5, 4, 3, 0} for our example. We cannot get the next permutation just by modifying this suffix, since it is already the maximum it can be.
     *
     * Instead we look at the entry e that appears just before the longest decreasing suffix, which is 1 in this case. (If there's no such element, i.e., the longest decreasing suffix is the entire permutation, the permutation must be (n —1,n —2,...,2,1,0), for which there is no next permutation.)
     *
     * Observe that e must be less than some entries in the suffix (since the entry imme¬ diately after e is greater than e). Intuitively, we should swap e with the smallest entry s in the suffix which is larger than e so as to minimize the change to the prefix (which is defined to be the part of the sequence that appears before the suffix).
     *
     * For our example, e is1 and s is 3. Swapping s and e results in (6, 2,3,5,4,1,0).
     * We are not done yet—the new prefix is the smallest possible for all permutations greater than the initial permutation, but the new suffix may not be the smallest. We can get the smallest suffix by sorting the entries in the suffix from smallest to largest. For our working example, this yields the suffix (0,1,4,5).
     * As an optimization, it is not necessary to call a full blown sorting algorithm on suffix. Since the suffix was initially decreasing, and after replacing s by e it remains decreasing, reversing the suffix has the effect of sorting it from smallest to largest.
     *
     * The general algorithm for computing the next permutation is as follows:
     * (1.) Find k such that p[k] < p[k + 1] and entries after index k appear in decreasing
     * order.
     * (2.) Find the smallest p[l] such that p[l] > p[k] (such an / must exist since p[k] <
     * p[k+l]).
     * (3.) Swap p[l] and p[k] (note that the sequence after position k remains in decreasing
     * order).
     * (4.) Reverse the sequence after position k.
     *
     * Each step is an iteration through an array, so the time complexity is 0(n). All that we use are a few local variables, so the additional space complexity is 0(1).
    */

    public static List<Integer> nextPermutation(List<Integer> permutation) {
        int k = permutation.size() - 2;
        while (k >= 0 && permutation.get(k) >= permutation.get(k + 1)){
            k--;
        }
        if (k == -1) {
            return Collections.emptyList();
        }

        for (int i = permutation.size() - 1; i > k; i--) {
            if (permutation.get(i) > permutation.get(k)) {
                Collections.swap(permutation, i, k);
                break;
            }
        }

        Collections.reverse(permutation.subList(k + 1, permutation.size()));
        return permutation;
    }
}
