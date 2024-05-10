package dynamicProgramming;

import java.util.Arrays;

/* 
    Rod Cutting

    Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

    Note: Consider 1-based indexing.

    Example 1:

    Input:
    N = 8
    Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
    Output:
    22
    Explanation:
    The maximum obtainable value is 22 by 
    cutting in two pieces of lengths 2 and 
    6, i.e., 5+17=22.

    Example 2:

    Input:
    N=8
    Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
    Output: 
    24
    Explanation: 
    The maximum obtainable value is 
    24 by cutting the rod into 8 pieces 
    of length 1, i.e, 8*price[1]= 8*3 = 24. 

    Expected Time Complexity: O(N2)
    Expected Auxiliary Space: O(N)

    Constraints:
    1 ≤ N ≤ 1000
    1 ≤ Ai ≤ 105


 */
public class DP24RodCutting {
    public static void main(String[] args) {
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = 8;
        // recursion(price, n);
        // memoization(price, n);
        // tabulation(price, n);
        tabulationSpaceOptimized(price, n);
    }

    private static void tabulationSpaceOptimized(int[] price, int n) {
        int[] dp = new int[n + 1];
        int[] curr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i * price[0];
        }

        for (int idx = 1; idx < n; idx++) {
            for (int len = 1; len <= n; len++) {
                int left = dp[len];
                int right = 0;
                if (len >= (idx + 1))
                    right = price[idx] + curr[len - (idx + 1)];
                curr[len] = Math.max(left, right);
            }
            dp=curr;
        }
        System.out.println("Output: "+ dp[n]);
    }

    private static void tabulation(int[] price, int n) {
        int[][] dp = new int[n][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i * price[0];
        }

        for (int idx = 1; idx < n; idx++) {
            for (int len = 1; len <= n; len++) {
                int left = dp[idx - 1][len];
                int right = 0;
                if (len >= (idx + 1))
                    right = price[idx] + dp[idx][len - (idx + 1)];
                dp[idx][len] = Math.max(left, right);
            }
        }
        System.out.println("Output: "+ dp[n-1][n]);
    }

    /*
     * TC: O(N * T)
     * SC: O(N*T)
     */
    private static void memoization(int[] price, int n) {
        int[][] dp = new int[n][n + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int ouput = memoization(price, n - 1, n, dp);
        System.out.println("Output: " + ouput);
    }

    private static int memoization(int[] price, int idx, int totalLength, int[][] dp) {
        // base case
        if (idx == 0) {
            return totalLength * price[0];// unbounded

        }

        if (dp[idx][totalLength] != -1)
            return dp[idx][totalLength];

        int left = memoization(price, idx - 1, totalLength, dp);
        int right = 0;
        if (totalLength >= (idx + 1))
            right = price[idx] + memoization(price, idx, totalLength - (idx + 1), dp);
        dp[idx][totalLength] = Math.max(left, right);
        return dp[idx][totalLength];
    }

    private static void recursion(int[] price, int n) {
        int ouput = recursion(price, n - 1, n);
        System.out.println("Output: " + ouput);
    }

    /*
     * TC: >O(2^n)
     * SC: O(N) - Stack Space
     */
    private static int recursion(int[] price, int idx, int totalLength) {
        // base case
        if (idx == 0) {
            return totalLength * price[0];// unbounded
            // return totalLength>0?price[0]:0; //bounded
        }
        int left = recursion(price, idx - 1, totalLength);
        int right = 0;
        if (totalLength >= (idx + 1))
            right = price[idx] + recursion(price, idx, totalLength - (idx + 1));
        return Math.max(left, right);
    }
}
