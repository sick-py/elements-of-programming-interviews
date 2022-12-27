import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputePascalsTriangle {

    /*
    6.19
    */

    public static List<List<Integer>> generatePascalTriangle(int n) {

        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> currRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // Set this entry to the sum of the two above adjacent entries if they exist.
                currRow.add(0 < j && j < i ? triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j) : 1);
            }
            triangle.add(currRow);
        }
        return triangle;
    }
}
