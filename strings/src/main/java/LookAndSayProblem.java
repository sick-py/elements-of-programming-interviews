public class LookAndSayProblem {

    /*
    7.8
    */

    public static String lookAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = nextNumber(s);

        }

        return s;
    }

    private static String nextNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
