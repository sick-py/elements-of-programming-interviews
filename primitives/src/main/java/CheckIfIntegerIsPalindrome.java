public class CheckIfIntegerIsPalindrome {

    /**
    5.9
    if it's negative it can't be palindrome
    brute-force way is to convert the input to a string and
     then iterate through the string pairwise comparing digits starting from
     the least significant digit and the most significant digit, and working inwards,
     stopping if there is a dismatch, the time and space complexity is O(N)

     We can avoid the 0(n) space complexity used by the string representation by directly extracting the digits from the input.
     The number of digits, n, in the input's string representation is the log (base 10) of the input value, x. To be precise, n = Llog10 x\ + l. Therefore, the least significant digit is x mod 10, and the most significant digit is x/10"-1.
     */

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        final int numDigit = (int)(Math.floor(Math.log10(x))) + 1;
        int msdMask = (int)Math.pow(10, numDigit - 1);
        for (int i = 0; i < (numDigit / 2); i++) {
            if (x / msdMask != x % 10) {
                return false;
            }
            x %= msdMask; //remove the most significant digit
            x /= 10; //remove the least significant digit
            msdMask /= 100;
        }
        return true;
    }
}
