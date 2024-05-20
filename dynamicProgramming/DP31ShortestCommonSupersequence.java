package dynamicProgramming;

/* 
 Shortest Common Supersequence

 Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.
 */
public class DP31ShortestCommonSupersequence {
    public static void main(String[] args) {
        String text1 = "abac";
        String text2 = "cab";
        tabulation(text1,text2);
    }

    /* 
     * Observation:
     * Refer LCS to get dp table of longest common subsequence
     * 
     * if text1[left-1] ==  text2[right-1]  then sb.insert(0,text1[left-1]), decrement left and right by 1
     * else if dp[left-1][right] ==  text2[left][right-1] then sb.insert(0,text1[left-1]) then decrement left by 1
     * else sb.insert(0,text2[right-1]) then decrement right by 1
     * 
     * while left>0 then sb.insert(0,text1[left]), left--
     * while right>0 then sb.insert(0,text2[right]), right--
     * 
     * return the string
     * 
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

        int left=idx1, right = idx2;
        StringBuilder sb = new StringBuilder(); 
        while (left>0  && right > 0) {
            if(text1.charAt(left-1)==text2.charAt(right-1)){
                sb.insert(0, text1.charAt(left-1));
                left--;
                right--;
            }else if(dp[left-1][right]>dp[left][right-1]){
                sb.insert(0, text1.charAt(left-1));
                left--;
            }else{
                sb.insert(0, text2.charAt(right - 1));
                right--;
            }
        }
        while(left>0){
            sb.insert(0, text1.charAt(left-1));
            left--;
        }
        while(right>0){
            sb.insert(0, text2.charAt(right-1));
            right--;
        }
        System.out.println("Output: " + sb.toString());
    }
}
