package dynamicProgramming;

import java.util.Arrays;

/* 
    You are given an integer array nums and an integer target.

    You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

    For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
    Return the number of different expressions that you can build, which evaluates to target.

    Example 1:

    Input: nums = [1,1,1,1,1], target = 3
    Output: 5
    Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
    -1 + 1 + 1 + 1 + 1 = 3
    +1 - 1 + 1 + 1 + 1 = 3
    +1 + 1 - 1 + 1 + 1 = 3
    +1 + 1 + 1 - 1 + 1 = 3
    +1 + 1 + 1 + 1 - 1 = 3
 */
public class DP21TargetSum {
    public static void main(String[] args) {
        /* 
         * This problem exactly follows pattern of DP18. Where we need to find two subset which will have difference of target.
         */

        int[] arr = {1,1,1,1,1};
        int target = 3;
        tabulationSpaceOptimized(arr, target);
    }

    /* 
     * TC: O(N * Target)
     * SC: O(N)
     */
    private static void tabulationSpaceOptimized(int[] arr, int diff) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        // Edge case: (sum-diff)/2 should be even
        if (sum < diff || (sum - diff) % 2 != 0) {
            System.out.println("Output: " + 0);
            return;
        }
        int target = (sum - diff) / 2;
        int[] dp = new int[target + 1];

        if (arr[0] == 0) {
            dp[0] = 2;
        } else {
            dp[0] = 1;
        }

        if (arr[0] != 0 && arr[0] <= target)
            dp[arr[0]] = 1;

        for (int idx = 1; idx < n; idx++) {
            int[] curr = new int[target + 1];
            for (int tar = 0; tar <= target; tar++) {
                int left = dp[tar];
                int right = 0;
                if (tar >= arr[idx])
                    right = dp[tar - arr[idx]];
                curr[tar] = (left + right);
            }
            dp = curr;
        }
        System.out.println("Output: " + dp[target]);
    }
}
