package arrays;

import java.util.Arrays;

import utils.Util;

/* 
    Single Number

    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    You must implement a solution with a linear runtime complexity and use only constant extra space.

    

    Example 1:

    Input: nums = [2,2,1]
    Output: 1
    Example 2:

    Input: nums = [4,1,2,1,2]
    Output: 4
    Example 3:

    Input: nums = [1]
    Output: 1
    

    Constraints:

    1 <= nums.length <= 3 * 104
    -3 * 104 <= nums[i] <= 3 * 104
    Each element in the array appears twice except for one element which appears only once.
 */
public class Arrays15SingleNumber {
    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        // sortAndCheck(nums);
        xor(nums);
    }

    /*
     * Observation:
     * We know that if xor two number it results in zero. The number repeating twice
     * will become zero and we wil be left with the number appearing once.
     * 
     * Algorithm:
     * 1. intiate num = 0
     * 2. for i=0 to i=N
     *      num =num ^ nums[i]
     * 3. return num
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private static void xor(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num = num ^ i;
        }
        Util.print(num);
    }

    /*
     * Algorithm:
     * 1. Sort the array
     * 2. for i=0 to i<nums.length-1 i=i+2
     * if nums[i] != nums[i+1]
     * return nums[i]
     * 3. retun nums[i] // in case single number is at end
     * 
     * 
     * TC: O(NlogN)
     * SC: O(1)
     * 
     */
    private static void sortAndCheck(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length - 1; i = i + 2) {
            if (nums[i] != nums[i + 1]) {
                Util.print(nums[i]);
                return;

            }
        }
        Util.print(nums[i]);
    }
}
