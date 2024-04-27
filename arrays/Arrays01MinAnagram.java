package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays01MinAnagram {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] a = { "abc", "aaa", "aabbh" };
        String[] b = { "abb", "aba", "abbh" };
        fetchMinAnagram(a, b).forEach(i -> System.out.print(i + " "));
        // System.out.println(a);
    }

    private static List<Integer> fetchMinAnagram(String[] a, String[] b) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < a.length; index++) {
            if (a[index].length() != b[index].length()) {
                result.add(-1);
            } else {
                String left = a[index];
                String right = b[index];
                int[] ascii = new int[26];
                for (char c : left.toCharArray()) {
                    ascii[c - 'a']++;
                } 
                // left = a-0 b-0 c-1
                // right = a, b, b
                // count 3-- 2-- 1
                int count = right.length();
                for (char c : right.toCharArray()) {
                    if (ascii[c - 'a'] > 0) {
                        ascii[c - 'a']--;
                        count--;
                    }
                }
                result.add(count);
            }
        }
        return result;
    }
}
