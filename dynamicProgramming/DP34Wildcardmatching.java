package dynamicProgramming;

import java.util.Arrays;

/* 
    Wildcard Matching

    Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).
    The matching should cover the entire input string (not partial).

    

    Example 1:

    Input: s = "aa", p = "a"
    Output: false
    Explanation: "a" does not match the entire string "aa".
    Example 2:

    Input: s = "aa", p = "*"
    Output: true
    Explanation: '*' matches any sequence.
    Example 3:

    Input: s = "cb", p = "?a"
    Output: false
    Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
    

    Constraints:

    0 <= s.length, p.length <= 2000
    s contains only lowercase English letters.
    p contains only lowercase English letters, '?' or '*'.
 */
public class DP34Wildcardmatching {
    public static void main(String[] args) {
        String s = "abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab";
        String p = "*aabb***aa**a******aa*";
        // recursion(s, p);
        // memoization(s,p);
        tabulation(s, p);
    }

    private static void tabulation(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = isAllStar(p, i);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        System.out.println("Output: " + dp[n][m]);
    }

    private static boolean isAllStar(String p, int i) {
        for (int j = 0; j < i; j++) {
            if (p.charAt(j) != '*')
                return false;
        }
        return true;
    }

    private static void memoization(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n + 1][m + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int out = memoization(s, p, n - 1, m - 1, dp);
        System.out.println("Output: " + out);
    }

    private static int memoization(String s, String p, int n, int m, int[][] dp) {
        if (n < 0 && m < 0)
            return 1;
        if (m < 0 && n >= 0)
            return 0;
        if (n < 0 && m >= 0) {
            for (int i = 0; i <= m; i++) {
                if (p.charAt(i) != '*')
                    return 0;
            }
            return 1;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        if (s.charAt(n) == p.charAt(m) || p.charAt(m) == '?') {
            return dp[n][m] = memoization(s, p, n - 1, m - 1, dp);
        } else if (p.charAt(m) == '*') {
            return dp[n][m] = memoization(s, p, n - 1, m, dp) | memoization(s, p, n, m - 1, dp);
        } else {
            return 0;
        }
    }

    private static void recursion(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean out = recursion(s, p, n - 1, m - 1);
        System.out.println("Output: " + out);
    }

    private static boolean recursion(String s, String p, int n, int m) {
        if (n < 0 && m < 0)
            return true;
        if (m < 0 && n >= 0)
            return false;
        if (n < 0 && m >= 0) {
            for (int i = 0; i <= m; i++) {
                if (p.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        if (s.charAt(n) == p.charAt(m) || p.charAt(m) == '?') {
            return recursion(s, p, n - 1, m - 1);
        } else if (p.charAt(m) == '*') {
            return recursion(s, p, n - 1, m) || recursion(s, p, n, m - 1);
        } else {
            return false;
        }
    }
}
