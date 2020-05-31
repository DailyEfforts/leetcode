package algorithm._0003;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("bbtablud"));
        System.out.println(solution.lengthOfLongestSubstring("eee"));
        System.out.println(solution.lengthOfLongestSubstring("aa"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
        System.out.println(solution.lengthOfLongestSubstring("au"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        final int len = s.length();
        if (len <= 1) {
            return len;
        }
        int maxLen = Integer.MIN_VALUE;
        final Set<Character> set = new HashSet<>();
        int start = 0;
        int current = 0;
        while (current < len) {
            final char c = s.charAt(current);
            while (set.contains(c)) {
                set.remove(s.charAt(start++));
            }
            set.add(c);
            final int count = current - start + 1;
            if (count > maxLen) {
                maxLen = count;
            }
            current++;
        }
        return maxLen;
    }
}
