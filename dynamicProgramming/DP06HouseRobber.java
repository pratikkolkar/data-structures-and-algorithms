package dynamicProgramming;

import java.util.Arrays;

/* 
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

    

    Example 1:

    Input: nums = [2,3,2]
    Output: 3
    Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
    Example 2:

    Input: nums = [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    Total amount you can rob = 1 + 3 = 4.
    Example 3:

    Input: nums = [1,2,3]
    Output: 3
    

    Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 1000

    Solution: 
 */
public class DP06HouseRobber {
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 1, 3, 5, 8, 1, 9 };
        int[] arr = { 1, 2, 3, 1, 3, 5, 8, 1, 9 };
        int n = arr.length - 1;
        tabulationWithSpaceOptimized(arr, n);
        System.out.println(Math.max(tabulationWithSpaceOptimized(Arrays.copyOfRange(arr, 0, n), n-1),tabulationWithSpaceOptimized(Arrays.copyOfRange(arr, 1, n+1), n-1)));
    }

    private static int tabulationWithSpaceOptimized(int[] arr, int n) {
        long startTime = System.nanoTime();
        int prev1 = arr[0];
        int prev2 = 0;
        for (int i = 1; i <arr.length; i++) {
            int left = arr[i];
            if(i>1)
                left +=prev2;
            int right = 0 + prev1;
            prev2=prev1;
            prev1 = Math.max(left, right);
             
        }
        long totalTime = System.nanoTime() - startTime;
        // System.out.println("Output: " + prev1);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
        return prev1;
    }
}
