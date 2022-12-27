import java.util.Collections;
import java.util.List;

public class DutchNationalFlag {

    /**
    Instead of deleting an entry (which requires moving all entries to its right), con¬ sider overwriting it.
    quicksort part
    */

    public static void dutchNationalFlag(int p, List<Integer> A) {
        int left = 1, right = A.size() - 1;
        Collections.swap(A, 0, p);
        int pivot = A.get(0);
        while (left <= right ) {
            while (left < A.size() && A.get(left) <= pivot) {
                left++;
            }
            while (right >= 0 && A.get(right) > pivot) {
                right--;
            }
            if (left > right) break;
            Collections.swap(A, left, right);
        }

        Collections.swap(A, right, 0);

    }
}
