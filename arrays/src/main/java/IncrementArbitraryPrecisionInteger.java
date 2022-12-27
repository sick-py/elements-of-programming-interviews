import java.util.List;

public class IncrementArbitraryPrecisionInteger {

    /*
    6.2
    A brute-force approach might be to convert the array of digits to the equivalent integer, increment that, and then convert the resulting value back to an array of digits. For example, if the array is (1, 2, 9), we would derive the integer 129, add one to get 130, then extract its digits to form (1,3,0). When implemented in a language that imposes a limit on the range of values an integer type can take, this approach will fail on inputs that encode integers outside of that range.

We can avoid overflow issues by operating directly on the array of digits. Specifi¬ cally, we mimic the grade-school algorithm for adding numbers, which entails adding digits starting from the least significant digit, and propagate carries. If the result has an additional digit, e.g., 99 + 1 = 100, all digits have to be moved to the right by one.
    */

    public static List<Integer> incrementInteger(List<Integer> A) {
        int n = A.size() - 1;
        A.set(n, A.get(n) + 1);
        for (int i = n; i > 0 && A.get(i) == 10; i--) {
            A.set(i, 0);
            A.set(i - 1, A.get(i - 1) + 1);
        }
        if (A.get(0) == 10) {
            A.set(0, 0);
            A.add(0, 1);
        }
        return A;
    }
}
