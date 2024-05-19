package dynamicProgramming;

/* 
    Delete Operation for Two Strings

    Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

    In one step, you can delete exactly one character in either string.

    

    Example 1:

    Input: word1 = "sea", word2 = "eat"
    Output: 2
    Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
    Example 2:

    Input: word1 = "leetcode", word2 = "etco"
    Output: 4
    

    Constraints:

    1 <= word1.length, word2.length <= 500
    word1 and word2 consist of only lowercase English letters.
 */
public class DP30MinSteptoMakeStringEqual {
    
    public static void main(String[] args) {
        String word1="sea";
        String word2="eat";
        int ans = tabulationSpaceOptimized(word1, word2);
        System.out.println("Output: "+ (word1.length()-ans)+(word2.length()-ans));
    }

    /* 
     * Observation:
     * Find the length of longest common subsequence present b/w both the strings. 
     * Subtract the length of LCS from string length to obtain the min deletions to make them equal.
     * 
     * TC: O(N * M)
     * SC: O(M)
     */
    private static int tabulationSpaceOptimized(String text1, String text2) {
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

        return dp[idx2];
    }
}
