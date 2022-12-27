import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputeValidIPAddresses {

    /**
     * There are three periods in a valid IP address, so we can enumerate all possible placements of these periods, and check whether all four corresponding sub¬ strings are between 0 and 255. We can reduce the number of placements considered by spacing the periods 1to3 characters apart. We can also prime by stopping as soon as a substring is not valid.
    */

    public static List<String> computeValidIPAddresses(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < 4 && i < s.length(); i++) {
            final String first = s.substring(0, i);
            if (isValid(first)) {
                for (int j = 1; i + j < s.length() && j < 4; j++) {
                    final String second = s.substring(i, i + j);
                    if (isValid(second)){
                        for (int k = 1; i + j + k < s.length() && k < 4; k++) {
                            final String third = s.substring(i + j, i + j + k);
                            final String fourth = s.substring(i + j + k);
                            if (isValid(third) && isValid(fourth)) {
                                res.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    private static boolean isValid(String num) {
        //000 00 are not valid
        if (num.startsWith("0") && num.length() > 1) return false;
        int val = Integer.parseInt(num);
        if (val > 255 || val < 0) return false;
        return true;
    }

}
