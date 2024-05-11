package dynamicProgramming;

import java.util.Arrays;


/* 
    Longest Common Subsequence
    Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

    A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

    For example, "ace" is a subsequence of "abcde".
    A common subsequence of two strings is a subsequence that is common to both strings.

    

    Example 1:

    Input: text1 = "abcde", text2 = "ace" 
    Output: 3  
    Explanation: The longest common subsequence is "ace" and its length is 3.
    Example 2:

    Input: text1 = "abc", text2 = "abc"
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.
    Example 3:

    Input: text1 = "abc", text2 = "def"
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.
    

    Constraints:

    1 <= text1.length, text2.length <= 1000
    text1 and text2 consist of only lowercase English characters.
 */
public class DP25LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        // recursion(text1, text2);
        // memoization(text1, text2);
        // tabulation(text1, text2);
        tabulationSpaceOptimized(text1, text2);
    }

    /* 
     * TC: O(N * M)
     * SC: O(M)
     */
    private static void tabulationSpaceOptimized(String text1, String text2) {
        int idx1 = text1.length();
        int idx2 = text2.length();
        int[] dp = new int[idx2 + 1];
        
        for (int i = 1; i <= idx1; i++) {
            int[] curr = new int[idx2 + 1];
            for (int j = 1; j <= idx2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + dp[j - 1];
                } else {
                    curr[j] = Math.max(curr[j - 1], dp[j]);
                }

            }
            dp = curr;
        }

        System.out.println("Output: " + dp[idx2]);
    }

    /* 
     * TC: O(N * M)
     * SC: O(N * M)
     */
    private static void tabulation(String text1, String text2) {
        int idx1 = text1.length();
        int idx2 = text2.length();
        int[][] dp = new int[idx1 + 1][idx2 + 1];
        for (int i = 1; i <= idx1; i++) {
            for (int j = 1; j <= idx2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }

        }

        System.out.println("Output: " + dp[idx1][idx2]);
    }

    private static void memoization(String text1, String text2) {
        int idx1 = text1.length();
        int idx2 = text2.length();
        int[][] dp = new int[idx1][idx2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int output = memoization(text1, text2, idx1 - 1, idx2 - 1, dp);
        System.out.println("Output: " + output);
    }

    /* 
     * TC: O(N * M)
     * SC: O(N * M) + O(N)
     */
    private static int memoization(String text1, String text2, int idx1, int idx2, int[][] dp) {
        // Base case
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }
        if (dp[idx1][idx2] != -1)
            return dp[idx1][idx2];
        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + memoization(text1, text2, idx1 - 1, idx2 - 1, dp);
        } else {
            return dp[idx1][idx2] = Math.max(memoization(text1, text2, idx1, idx2 - 1, dp),
                    memoization(text1, text2, idx1 - 1, idx2, dp));
        }
    }

    private static void recursion(String text1, String text2) {
        int idx1 = text1.length();
        int idx2 = text2.length();
        int output = recursion(text1, text2, idx1 - 1, idx2 - 1);
        System.out.println("Output: " + output);
    }



    /* 
     * 
     * If Match technique ref line 133
     * 
     * TC: O(2^n + 2^m)
     * SC: O(N)
     * 
     */
    private static int recursion(String text1, String text2, int idx1, int idx2) {
        // Base case
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            return 1 + recursion(text1, text2, idx1 - 1, idx2 - 1);
        } else {
            return Math.max(recursion(text1, text2, idx1, idx2 - 1), recursion(text1, text2, idx1 - 1, idx2));
        }
    }
}
