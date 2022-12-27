import java.util.List;

public class AdvanceThroughArray {

    /**
       6.4
       In a particular board game, a player has to try to advance through a sequence of positions. Each position has a nonnegative integer associated with it, representing the maximum you can advance from that position in one move. You begin at the first position,and winbygettingtothelastposition. Forexample,letA =(3,3,1,0,2,0,1} represent the board game, i.e., the ith entry in A is the maximum we can advance from i. Then the game can be won by the following sequence of advances through A: take 1 step from A[0] to A[1], then 3 steps from A[l] to A[4], then 2 steps from A[4] to A[6], which is the last position. Note that A[0] = 3 > 1, A[l] = 3 > 3, and A[4] = 2 > 2, so all moves are valid. If A instead was (3, 2, 0,0, 2, 0,1), it would not possible to advance past position 3, so the game cannot be won.
Write a program which takes an array of n integers, where A[i] denotes the maximum you can advance from index i, and returns whether it is possible to advance to the last index starting from the beginning of the array.

It is natural to try advancing as far as possible in each step. This approach does not always work, because it potentially skips indices containing large entries.

suggests iterating through all entries in A. As we iterate through the array, we track the furthest index we know we can advance to. The furthest we can advance from index i is i + A[i]\. If, for some i before the end of the array, i is the furthest index that we have demonstrated that we can advance to, we cannot reach the last index. Otherwise, we reach the end.

    */

    public static boolean arrayAdvance(List<Integer> A) {

        int furthest = 0, lastIndex = A.size() - 1;
        for (int i = 0; i < lastIndex; i++) {
            furthest = Math.max(furthest, i + A.get(i));
        }
        return furthest >= lastIndex;
    }
}
