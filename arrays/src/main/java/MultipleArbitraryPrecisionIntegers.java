import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultipleArbitraryPrecisionIntegers {

    /*
    6.3
    As in Solution 6.2 on Page 65, the possibility of overflow precludes us from converting to the integer type.

Instead we can use the grade-school algorithm for multiplication which consists of multiplying the first number by each digit of the second, and then adding all the resulting terms.
From a space perspective, it is better to incrementally add the terms rather than compute all of them individually and then add them up.
The number of digits required for the product is at most n + m for n and m digit operands, so we use an array of size n + m for the result.
For example, when multiplying 123 with 987, we would form 7 X 123 = 861, then we would form 8 X 123 X 10 = 9840, which we would add to 861 to get 10701. Then we would form 9 X 123 X 100 = 110700, which we would add to 10701 to get the final result 121401. (All numbers shown are represented using arrays of digits.)

O(nm)
    */

    public static List<Integer> multiply(List<Integer> a, List<Integer> b) {
        final int sign = a.get(0) < 0 ^ b.get(0) < 0 ? -1 : 1;
        a.set(0, Math.abs(a.get(0)));
        b.set(0, Math.abs(b.get(0)));
        List<Integer> res = new ArrayList<>(Collections.nCopies(a.size() + b.size(), 0));
        for (int i = a.size() - 1; i >= 0; i--) {
            for (int j = b.size() - 1; j >= 0; j--) {
                res.set(i + j + 1,
                        res.get(i + j + 1) + a.get(i) * b.get(j));
                res.set(i + j, res.get(i + j) + res.get(i + j + 1) / 10);
                res.set(i + j + 1, res.get(i + j + 1) % 10);
            }

        }

        //remove the leading 0
        int firstNotZero = 0;
        while (firstNotZero < res.size() && res.get(firstNotZero) == 0) {
            firstNotZero++;
        }
        res = res.subList(firstNotZero, res.size());
        if (res.isEmpty()) {
            return Arrays.asList(0);
        }
        res.set(0, res.get(0) * sign);
        return Collections.emptyList();
    }
}
