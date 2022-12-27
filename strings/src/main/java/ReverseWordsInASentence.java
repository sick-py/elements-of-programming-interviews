import java.util.Collections;

public class ReverseWordsInASentence {

    /**
     * The code for computing the position for each character in the final result in a single pass is intricate.
     * However, for the special case where each word is a single character, the desired result is simply the reverse of s.
     * For the general case, reversing s gets the words to their correct relative positions. However, for words that are longer than one character, their letters appear in reverse order. This situation can be corrected by reversing the individual words.
     * For example, "ram is costly" reversed yields "yltsoc si mar". We obtain the final result by reversing each word to obtain "costly is ram".
    */

    public static String reverseWordsInASentence(String input) {
        StringBuilder string = new StringBuilder(input);
        reverse(string, 0, input.length() - 1);

        int start = 0, end;
        while ((end = find(string, ' ', start)) != -1) {
            reverse(string, start, end);
            start = end + 1;
        }

        reverse(string, start, input.length() - 1);
        return input;
    }

    private static int find(StringBuilder string, char c, int start) {
        for (int i = start; i < string.length(); i++) {
            if (string.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    private static void reverse(StringBuilder string, int start, int end) {
        if (start > end) return;
        for (int i = start; i <= start + (end - start) / 2; i++) {
            char temp = string.charAt(i);
            string.setCharAt(i, string.charAt(end));
            string.setCharAt(end - i, temp);
        }
    }
}
