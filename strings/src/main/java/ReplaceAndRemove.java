public class ReplaceAndRemove {

    /**
     * Library array implementations often have methods for inserting into a specific location (all later entries are shifted right, and the array is resized) and deleting from a specific location (all later entries are shifted left, and the size of the array is decremented). If the input array had such methods, we could apply them—however, the time complexity would be 0(n2), where n is the array's length. The reason is that each insertion and deletion from the array would have 0(n) time complexity.
     * This problem is trivial to solve in 0(n) time if we write result to a new array—we skip 'b's, replace 'a's by two 'd's, and copy over all other characters. However, this entails 0(n) additional space.
     * If there are no 'a's, we can implement the function without allocating additional space with one forward iteration by skipping 'b's and copying over the other characters.
     *If there are no 'b's, we can implement the function without additional space as follows. First, we compute the final length of the resulting string, which is the length of the array plus the number of 'a's. We can then write the result, character by character, starting from the last character, working our way backwards.
     * We can combine these two approaches to get a complete algorithm. First, we delete 'b's and compute the final number of valid characters of the string, with a forward iteration through the string. Then we replace each 'a' by two 'd's, iterating backwards from the end of the resulting string. If there are more 'b's than 'a's, the number of valid entries will decrease, and if there are more 'a's than 'b's the number will increase. In the program below we return the number of valid entries in the final result.
    */

    public static String replaceAndRemove(char[] s, int k) {
        //forward to remove b and count the number of a
        int writeIndex = 0, aCount = 0;
        for (int i = 0; i < k; i++) {
            if (s[i] == 'a') aCount++;
            if (s[i] != 'b') {
                s[writeIndex++] = s[i];
            }
        }

        //backward to replace a
        int curIndex = writeIndex - 1;
        writeIndex = writeIndex + aCount - 1;
        final int finalSize = writeIndex + 1;
        while (curIndex >= 0) {
            if (s[curIndex] == 'a') {
                s[writeIndex--] = 'd';
                s[writeIndex--] = 'd';
            } else {
                s[writeIndex--] = s[curIndex];
            }
            curIndex--;
        }
        return new String(s);
    }

}
