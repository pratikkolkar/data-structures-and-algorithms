package dynamicProgramming;

import java.util.Arrays;

/* 
 * 
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

    You may assume that you have an infinite number of each kind of coin.

    Example 1:

    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
    Example 2:

    Input: coins = [2], amount = 3
    Output: -1
    Example 3:

    Input: coins = [1], amount = 0
    Output: 0
 */
public class DP20MinimumCoinChange {
    static private int MAX_VALUE = (int) Math.pow(10, 9);

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        // recursion(coins,amount);
        // memoization(coins, amount);
        // tabulation(coins, amount);
        tabulationSpaceOptimized(coins, amount);
    }

    private static void tabulationSpaceOptimized(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        int[] curr = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[i] = i / coins[0];
            } else {
                dp[i] = MAX_VALUE;
            }
        }

        for (int idx = 1; idx < n; idx++) {
            for (int amt = 0; amt <= amount; amt++) {
                int left = dp[amt];
                int right = MAX_VALUE;
                if (amt >= coins[idx])
                    right = 1 + curr[amt - coins[idx]]; // takr current array
                curr[amt] = Math.min(left, right);
            }
            dp = curr;
        }
        System.out.println("Output: " + (dp[amount] == MAX_VALUE ? -1 : dp[amount]));
    }

    private static void tabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = MAX_VALUE;
            }
        }

        for (int idx = 1; idx < n; idx++) {
            for (int amt = 0; amt <= amount; amt++) {
                int left = dp[idx - 1][amt];
                int right = MAX_VALUE;
                if (amt >= coins[idx])
                    right = 1 + dp[idx][amt - coins[idx]];
                dp[idx][amt] = Math.min(left, right);
            }
        }
        System.out.println("Output: " + (dp[n - 1][amount] == MAX_VALUE ? -1 : dp[n - 1][amount]));
    }

    private static void memoization(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int output = memoization(coins, amount, n - 1, dp);
        output = output == MAX_VALUE ? -1 : output;
        System.out.println("Output: " + dp[n - 1][amount]);
    }

    private static int memoization(int[] coins, int amount, int idx, int[][] dp) {
        // Base case
        if (idx == 0) {
            if (amount % coins[idx] == 0) {
                return amount / coins[idx];
            } else {
                return MAX_VALUE;
            }
        }

        if (dp[idx][amount] != -1)
            return dp[idx][amount];

        int left = recursion(coins, amount, idx - 1);
        int right = MAX_VALUE;
        if (amount >= coins[idx])
            right = 1 + recursion(coins, amount - coins[idx], idx);
        dp[idx][amount] = Math.min(left, right);
        return dp[idx][amount];
    }

    private static void recursion(int[] coins, int amount) {
        int n = coins.length;
        int output = recursion(coins, amount, n - 1);
        output = output == MAX_VALUE ? -1 : output;
        System.out.println("Output: " + output);
    }

    private static int recursion(int[] coins, int amount, int idx) {
        // Base case
        if (idx == 0) {
            if (amount % coins[idx] == 0) {
                return amount / coins[idx];
            } else {
                return MAX_VALUE;
            }
        }

        int left = recursion(coins, amount, idx - 1);
        int right = MAX_VALUE;
        if (amount >= coins[idx])
            right = 1 + recursion(coins, amount - coins[idx], idx);
        return Math.min(left, right);
    }
}
