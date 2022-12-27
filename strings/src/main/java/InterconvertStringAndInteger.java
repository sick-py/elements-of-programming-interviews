public class InterconvertStringAndInteger {

    /**
     * Let's consider the integer to string problem first. If the number to convert is a single digit, i.e., it is between 0 and 9, the result is easy to compute: it is the string consisting of the single character encoding that digit.
     * If the number has more than one digit, it is natural to perform the conversion digit-by-digit. The key insight is that for any positive integer x, the least significant digit in the decimal representation of x is x mod 10, and the remaining digits are x/10.
     *  However, adding a digit to the beginning of a string is expensive, since all remaining digit have to be moved. A more time efficient approach is to add each computed digit to the end, and then reverse the computed sequence.
     * If x is negative, we record that, negate x,and then add a before reversing. If x is 0, our code breaks out of the iteration without writing any digits, in which case we need to explicitly set a 0
     * To convert from a string to an integer we recall the basic working of a positional number system. A base-10 number d2did0 encodes the number 102 xd2 + 101 X d\ + d0. A brute-force algorithm then is to begin with the rightmost digit, and iteratively add 10' X di to a cumulative sum. The efficient way to compute 10,+1 is to use the existing value 10' and multiply that by 10.
     * A more elegant solution is to begin from the leftmost digit and with each succeed¬ ing digit, multiply the partial result by 10 and add that digit.
    */

    public static Integer stringToInt(String number) {

        int res = 0;
        for (int i = number.charAt(0) == '-' ? 1 : 0; i < number.length(); i++) {
            res = res * 10 + (number.charAt(i) - '0');
        }


        return number.charAt(0) == '-' ? -res : res;
    }

    public static String intToString(Integer number) {
        boolean isNegative = false;
        if (number < 0) isNegative = true;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char)('0' + Math.abs(number % 10)));
            number /= 10;
        }while (number != 0);

        if (isNegative) {
            sb.append('-');
        }

        sb.reverse();

        return sb.toString();
    }

}
