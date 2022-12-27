public class Amain {
    /**
     * overview:
     * array is a contiguous block of memory. It is usually used to represent sequences. Given an array A, A[i] denotes the (i+ l)th object stored in the array.
     * Retrieving and updating ,A[i] takes 0(1) time. Insertion into a full array can be handled by resizing, i.e., allocating a new array with additional memory and copying over the entries from the original array. This increases the worst-case time of insertion, but if the new array has, for example, a constant factor larger than the original array, the average time for insertion is constant since resizing is infrequent.
     * Deleting an element from an array entails moving all successive elements one over to the left to fill the vacated space. For example, if the array is (2,3,5,7,9,11,13,17), then deleting the element at index 4 results in the array (2,3,5,7,11,13,17,0). (We do not care about the last value.) The time complexity to delete the element at index i from an array of length n is 0(n - i).
     * */

    /**Array problems often have simple brute-force solutions that use 0(n) space, but subtler solutions that use the array itself to reduce space complexity to 0(1).
     * */
    public void evenOdd(int[] A) {
        int nextEven = 0, nextOdd = A.length - 1;
        while (nextEven < nextOdd) {
            if (A[nextEven] % 2 == 0) {
                nextEven++;
            }else {
                int temp = A[nextEven];
                A[nextEven] = A[nextOdd];
                A[nextOdd--] = temp;
            }
        }
    }
}
