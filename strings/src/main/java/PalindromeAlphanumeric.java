public class PalindromeAlphanumeric {

    /**
     * The naive approach is to create a reversed version of s, and compare it with s, skipping nonalphanumeric characters. This requires additional space proportional to the length of s.
     * We do not need to create the reverse—rather, we can get the effect of the reverse of s by traversing s from right to left.
     * Specifically, we use two indices to traverse the string, one forwards, the other backwards, skipping nonalphanumeric characters, perform¬ ing case-insensitive comparison on the alphanumeric characters. We return false as soon as there is a mismatch. If the indices cross, we have verified palindromicity.
    */

    public static boolean isPalindrome(String input) {
        int left = 0, right = input.length() - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(input.charAt(left)) && left < right) {
                left++;
            }

            while (Character.isLetterOrDigit(input.charAt(right)) && left < right) {
                right--;
            }

            if (Character.toLowerCase(input.charAt(left++)) != Character.toLowerCase(input.charAt(right--))) return false;
        }
        return true;
    }
}
