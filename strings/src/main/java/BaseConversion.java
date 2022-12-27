public class BaseConversion {

    /**
     * The insight to a good algorithm is the fact that all languages have an integer type, which supports arithmetical operations like multiply, add, divide, modulus, etc. These operations make the conversion much easier.
     * Specifically, we can convert a string in base b\ to integer type using a sequence of multiply and adds. Then we convert that integer type to a string in base b2 using a sequence of modulus and division operations.
     * For example, for the string is "615", b2 =7 and b2 =13, then the integer value, expressed in decimal, is 306. The least significant digit of the result is 306 mod 13 = 7, and we continue with 306/13 = 23. The next digit is 23 mod 13 = 10, which we denote by 'A'. We continue with 23/13 = 1. Since 1 mod 13 = 1 and 1/13 = 0, the final digit is 1, and the overall result is "1A7".
     * Since the conversion alorithm is naturally expressed in terms of smaller similar subproblems, it is natural to implement it using recursion.
    */

    public static String baseConversion(String s, int b1, int b2) {
        boolean isNegative = s.charAt(0) == '-' ? true : false;
        int decimal = 0;
        for (int i = (isNegative ? 1 : 0); i < s.length(); i++) {
            decimal *= b1;
            decimal += Character.isDigit(s.charAt(i)) ?
                    s.charAt(i) - '0' : s.charAt(i) - 'A' + 10;
        }

        return (isNegative ? "-" : "") + (decimal == 0 ? "0" : construct(decimal, b2));
    }

    private static String construct(int decimal, int b2) {
        return decimal == 0 ? "" : construct(decimal / b2, b2) + (char)(decimal % b2 >= 10 ? 'A' + decimal % b2 - 10 : '0' + decimal % b2);
    }
}
