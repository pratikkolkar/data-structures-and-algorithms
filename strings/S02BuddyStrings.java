package strings;

/**
 * S02BuddyStrings
 * 
 * Given two strings s and goal, return true if you can swap two letters in s so
 * the result is equal to goal, otherwise, return false.
 * 
 * Swapping letters is defined as taking two indices i and j (0-indexed) such
 * that i != j and swapping the characters at s[i] and s[j].
 * 
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 * 
 * 
 * Example 1:
 * 
 * Input: s = "ab", goal = "ba"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is
 * equal to goal.
 * Example 2:
 * 
 * Input: s = "ab", goal = "ab"
 * Output: false
 * Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b',
 * which results in "ba" != goal.
 * Example 3:
 * 
 * Input: s = "aa", goal = "aa"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is
 * equal to goal.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length, goal.length <= 2 * 104
 * s and goal consist of lowercase letters.
 */
public class S02BuddyStrings {

    public static void main(String[] args) {
        String s = "ab";
        String goal = "ba";
        System.out.println(buddyStrings(s, goal));
    }

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int n = s.length();
        int idx1 = -1, idx2 = -1;
        int[] ascii = new int[128];
        // check i two places differ
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (idx1 == -1) {
                    idx1 = i;
                } else if (idx2 == -1) {
                    idx2 = i;
                } else {
                    return false;
                }
            }
            ascii[(int) s.charAt(i)]++;
        }
        // for the swap to be true it requires two index's
        if (idx1 == -1 && idx2 != -1)
            return false;
        if (idx2 == -1 && idx1 != -1)
            return false;
        // swap and return if true/false
        if (idx1 != -1 && idx2 != -1) {
            char[] c = s.toCharArray();
            char t = c[idx1];
            c[idx1] = c[idx2];
            c[idx2] = t;
            StringBuilder sb = new StringBuilder();
            return sb.append(c).toString().equals(goal);

        }
        // If same character appears more than or equal to 2 then we can swap
        for (char c : s.toCharArray()) {
            if (ascii[(int) c] >= 2) {
                return true;
            }
        }
        return false;
    }
}