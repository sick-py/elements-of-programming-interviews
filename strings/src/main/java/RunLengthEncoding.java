public class RunLengthEncoding {

    /**
     * The idea is simple—encode successive repeated characters by the repetition count and the character. For example, the RLE of "aaaabcccaa" is "4alb3c2a". The decoding of "3e4f2e" returns "eeeffffee".
     *
     * Implement run-length encoding and decoding functions. Assume the string to be encoded consists of letters of the alphabet, with no digits, and the string to be decoded is a valid encoding.
     *
     * First we consider the decoding function. Every encoded string is a rep¬ etition of a string of digits followed by a single character. The string of digits is the decimal representation of a positive integer. To generate the decoded string, we need to convert this sequence of digits into its integer equivalent and then write the character that many times. We do this for each character.
     * The encoding function requires an integer (the repetition count) to string conver¬ sion.
    */

    public static String encode(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
                //found it and write it to the sb
                sb.append(count);
                sb.append(s.charAt(i));
                count = 1;
            } else {
                count++;
            }
        }
        return sb.toString();
    }

    public static String decode(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);
           if (Character.isDigit(c)) { //pay attention to here because there maybe 15a3b
               count = count * 10 + c - '0';
           } else {
               while (count > 0) {
                   sb.append(c);
                   count--;
               }
           }
        }
        return sb.toString();
    }

}
