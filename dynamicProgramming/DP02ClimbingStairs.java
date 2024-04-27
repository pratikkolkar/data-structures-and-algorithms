package dynamicProgramming;

import java.util.Arrays;

/* 
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

   Example 1:

    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    Example 2:

    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step

 */
public class DP02ClimbingStairs {
    public static void main(String[] args) {
        // recurrsion(13);
        // memoization(40);
        // tabulation(40);
        tabulationWithSpaceOptimized(40);
    }

    private static void tabulationWithSpaceOptimized(int n) {
        long startTime = System.nanoTime();
        int prev = 1;
        int prev2 = 0;
        for (int i = 1; i <= n; i++) {
            int curr = prev;
            if (i > 1) {
                curr += prev2;
            }
            prev2 = prev;
            prev = curr;
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + prev);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void tabulation(int n) {
        long startTime = System.nanoTime();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i > 1) {
                dp[i] += dp[i - 2];
            }
        }
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static void memoization(int n) {
        long startTime = System.nanoTime();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        findByMomization(n, dp);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + dp[n]);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    private static int findByMomization(int n, int[] dp) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        dp[n] = findByRecursion(n - 1) + findByRecursion(n - 2);
        return dp[n];
    }

    private static void recurrsion(int n) {
        long startTime = System.nanoTime();
        n = findByRecursion(n);
        long totalTime = System.nanoTime() - startTime;
        System.out.println("Output: " + n);
        System.out.println("Time Elaspsed: " + (totalTime / 1000000));
    }

    /*
     * f(n-1) checks for all possible one steps occurences
     * f(n-2) checkf for all possible two steps occurences
     * 
     */
    private static int findByRecursion(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        return findByRecursion(n - 1) + findByRecursion(n - 2);
    }
}
