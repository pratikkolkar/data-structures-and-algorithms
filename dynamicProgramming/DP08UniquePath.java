package dynamicProgramming;

import java.util.Arrays;

public class DP08UniquePath {
    public static void main(String[] args) {
        int m = 3, n = 7;
        // recursion(0,0, m-1,n-1);
        // memoization(0,0,m,n);
        tabulation(0, 0, m, n);
    }

    private static void tabulation(int i, int j, int m, int n) {
        long startTime = System.nanoTime();
        int dp[][] = new int[m][n + 1];
        for (int x = m - 1; x >= 0; x--) {
            for (int y = n - 1; y >= 0; y--) {
                int count = 0;
                if (x == m - 1 && y == n - 1) {
                    dp[x][y] = 1;
                } else {
                    if (x < m - 1)
                        count += dp[x + 1][y];
                    if (y < n - 1)
                        count += dp[x][y + 1];
                    dp[x][y] = count;
                }
            }
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[0][0]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void memoization(int x, int y, int m, int n) {
        long startTime = System.nanoTime();
        int dp[][] = new int[m][n + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        findByMomization(x, y, m, n, dp);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[0][0]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static int findByMomization(int x, int y, int m, int n, int[][] dp) {
        int count = 0;
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (dp[x][y] != -1)
            return dp[x][y];
        if (x < m - 1) {
            count += findByMomization(x + 1, y, m, n, dp);
        }
        if (y < n - 1) {
            count += findByMomization(x, y + 1, m, n, dp);
        }
        dp[x][y] = count;

        return count;
    }

    private static void recursion(int x, int y, int m, int n) {
        long startTime = System.nanoTime();
        System.out.println("Output: " + findByRecursion(x, y, m, n));
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static int findByRecursion(int x, int y, int m, int n) {
        int count = 0;
        // base case
        if (x == m && y == n) {
            return 1;
        }

        if (x < m + 1) {
            count += findByRecursion(x + 1, y, m, n);
        }

        if (y < n + 1) {
            count += findByRecursion(x, y + 1, m, n);
        }
        return count;
    }
}
