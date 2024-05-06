package dynamicProgramming;

import java.util.Arrays;

/* 
    Problem statement
    A thief is robbing a store and can carry a maximal weight of W into his knapsack. 
    There are N items and the ith item weighs wi and is of value vi. 
    Considering the constraints of the maximum weight that a knapsack can carry, 
    you have to find and return the maximum value that a thief can generate by stealing items.


    Sample Input:
    1 
    4
    1 2 4 5
    5 4 8 6
    5
    Sample Output:
    13
 */
public class DP19KnapSack {
    public static void main(String[] args) {
        int[] wi = { 1, 2, 4, 5 };
        int[] vi = { 5, 4, 8, 6 };
        int W = 5;
        // recursion(wi,vi,W);
        // memoization(wi,vi,W);
        // tabulation(wi,vi,W);
        tabulationSpaceOptimized(wi,vi,W);
    }

    /* 
     * 
     * TC: O(N * W)
     * SP: O(W)
     */
    private static void tabulationSpaceOptimized(int[] wi, int[] vi, int w) {
        int n = wi.length;
        int[] dp = new int[w + 1];
        for (int i = wi[0]; i <= w; i++) {
            dp[i] = vi[0];
        }

        for (int idx = 1; idx < n; idx++) {
            int[] curr = new int[w+1];
            for (int wt = 0; wt <= w; wt++) {          
                    int left = dp[wt];
                    int right = Integer.MIN_VALUE;
                    if (wt >= wi[idx])
                        right = vi[idx] + dp[wt - wi[idx]];
                    curr[wt] = Math.max(left, right);
                
            }
            dp=curr;
        }
        System.out.println("Output: " + dp[w]);
    }

    private static void tabulation(int[] wi, int[] vi, int w) {
        int n = wi.length;
        int[][] dp = new int[n][w + 1];
        for (int i = wi[0]; i <= w; i++) {
            dp[0][i] = vi[0];
        }

        for (int idx = 1; idx < n; idx++) {
            for (int wt = 0; wt <= w; wt++) {
                
                    int left = dp[idx - 1][wt];
                    int right = Integer.MIN_VALUE;
                    if (wt >= wi[idx])
                        right = vi[idx] + dp[idx - 1][wt - wi[idx]];
                    dp[idx][wt] = Math.max(left, right);
                
            }
        }
        System.out.println("Output: " + dp[n - 1][w]);
    }

    private static void memoization(int[] wi, int[] vi, int w) {
        int n = wi.length;
        int[][] dp = new int[n][w + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        memoization(wi, vi, n - 1, w, dp);
        System.out.println("Output: " + dp[n - 1][w]);
    }

    /*
     * Edge Case: Take value of index 0 if w is less or equal to wi[0]
     * 
     * TC: O(N * W)
     * SC: O(N*W) + O(N)
     */
    private static int memoization(int[] wi, int[] vi, int idx, int w, int[][] dp) {
        // Base case

        if (idx == 0) {
            return w >= wi[0] ? vi[0] : 0;
        }

        if (dp[idx][w] != -1)
            return dp[idx][w];

        int left = memoization(wi, vi, idx - 1, w, dp);
        int right = 0;
        if (w >= wi[idx])
            right = vi[idx] + memoization(wi, vi, idx - 1, w - wi[idx], dp);
        dp[idx][w] = Math.max(left, right);
        return dp[idx][w];
    }

    private static void recursion(int[] wi, int[] vi, int w) {
        int n = wi.length;
        int output = recursion(wi, vi, n - 1, w);
        System.out.println("Output: " + output);
    }

    /*
     * Edge Case: Take value of index 0 if w is less or equal to wi[0]
     * 
     * TC: O(2^n)
     * SC: O(N*W) + O(N)
     */
    private static int recursion(int[] wi, int[] vi, int idx, int w) {
        // Base case
        if (idx == 0) {
            return w >= wi[0] ? vi[0] : 0;
        }

        int left = recursion(wi, vi, idx - 1, w);
        int right = 0;
        if (w >= wi[idx])
            right = vi[idx] + recursion(wi, vi, idx - 1, w - wi[idx]);
        return Math.max(left, right);
    }
}
