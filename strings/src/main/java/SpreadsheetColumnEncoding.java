public class SpreadsheetColumnEncoding {

    /*
    7.3
    */

    public static int decodeSpreadsheetColumn(String code) {
        int res = 0;
        for (int i = 0; i < code.length(); i++) {
            res = res * 26 + code.charAt(i) - 'A' + 1;
        }
        return res;
    }


}
