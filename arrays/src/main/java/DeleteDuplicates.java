import java.util.List;

public class DeleteDuplicates {

    /**
    6.5
    Let A be the array and n its length. If we allow ourselves 0(n) additional space, we can solve the problem by iterating through A and recording values that have not appeared previously into a hash table. (The hash table is used to determine if a value is new.) New values are also written to a list. The list is then copied back into A.

    Here is a brute-force algorithm that uses 0(1) additional space—iterate through A, testing if A[i] equals A[i + 1], and, if so, shift all elements at and after i + 2 to the left byone. When all entries are equal,the number of shiftsis(n-1)+(n-2)H 1-2+1, i.e., 0(n2), where n is the length of the array.
    */

    public static int deleteDuplicates(List<Integer> A) {
        if (A.isEmpty()) return 0;
        int writeIndex = 1;
        for (int i = 1; i < A.size(); i++) {
            if (!A.get(writeIndex - 1).equals(A.get(i))) {
                A.set(writeIndex, A.get(i));
                writeIndex++;
            }
        }
        return writeIndex;
    }
}
