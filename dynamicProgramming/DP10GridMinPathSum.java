package dynamicProgramming;

import java.util.Arrays;

/* 
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.

    Example 1:
    Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
    Output: 7
    Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
    Example 2:

    Input: grid = [[1,2,3],[4,5,6]]
    Output: 12
 */
public class DP10GridMinPathSum {
    public static void main(String[] args) {
        int[][] arr = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        int m = arr.length - 1;
        int n = arr[0].length - 1;
        // recursion(arr, m, n);
        // memoization(arr,m,n);
        // tabulation(arr,m,n);
        tabulationSpaceOptimized(arr, m, n);

    }

    private static void tabulationSpaceOptimized(int[][] arr, int m, int n) {
        long startTime = System.nanoTime();
        int dp[] = new int[n + 1];
        for (int i = 0; i <= m; i++) {
            int[] curr = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = arr[i][j];
                } else {
                    int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                    if (i > 0) {
                        left = arr[i][j] + dp[j];
                    }

                    if (j > 0) {
                        right = arr[i][j] + curr[j - 1];
                    }
                    curr[j]=Math.min(left, right);
                }
            }
            dp = curr;
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void tabulation(int[][] arr, int m, int n) {
        long startTime = System.nanoTime();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = arr[i][j];
                } else{
                    int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                    if (i > 0) {
                        left= arr[i][j]+dp[i - 1][j];
                    }

                    if (j > 0) {
                        right= arr[i][j]+dp[i][j - 1];
                    }
                    dp[i][j] =Math.min(left, right);
                }
            }
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[m][n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void memoization(int[][] arr, int m, int n) {
        long startTime = System.nanoTime();
        int dp[][] = new int[m + 1][n + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        findByMomization(arr, m, n, dp);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[m][n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static int findByMomization(int[][] arr, int m, int n, int[][] dp) {
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        // Base case:
        // Edge case: Check if one is present
        if (m == 0 && n == 0) {
            return arr[m][n];
        }

        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;


        if(dp[m][n]!=-1) return dp[m][n];

        if (m > 0) {
            left = arr[m][n] + findByRecursion(arr, m - 1, n);
        }

        if (n > 0) {
            right = arr[m][n] + findByRecursion(arr, m, n - 1);
        }
        dp[m][n]=Math.min(left, right);
        return dp[m][n];
    }

    private static void recursion(int[][] arr, int m, int n) {
        long startTime = System.nanoTime();
        System.out.println("Output: " + findByRecursion(arr, m, n));
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static int findByRecursion(int[][] arr, int m, int n) {
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        // Base case:
        // Edge case: Check if one is present
        if (m == 0 && n == 0) {
            return arr[m][n];
        }

        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;

        if (m > 0) {
            left = arr[m][n] + findByRecursion(arr, m - 1, n);
        }

        if (n > 0) {
            right = arr[m][n] + findByRecursion(arr, m, n - 1);
        }

        return Math.min(left, right);
    }
}
