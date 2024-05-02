package arrays;

/* 
 * 
 *  Given an array nums, return true if the array was originally sorted in non-decreasing order, 
 * then rotated some number of positions (including zero). Otherwise, return false.

    There may be duplicates in the original array.

    Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

    Example 1:

    Input: nums = [3,4,5,1,2]
    Output: true
    Explanation: [1,2,3,4,5] is the original sorted array.
    You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
 */
public class Arrays07CheckSortedRotatedArray {

    public static void main(String[] args) {
        int arr[] = {};
        System.out.println(checkIfSortedRotated(arr));
    }

    /*
     * If array is sorted - it has non-decreasing number till N
     * 
     * There can be only one possibility in the entire array where non-decreasing
     * order is voilated.
     * If it is voilated more than once then return false;
     * 
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private static boolean checkIfSortedRotated(int[] arr) {
        int count = 0, n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                count++;
            }

            if (count > 1) {
                return false;
            }

        }

        if (count == 1) {
            if (arr[0] < arr[n - 1]) {
                return false;
            }
        }
        return true;
    }
}
