import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuChecker {

    /**
     * There is no real scope for algorithm optimization in this problem—it's all about writing clean code.
    */

    public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {

        //check row
        for (int i = 0; i < partialAssignment.size(); i++) {
            if (hasDuplicate(partialAssignment, i, i + 1, 0, partialAssignment.size())) {
                return false;
            }
        }

        for (int j = 0; j < partialAssignment.size(); j++) {
            if (hasDuplicate(partialAssignment, 0, partialAssignment.size(), j, j + 1)) {
                return false;
            }
        }

        //check regin
        int reginSize = (int)Math.sqrt(partialAssignment.size());
        for (int i = 0; i < reginSize; i++) {
            for (int j = 0; j < reginSize; j++) {
                if (hasDuplicate(partialAssignment, i * reginSize, i * reginSize + reginSize, reginSize * j, reginSize * (j + 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasDuplicate(List<List<Integer>> partialAssignment, int startRow, int endRow, int startCol, int endCol) {
        List<Boolean> isPresent = new ArrayList<>(Collections.nCopies(partialAssignment.size() + 1, false));
        for (int i = startRow; i < endRow; i++) {
            for (int j = startCol; j < endCol; j++) {
                if (partialAssignment.get(i).get(j) != 0 && isPresent.get(partialAssignment.get(i).get(j))) {
                    return true;
                }
                isPresent.set(partialAssignment.get(i).get(j), true);
            }
        }
        return false;
    }
}
