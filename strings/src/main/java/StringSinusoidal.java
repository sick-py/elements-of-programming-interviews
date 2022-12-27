public class StringSinusoidal {

    /**
     * We illustrate what it means to write a string in sinusoidal fashion by means of an example. The string "Hello.World!"
     * For example, the snakestring string for "HelloÿWorld!" is "eÿlHloWrdlo!".
     *
     * Hint: Try concrete examples, and look for periodicity.
     *
     * The brute-force approach is to populate a 3 X n 2D array of characters, initialized to null entries. We then write the string in sinusoidal manner in this array. Finally, we read out the non-null characters in row-major manner.
     * However, observe that the result begins with the characters s[1],s[5],s[9],..., fol¬ lowed by s[0],s[2],s[4],..., and then s[3],s[7],s[ll], Therefore, we can create the snakestring directly, with three iterations through s.
     *
    */

    public static String snakeString(String s) {
        StringBuilder sb = new StringBuilder();
        //the first row
        for (int i = 1; i < s.length(); i += 4) {
            sb.append(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
        }

        for (int i = 3; i < s.length(); i += 4) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

}
