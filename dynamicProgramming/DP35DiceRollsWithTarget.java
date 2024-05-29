package dynamicProgramming;

/* 
    Number of Dice Rolls With Target Sum

    You have n dice, and each dice has k faces numbered from 1 to k.

    Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.

    

    Example 1:

    Input: n = 1, k = 6, target = 3
    Output: 1
    Explanation: You throw one die with 6 faces.
    There is only one way to get a sum of 3.
    Example 2:

    Input: n = 2, k = 6, target = 7
    Output: 6
    Explanation: You throw two dice, each with 6 faces.
    There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
    Example 3:

    Input: n = 30, k = 30, target = 500
    Output: 222616187
    Explanation: The answer must be returned modulo 109 + 7.
    

    Constraints:

    1 <= n, k <= 30
    1 <= target <= 1000
 */
public class DP35DiceRollsWithTarget {
    public static int MOD = (int)(Math.pow(10, 9)+7);

    public static void main(String[] args) {
        int n = 2, k = 6, target = 7;
        // System.out.println("Output: " + recursion(n, k, target));
        System.out.println("Output: " + tabulation(n, k, target));
    }

    /* 
     * TC: O(N*target*K)
     * SC: O(N * target)
     */
    private static int tabulation(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // int cnt = 0;
                for (int z = 1; z <= k; z++) {
                    if (j - z >= 0)
                        dp[i][j] =(dp[i][j]+ dp[i - 1][j - z])%MOD;
                }
                // dp[i][j] = cnt;
            }
        }
        return dp[n][target];
    }

    /*
     * Observation:
     * 1 dice can roll k times hence. Every recursion call is nth dice and it needs
     * to be rolled k times.
     * 
     * TC: O(n*k)
     * SC: (n*k)
     */
    private static int recursion(int n, int k, int target) {
        // Base case 
        // when all dice have been rolled
        if (n == 0)
            return target==0?1:0;
        int cnt = 0;
        for (int i = 1; i <= k; i++) {
            cnt += recursion(n - 1, k, target - i);
        }
        return cnt;
    }
}
