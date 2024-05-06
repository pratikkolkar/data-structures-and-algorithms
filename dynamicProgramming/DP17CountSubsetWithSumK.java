package dynamicProgramming;

import java.util.Arrays;

/* 
 Problem statement
 You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.

 Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.

 Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.
 */
public class DP17CountSubsetWithSumK {
    // set mod to 10 ^ 9 + 7
    static int mod = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        int[] arr = { 0,1,2,3,4,0 };
        int k = 4;
        // recursion(arr,k);
        // memoization(arr,k);
        // tabulation(arr, k);
        tabulationWithSpaceOptimized(arr, k);

    }

    /*
     * Approach pick and non-pick
     * 
     * TC: O(N * K)
     * SC: O(K)
     */
    private static void tabulationWithSpaceOptimized(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[k + 1];
        // Base case
        if (arr[0] == 0) {
            dp[0] = 2;
        } else {
            dp[0] = 1;
        }
        if (arr[0] != 0 && arr[0] <= k)
            dp[arr[0]] = 1;

        for (int idx = 1; idx < n; idx++) {
            int[] curr = new int[k + 1];
            for (int sum = 0; sum <= k; sum++) {
                int left = dp[sum];
                int right = 0;
                if (sum >= arr[idx])
                    right = dp[sum - arr[idx]];

                curr[sum] = (left + right) % mod;
            }
            dp = curr;
        }
        System.out.println("Output: " + dp[k]);
    }

    /*
     * Approach pick and non-pick
     * 
     * TC: O(N * K)
     * SC: O(N*K)
     */
    private static void tabulation(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        // Base case
        // for (int i = 0; i < n; i++) {
        // dp[i][0] = 1;
        // }

        if (arr[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        if (arr[0] != 0 && arr[0] <= k)
            dp[0][arr[0]] = 1;

        for (int idx = 1; idx < n; idx++) {
            for (int sum = 0; sum <= k; sum++) {
                int left = dp[idx - 1][sum];
                int right = 0;
                if (sum >= arr[idx])
                    right = dp[idx - 1][sum - arr[idx]];
                dp[idx][sum] = (left + right) % mod;
            }
        }
        System.out.println("Output: " + dp[n - 1][k]);

    }

    private static void memoization(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int output = memoization(arr, n - 1, k, dp);
        System.out.println("Output: " + output);
    }

    /*
     * Approach pick and non-pick
     * 
     * TC: O(N)
     * SC: O(N)+O(N)
     */
    private static int memoization(int[] arr, int idx, int k, int[][] dp) {
        // Base case:
        if (idx == 0) {
            if (k == 0 && arr[0] == 0)
                return 2;
            if (k == 0 || arr[0] == k)
                return 1;
            return 0;
        }

        if (dp[idx][k] != -1)
            return dp[idx][k];
        int left = recursion(arr, idx - 1, k);
        int right = 0;
        if (k >= arr[idx])
            right = recursion(arr, idx - 1, k - arr[idx]);
        dp[idx][k] = (left + right) % mod;
        return dp[idx][k];
    }

    private static void recursion(int[] arr, int k) {
        int n = arr.length;
        int output = recursion(arr, n - 1, k);
        System.out.println("Output: " + output);
    }

    /*
     * Approach pick and non-pick
     * 
     * Edge Case: If we have value zero index 0, the base constion below will fail
     *      if(target==0) return 1;
     *      if(idx==0) return target==arr[0]?1:0;
     * 
     * We need to consider 2 subsets if 0 is present at index 0.
     * 
     * TC: O(2^n)
     * SC: O(N)+O(N)
     */
    private static int recursion(int[] arr, int idx, int k) {
        // Base case:
        if (idx == 0) {
            if (k == 0 && arr[0] == 0)
                return 2;
            if (k == 0 || arr[0] == k)
                return 1;
            return 0;
        }

        int left = recursion(arr, idx - 1, k);
        int right = 0;
        if (k >= arr[idx])
            right = recursion(arr, idx - 1, k - arr[idx]);
        return (left + right) % mod;
    }
}
