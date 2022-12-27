import java.util.Collections;
import java.util.List;

public class PermuteElements {

    /**
     * It is simple to apply a permutation-array to a given array if additional storage is available to write the resulting array. We allocate a new array B of the same length,setB[P[i]] =A[i]foreachi,and thencopyBtoA.Thetimecomplexityis0(n), and the additional space complexity is 0(n).
     *
     * A key insight to improving space complexity is to decompose permutations into simpler structures which can be processed incrementally. For example, consider the permutation(3,2,1,0}. To apply it to an arrayA={a,b,c,5),we move the element at index 0 (a) to index 3 and the element already at index 3 (6) to index 0. Continuing, we move the element at index 1 (b) to index 2 and the element already at index 2 (c) to index 1. Now all elements have been moved according to the permutation, and the result is (6, c, b,a).
     * This example generalizes: every permutation can be represented by a collection of independent permutations, each of which is cyclic, that is, it moves all elements by a fixed offset, wrapping around.
     *
     * To find and apply the cycle that includes entry i we just keep going forward (from i to P[i]) till we get back to i. After we are done with that cycle, we need to find another cycle that has not yet been applied. It is trivial to do this by storing a Boolean for each array element.
     * One way to perform this without explicitly using additional 0{n) storage is to use the sign bit in the entries in the permutation-array. Specifically, we subtract n from P[i] after applying it. This means that if an entry in P[i] is negative, we have performed the corresponding move.
     *
     * For example, to apply (3,1,2,0), we begin with the first entry, 3. We move A[0] to A[3], first saving the original A[3], We update the permutation to (-1, 1, 2, 0). We move A[3] to A[0], Since P[0] is negative we know we are done with the cycle starting at 0. We also update the permutation to (-1, 1, 2, -4). Now we examine P[1], Since it is not negative, it means the cycle it belongs to cannot have been applied. We continue as before.
    */

    public static void applyPermutation(List<Integer> P, List<Integer> A) {
        for (int i = 0; i < A.size(); i++) {
            //Check if the element at index i has not been moved by checking if
            // P.get(i) is nonnegative.
            int next = i;
            while (P.get(next) >= 0) {
                Collections.swap(A, i, P.get(next));
                int temp = P.get(next);
                P.set(next, P.get(next) - P.size());
                next = temp;
            }
        }

        for (int i = 0; i < P.size(); i++) {
            P.set(i, P.get(i) + P.size());
        }

    }
}
