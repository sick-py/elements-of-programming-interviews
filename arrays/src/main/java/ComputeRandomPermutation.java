import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ComputeRandomPermutation {

    /**
     *
    */

    public static List<Integer> computeRandomPermutation(int n) {
        List<Integer> permutation = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            permutation.add(i);
        }
        Random gen = new Random();
        for (int i = 0; i < n; i++) {
            Collections.swap(permutation, i, i + gen.nextInt(n - i));
        }

        return Collections.emptyList();
    }
}

