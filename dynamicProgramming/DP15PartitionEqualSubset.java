package dynamicProgramming;

import java.util.Arrays;

/* 
 * Refere to DP14SubsetSumK. This problem is extension of it.
 * 
 * Problem Statement:
 * 
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 * 
 * Example 1:
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 */
public class DP15PartitionEqualSubset {
    public static void main(String[] args) {
        int[] nums ={1,5,11,5};
        tabulationWithSpaceOptimzed(nums);
    }


    /*
     * 
     * Time Complexity: O(N * k)
     * Space Complexity: O(2k)
     */
    private static void tabulationWithSpaceOptimzed(int[] arr) {
        long startTime = System.nanoTime();

        //Calculate sum
        int k = Arrays.stream(arr).sum();

        // return false if sum is odd because odd sum cannot be partitioned
        if (k%2!=0) {
            System.out.println("Output: " + false);
            return;
        }
        k =k/2;
        int n = arr.length;
        boolean[] dp = new boolean[k + 1];

        // Base case 1
        dp[0] = true;

        // Base case 2
        if (arr[0] <= k)
            dp[arr[0]] = true;

        for (int idx = 1; idx < n; idx++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean left = dp[target];
                boolean right = false;
                if (target >= arr[idx])
                    right = dp[target - arr[idx]];
                curr[target] = left | right;
            }
            dp = curr;
        }

        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[k]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }
}
