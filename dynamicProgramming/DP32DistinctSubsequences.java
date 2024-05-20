package dynamicProgramming;

import java.util.Arrays;

/* 
Distinct Subsequences

Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.

 

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag
 

Constraints:

1 <= s.length, t.length <= 1000
s and t consist of English letters.
 */
public class DP32DistinctSubsequences {
    static int mod = (int) (Math.pow(10, 9) + 7);
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        // recursion(s,t);
        // memoization(s,t);
        // tabulation(s,t);
        tabulationSpaceOptimized(s, t);
    }

    private static void tabulationSpaceOptimized(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] dp = new int[m+1];
        dp[0]=1;
        for (int i = 1; i <=n; i++) {
            // int[] curr = new int[m+1];
            // curr[0]=1;
            for (int j = m; j >=1; j--) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[j] = (dp[j-1] + dp[j])%mod;
                }else{
                    dp[j] = dp[j];
                }
            }
            // dp=curr;
        }

        System.out.println("Output: "+ dp[m]);
    }

    private static void tabulation(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][]  dp = new int[n+1][m+1];

        for(int i = 0; i<=n; i++) dp[i][0]=1;
        //we need start from i=1 as we have handled that base case above for 0
        for(int i = 1; i<=m; i++) dp[0][i]=0;

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j])%mod;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println("Output: "+ dp[n][m]);
    }

    private static void memoization(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][]  dp = new int[n+1][m+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int output = memoization(s, t, n-1,m-1,dp);
        System.out.println("Output: "+output);
    }

    private static int memoization(String s, String t, int n, int m, int[][] dp) {
        //Base case
        if(m<0) return 1;
        if(n<0) return 0;

        if(dp[n][m]!=-1) return dp[n][m];

        if(s.charAt(n) == t.charAt(m)){
            return dp[n][m] = recursion(s, t, n-1, m-1) + recursion(s, t, n-1, m);
        }else{
            return dp[n][m] = recursion(s, t, n-1, m);
        }
    }

    private static void recursion(String s, String t) {
        int n = s.length();
        int m = t.length();
        int output = recursion(s, t, n-1,m-1);
        System.out.println("Output: "+output);
    }

    /* 
     * Observation:
     * need to search for subsequences of s by reducing the size in steps
     * Ex: s="babgbag" 
     * [b,a,b,g,b,a,g] - check subequnce exist from 0 to n + check from 0 to n - 1
     * 
     * TC: O(2 ^ m * n)
     * SC: O(N)
     */
    private static int recursion(String s, String t, int n, int m) {
        //Base case
        if(m<0) return 1;
        if(n<0) return 0;
        if(s.charAt(n) == t.charAt(m)){
            return recursion(s, t, n-1, m-1) + recursion(s, t, n-1, m);
        }else{
            return recursion(s, t, n-1, m);
        }
    }
}
