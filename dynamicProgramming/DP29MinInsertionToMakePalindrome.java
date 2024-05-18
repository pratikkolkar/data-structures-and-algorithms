package dynamicProgramming;


/* 
 Minimum Insertion Steps to Make a String Palindrome

 Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 */
public class DP29MinInsertionToMakePalindrome {
    public static void main(String[] args) {
        String str = "leetcode";
        int ans = tabulationSpaceOptimized(str);
        System.out.println("Output: "+(str.length()-ans));
    }


    /* 
     * Observation:
     * Example: str = "mbadm"
     * If we reverse str (revStr=mdabm) and find the longest common palindrome we get: mam
     * 
     * TC: O(N ^ 2)
     * SC: O(N)
     * 
     */
    private static int tabulationSpaceOptimized(String text1) {
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

        return dp[idx];
    }
}
