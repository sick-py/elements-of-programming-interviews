import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputeSpiralOrdering {

    /**
     * Here is a uniform way of adding the boundary. Add the first n - 1 elements of the first row. Then add the first n —1 elements of the last column. Then add the last n - 1 elements of the last row in reverse order. Finally, add the last n— 1 elements of the first column in reverse order.
     * After this, we are left with the problem of adding the elements of an (n- 2) X (n- 2) 2D array in spiral order. This leads to an iterative algorithm that adds the outermost elements of n X n,(n - 2) X (n - 2),(« - 4) X (n - 4),... 2D arrays. Note that a matrix of odd dimension has a comer-case, namely when we reach its center.
    */

    public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
        List<Integer> res = new ArrayList<>();
        for (int offset = 0; offset < Math.ceil(0.5 * squareMatrix.size()); offset++) {
            help(squareMatrix, offset, res);
        }
        return res;
    }

    private static void help(List<List<Integer>> squareMatrix, int offset, List<Integer> res) {
        if (offset == squareMatrix.size() - offset - 1) {
            //if it's odd and has a center
            res.add(squareMatrix.get(offset).get(offset));
            return;
        }

        for (int j = offset; j < squareMatrix.size() - offset - 1; j++) {
            res.add(squareMatrix.get(offset).get(j));
        }

        for (int i = offset; i < squareMatrix.size() - offset - 1; i++) {
            res.add(squareMatrix.get(i).get(squareMatrix.size() - offset - 1));
        }

        for (int j = squareMatrix.size() - offset - 1; j > offset; j--) {
            res.add(squareMatrix.get(squareMatrix.size() - offset - 1).get(j));
        }

        for (int i = squareMatrix.size() - offset - 1; i > offset; i--) {
            res.add(squareMatrix.get(i).get(offset));
        }
    }
}
