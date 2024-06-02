package arrays;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* 
    Move Zeroes

    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Example 2:

    Input: nums = [0]
    Output: [0]
    

    Constraints:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1
 */
public class Arrays10MoveZeroes {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        int n = nums.length;
        // method1(nums, n);
        method2(nums, n);
    }

    /* 
     * Optimal Method
     * 
     * TC: O(N)
     * SC: O(1)
     *     
     * */
    private static void method2(int[] nums, int n) {
        int index = 0;
        for(int i = 0; i < n; i++){
            if(nums[i]!=0)
                nums[index++] = nums[i];
        }
        while(index<n){
            nums[index++] = 0;
        }

        print(nums);
    }

    /*
     * Better Solution:
     * 
     * Observation:
     * We can use two pointer technique.
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private static void method1(int[] nums, int n) {
        int left = 0, right = 1;
        while (right < n) {
            // Increment left pointer only if element is not equal to zero
            if (nums[left] != 0) {
                left++;
            }

            // Swap if element right pointer is not zero and element at left is zero
            if (nums[right] != 0 && nums[left] == 0) {
                nums[left] = nums[left] ^ nums[right];
                nums[right] = nums[left] ^ nums[right];
                nums[left] = nums[left] ^ nums[right];
            }
            right++;
        }
        // Printing output
        print(nums);
    }

    private static void print(int[] nums) {
        String out = Arrays.stream(nums).boxed().map(el -> "" + el).collect(Collectors.joining(","));
        System.out.print("[" + out + "]");
    }

}
