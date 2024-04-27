package dynamicProgramming;

import java.util.Arrays;

public class DP12MinFallingPathSum {

    public static void main(String[] args) {
        // int[][] arr = { { 100, -42, -46, -41 }, { 31, 97, 10, -10 }, { -58, -51, 82,
        // 89 }, { 51, 81, 69, -51 } };
        int[][] arr = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        // int m = arr.length - 1;
        // int n = arr[0].length - 1;
        // recursion(arr);
        // memoization(arr);
        // tabulation(arr);
        tabulationSpaceOptimized(arr);

    }

    private static void tabulationSpaceOptimized(int[][] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        int dp[] = new int[n];
        int mini=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    tmp[j] = arr[i][j];
                } else {
                    int min = 100000;
                    min = Math.min(min, arr[i][j] + dp[j]);
                    if (j - 1 >= 0)
                        min = Math.min(min, arr[i][j] + dp[j - 1]);

                    if (j + 1 < n)
                        min = Math.min(min, arr[i][j] + dp[j + 1]);
                    tmp[j] = min;
                }
            }
            dp=tmp;
        }
        for(int i=0; i<arr.length; i++){
            mini=Math.min(mini,dp[i]);
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + mini);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }


    private static void tabulation(int[][] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        int dp[][] = new int[n][n];
        int mini=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][j];
                } else {
                    int min = 101;
                    min = Math.min(min, arr[i][j] + dp[i - 1][j]);
                    if (j - 1 >= 0)
                        min = Math.min(min, arr[i][j] + dp[i - 1][j - 1]);

                    if (j + 1 < n)
                        min = Math.min(min, arr[i][j] + dp[i - 1][j + 1]);
                    dp[i][j] = min;
                }

            }
        }
        for(int i=0; i<arr.length; i++){
            mini=Math.min(mini,dp[n-1][i]);
        }

        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + mini);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void memoization(int[][] arr) {
        long startTime = System.nanoTime();
        int m = arr.length;
        int dp[][] = new int[m][m];
        int min = Integer.MAX_VALUE;
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        for (int i = arr.length - 1; i >= 0; i--) {
            min = Math.min(min, findByMomization(arr, m - 1, i, dp));
        }

        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + min);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }


    private static int findByMomization(int[][] arr, int m, int n, int[][] dp) {
        int min = Integer.MAX_VALUE;
        // Base case:
        // Edge case: Check if one is present
        if (n < 0 || n > arr[0].length - 1)
            return 101;
        if (m == 0 && (n >= 0 && n < arr[0].length)) {
            return arr[m][n];
        }

        if (dp[m][n] != -1)
            return dp[m][n];
        min = Math.min(min, arr[m][n] + findByMomization(arr, m - 1, n, dp));
        min = Math.min(min, arr[m][n] + findByMomization(arr, m - 1, n - 1, dp));
        min = Math.min(min, arr[m][n] + findByMomization(arr, m - 1, n + 1, dp));

        dp[m][n] = min;
        return dp[m][n];
    }

    private static void recursion(int[][] arr) {
        long startTime = System.nanoTime();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, findByRecursion(arr, arr.length - 1, i));
        }
        System.out.println("Output: " + min);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

  
    private static int findByRecursion(int[][] arr, int m, int n) {
        int min = Integer.MAX_VALUE;
        // Base case:
        // Edge case: Check if one is present
        if (n < 0 || n > arr[0].length - 1)
            return 101;
        if (m == 0) {
            return arr[m][n];
        }

        min = Math.min(min, arr[m][n] + findByRecursion(arr, m - 1, n));
        min = Math.min(min, arr[m][n] + findByRecursion(arr, m - 1, n - 1));
        min = Math.min(min, arr[m][n] + findByRecursion(arr, m - 1, n + 1));

        return min;
    }
}
