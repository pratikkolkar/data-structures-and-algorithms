package dynamicProgramming;

import java.util.Arrays;

public class DP27LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        // recursion(s1, s2);
        tabulation(s1,s2);
    }
    /* 
     * Observation
     * Use Tabulation matrix to form the logic.
     * 
     * TC: O(N * M)
     * SC: O(N * M)
     * 
     */
    private static void tabulation(String s1, String s2) {
        int idx1 = s1.length();
        int idx2 = s2.length();
        int[][] dp = new int[idx1 + 1][idx2 + 1];
        int ans =0;
        for (int i = 1; i <= idx1; i++) {
            for (int j = 1; j <= idx2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println("Output: " + ans);
    }


    private static void recursion(String s1, String s2) {
        int idx1 = s1.length();
        int idx2 = s2.length();
        int output = recursion(s1, s2, idx1 - 1, idx2 - 1, 0);
        System.out.println("Output: " + output);
    }

    /*
     * Observation:
     * We need a variable "max" that tracks maximum length of longest common substring or consecutive common strings.
     * 
     * 
     * TC: O(2^m + 2^n)
     * SC: O(N)
     * 
     */
    private static int recursion(String s1, String s2, int idx1, int idx2, int max) {
        // base case
        if (idx1 < 0 || idx2 < 0) {
            return max;
        }
        int left = 0, right = 0;
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            left = recursion(s1, s2, idx1 - 1, idx2 - 1, max + 1);
        } else {
            right = Math.max(recursion(s1, s2, idx1 - 1, idx2, 0), recursion(s1, s2, idx1, idx2 - 1, 0));
        }
        //We already have max length. We will check if we are able to get max from left and right
        return Math.max(max, Math.max(left, right));
    }
}
