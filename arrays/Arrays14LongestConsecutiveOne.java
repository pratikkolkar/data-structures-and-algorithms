package arrays;

import utils.Util;

/* 
    Max Consecutive Ones

    Given a binary array nums, return the maximum number of consecutive 1's in the array.

    

    Example 1:

    Input: nums = [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
    Example 2:

    Input: nums = [1,0,1,1,0,1]
    Output: 2
    

    Constraints:

    1 <= nums.length <= 105
    nums[i] is either 0 or 1.
    */
public class Arrays14LongestConsecutiveOne {
    public static void main(String[] args) {
        int[] nums ={1,1,0,1,1,1};
        findMaxConsecutiveOnes(nums);
    }

    public static void findMaxConsecutiveOnes(int[] nums) {
        int i = 0, j = 0, max = 0;
        while (j < nums.length) {
            if (nums[j] != 1) {
                max = Math.max(max, j - i);
                i = j;
            }
            if (nums[i] == 0) {
                i++;
            }
            j++;
        }
        max = Math.max(max, j - i);
        Util.print(max);
    }
}
