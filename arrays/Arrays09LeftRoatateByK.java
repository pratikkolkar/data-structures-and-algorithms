package arrays;

import java.util.Arrays;


/* 
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

    

    Example 1:

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
    Example 2:

    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation: 
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]
    

    Constraints:

    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1
    0 <= k <= 105
 */
public class Arrays09LeftRoatateByK {
    /* 
     * To do left rotate - 
     *  1. reverse array from 0 to k
     *  2. reverse from k+1 to n-1
     *  3. reverse entire array
     * 
     * 
     * For right rotate-
     *  1. reverse n - k to n-1
     *  2. reverse 0 to k
     *  3. reverse entire array
     *  
     */


    public static void main(String[] args) {
        // TC: O(N)
        // SC: O(1)
        int[] arr=  {1,2,3,4,5,6,7};
        int k =3;
        reverse(arr,arr.length-k,arr.length-1);
        reverse(arr,0,k);
        reverse(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(a -> System.out.print(a+" "));
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start<end) {
            int tmp = arr[start];
            arr[start]=arr[end];
            arr[end]=tmp;
            start++;
            end--;
        }
    }
}
