package dynamicProgramming;

import java.util.Arrays;

/*
    Edit Distance

    Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

    You have the following three operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character
    

    Example 1:

    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation: 
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')
    Example 2:

    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation: 
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')
    

    Constraints:

    0 <= word1.length, word2.length <= 500
    word1 and word2 consist of lowercase English letters.
 */
public class DP33EditDistance {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        // recursion(word1, word2);
        // memoization(word1,word2);
        tabulation(word1,word2);
    }

    private static void tabulation(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <=m; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <=n; i++) {
            dp[i][0]=i;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }
        System.out.println("Output: "+dp[n][m]);
    }

    private static void memoization(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a,-1));
        int output = memoization(word1, word2, n - 1, m - 1,dp);
        System.out.println(output);
    }

    private static int memoization(String word1, String word2, int n, int m, int[][] dp) {
        // Base case
        if (n < 0)
            return m + 1;
        if (m < 0)
            return n + 1;

        if(dp[n][m] != -1) return dp[n][m];
        if (word1.charAt(n) == word2.charAt(m)) {
            return dp[n][m]=memoization(word1, word2, n - 1, m - 1,dp);
        } else {
            return dp[n][m]=1 + Math.min(memoization(word1, word2, n - 1, m,dp),
                    Math.min(memoization(word1, word2, n, m - 1,dp), memoization(word1, word2, n - 1, m - 1,dp)));
        }
    }

    private static void recursion(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int output = recursion(word1, word2, n - 1, m - 1);
        System.out.println(output);
    }

    /* 
     * Observation:
     * If word1[i] == word2[j]  then f(n-1,m-1)
     * else 
     *    1 + Min( f(n,m-1)  - insert 
     *             f(n-1,m)  - delete
     *             f(n-1,m-1)- Replace
     *           )
     *  TC: O(3 ^ N)
     *  SC: O(N) - Stack space
     */
    private static int recursion(String word1, String word2, int n, int m) {
        // Base case
        if (n < 0)
            return m + 1;
        if (m < 0)
            return n + 1;
        if (word1.charAt(n) == word2.charAt(m)) {
            return recursion(word1, word2, n - 1, m - 1);
        } else {
            return 1 + Math.min(recursion(word1, word2, n - 1, m),
                    Math.min(recursion(word1, word2, n, m - 1), recursion(word1, word2, n - 1, m - 1)));
        }
    }
}
