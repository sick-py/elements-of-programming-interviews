import java.util.Collections;
import java.util.List;

public class Rotate2DArray {

    /**
     *
    */

    public static List<List<Integer>> rotateMatix(List<List<Integer>> squareMatrix) {
        int n = squareMatrix.size();
        //rotate by the diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = squareMatrix.get(i).get(j);
                squareMatrix.get(i).set(j, squareMatrix.get(j).get(i));
                squareMatrix.get(j).set(i, temp);
            }
        }

        for (int i = 0; i < n; i++) {
            Collections.reverse(squareMatrix.get(i));
        }

        return squareMatrix;
    }
}
