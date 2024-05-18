package dynamicProgramming;

import java.util.Arrays;

/* 
    Longest Palindromic Subsequence

    Given a string s, find the longest palindromic subsequence's length in s.

    A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

    

    Example 1:

    Input: s = "bbbab"
    Output: 4
    Explanation: One possible longest palindromic subsequence is "bbbb".
    Example 2:

    Input: s = "cbbd"
    Output: 2
    Explanation: One possible longest palindromic subsequence is "bb".
    

    Constraints:

    1 <= s.length <= 1000
    s consists only of lowercase English letters.
 */
public class DP28LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str = "bbbab";
        // recursion(str);
        // memoization(str);
        // tabulation(str);
        tabulationSpaceOptimized(str);
    }

    /* 
     * TC: O(N * M)
     * SC: O(M)
     */
    private static void tabulationSpaceOptimized(String text1) {
        int idx = text1.length();
        String text2 = new StringBuilder(text1).reverse().toString();
        int[] dp = new int[idx + 1];
        
        for (int i = 1; i <= idx; i++) {
            int[] curr = new int[idx + 1];
            for (int j = 1; j <= idx; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + dp[j - 1];
                } else {
                    curr[j] = Math.max(curr[j - 1], dp[j]);
                }

            }
            dp = curr;
        }

        System.out.println("Output: " + dp[idx]);
    }


    /* 
     * TC: O(N * M)
     * SC: O(N * M)
     */
    private static void tabulation(String text1) {
        int idx = text1.length();
        String text2 = new StringBuilder(text1).reverse().toString();
        int[][] dp = new int[idx + 1][idx + 1];
        for (int i = 1; i <= idx; i++) {
            for (int j = 1; j <= idx; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }

        }

        System.out.println("Output: " + dp[idx][idx]);
    }

    private static void memoization(String str) {
        int idx = str.length();
        String revStr = new StringBuilder(str).reverse().toString();
        int[][] dp = new int[idx + 1][idx+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int out = memoization(str, revStr,idx - 1,idx-1, dp);
        System.out.println("Output: " + out);
    }

    private static int memoization(String str, String revStr, int n, int m, int[][] dp) {
        if (n < 0 || m < 0) {
            return 0;
        }
        if(dp[n][m] != -1) return dp[n][m];
        if (str.charAt(n) == revStr.charAt(m)) {
            return dp[n][m] = 1 + memoization(str, revStr, n - 1, m - 1,dp);
        } else {
            return dp[n][m] = Math.max(memoization(str, revStr, n - 1, m,dp), memoization(str, revStr, n, m - 1,dp));
        }
    }

   

    private static void recursion(String str) {
        int idx = str.length();
        String revStr = new StringBuilder(str).reverse().toString();
        // int out = recursion(str, idx - 1, "");
        int out = recursion(str, revStr, idx - 1, idx - 1);
        System.out.println("Output: " + out);
    }

    /*
     * Recursion Method 2.
     * Observation:
     * Pattern follwes longest common subsequnece problem, need to provide two input
     * string. In this case reverse the string and give it as second string
     */
    private static int recursion(String str, String revStr, int n, int m) {
        if (n < 0 || m < 0) {
            return 0;
        }

        if (str.charAt(n) == revStr.charAt(m)) {
            return 1 + recursion(str, revStr, n - 1, m - 1);
        } else {
            return Math.max(recursion(str, revStr, n - 1, m), recursion(str, revStr, n, m - 1));
        }
    }

    /*
     * 
     * Recursion method 2
     * 
     * 
     * 
     */
    private static int recursion(String str, int idx, String string) {
        if (idx < 0) {
            if (ifPalindrome(string)) {
                return string.length();
            }
            return 0;
        }

        int left = 0, right = 0;
        left = recursion(str, idx - 1, string);
        right = recursion(str, idx - 1, str.charAt(idx) + string);
        return Math.max(left, right);
    }

    private static boolean ifPalindrome(String string) {
        int left = 0, right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
