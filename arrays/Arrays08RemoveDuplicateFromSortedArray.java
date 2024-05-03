package arrays;

import java.util.Arrays;



/* 
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
    The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. 
    The remaining elements of nums are not important as well as the size of nums.
    Return k.

    Example 2:

    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class Arrays08RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int k = removeDuplicates(nums);
        System.out.println("k: " + k);
        Arrays.stream(nums).boxed().forEach(num -> System.out.print(num + " "));

    }

    /* 
     * Algorithm:
     *  1. Initiate a pointer k =0;
     *  2. For index i = 0 to n-1
     *          a. If k < 1 or nums[k-1] not equal to nums[i]
     *                  1. nums[k] = nums[right]
     *                  2. k++
     *  3. Return k
     * 
     * Time Complexity: O(N)
     * Space COmplexity: O(1)
     * 
     */
    private static int removeDuplicates(int[] nums) {
        int k = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (k < 1 || nums[k - 1] != nums[i]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
