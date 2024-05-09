package dynamicProgramming;

import java.util.Arrays;

/* 
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
    Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
    You may assume that you have an infinite number of each kind of coin.

    The answer is guaranteed to fit into a signed 32-bit integer.

    Example 1:

    Input: amount = 5, coins = [1,2,5]
    Output: 4
    Explanation: there are four ways to make up the amount:
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1
    Example 2:

    Input: amount = 3, coins = [2]
    Output: 0
    Explanation: the amount of 3 cannot be made up just with coins of 2.
    Example 3:

    Input: amount = 10, coins = [10]
    Output: 1
    

    Constraints:

    1 <= coins.length <= 300
    1 <= coins[i] <= 5000
    All the values of coins are unique.
    0 <= amount <= 5000

 */
public class DP22CoinChnageII {
    static int mod = (int) (Math.pow(2, 32));

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 5;
        // recursion(coins, amount);
        // memoization(coins, amount);
        // tabulation(coins, amount);
        tabulationSpaceOptimized(coins, amount);
    }


    /* 
     * TC: O(N * T)
     * SC: O(T)
     */
    private static void tabulationSpaceOptimized(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[i] = 1;
            }
        }
        for (int idx = 1; idx < n; idx++) {
            int[] curr=new int[amount+1];
            for (int amt = 0; amt <= amount; amt++) {
                int left = 0 + dp[amt];
                int right = 0;
                if (amt >= coins[idx])
                    right = curr[amt - coins[idx]];
                curr[amt] = (left + right) % mod;
            }
            dp=curr;
        }
        System.out.println("Output: "+dp[amount]);
    }

    /* 
     * TC: O(N * T)
     * SC: O(N * T)
     */
    private static void tabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for (int idx = 1; idx < n; idx++) {
            for (int amt = 0; amt <= amount; amt++) {
                int left = 0 + dp[idx - 1][amt];
                int right = 0;
                if (amt >= coins[idx])
                    right = dp[idx][amt - coins[idx]];
                dp[idx][amt] = (left + right) % mod;
            }
        }
        System.out.println("Output: "+dp[n-1][amount]);
    }

    private static void memoization(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int output = memoization(coins, n - 1, amount, dp);
        System.out.println("Output: " + output);
    }


    /* 
     * TC: O(N * T)
     * SC: O(N * T) + O(N)
     */
    private static int memoization(int[] coins, int idx, int amount, int[][] dp) {
        // Base case
        if (idx == 0) {
            if (amount % coins[idx] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[idx][amount] != -1)
            return dp[idx][amount];
        int left = 0 + memoization(coins, idx - 1, amount, dp);
        int right = 0;
        if (amount >= coins[idx])
            right = memoization(coins, idx, amount - coins[idx], dp);
        dp[idx][amount] = (left + right) % mod;
        return dp[idx][amount];
    }

    private static void recursion(int[] arr, int amount) {
        int n = arr.length;
        int output = recursion(arr, n - 1, amount);
        System.out.println("Output: " + output);
    }


    /* 
     * TC: O(N * T)
     * SC: O(N * T) + O(N)
     */
    private static int recursion(int[] coins, int idx, int amount) {
        // Base case
        if (idx == 0) {
            if (amount % coins[idx] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int left = 0 + recursion(coins, idx - 1, amount);
        int right = 0;
        if (amount >= coins[idx])
            right = recursion(coins, idx, amount - coins[idx]);
        return (left + right) % mod;
    }
}
