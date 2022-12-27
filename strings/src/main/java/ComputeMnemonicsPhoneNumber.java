import java.util.*;

public class ComputeMnemonicsPhoneNumber {

    /**
     * For a 7 digit phone number, the brute-force approach is to form 7 ranges of characters, one for each digit. For example, if the number is "2276696" then the ranges are 'A'-'C', 'A'-'C', 'P'-'S', 'M'-'O', 'M'-'O', 'W'-'Z', and 'M'-'O'. We use 7 nested for-loops where the iteration variables correspond to the 7 ranges to enumerate all possible mnemonics. The drawbacks of such an approach are its repetitiveness in code and its inflexibility.
     * As a general rule, any such enumeration is best computed using recursion. The execution path is very similar to that of the brute-force approach, but the compiler handles the looping.
    */


    public static List<String> computeMnemonics(String phoneNumber) {

        char[] partialMnemonic = new char[phoneNumber.length()];
        List<String> mnemonics = new ArrayList<>();
        helper(phoneNumber, 0, partialMnemonic, mnemonics);
        return mnemonics;
    }
    private static final String[] MAPPING = {
            "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUW", "XYZ"
    };
    private static void helper(String phoneNumber, int index, char[] partialMnemonic, List<String> mnemonics) {
        if (index == phoneNumber.length()) {
            mnemonics.add(new String(partialMnemonic));
        }

        for (int i = 0; i < MAPPING[phoneNumber.charAt(index) - '0'].length(); i++) {
            char c = MAPPING[phoneNumber.charAt(index) - '0'].charAt(i);
            partialMnemonic[index] = c;
            helper(phoneNumber, index, partialMnemonic, mnemonics);
        }
    }

}
