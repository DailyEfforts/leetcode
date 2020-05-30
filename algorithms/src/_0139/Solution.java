package _0139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        final int len = s.length();
        if (wordDict.isEmpty() || len == 0) {
            return false;
        }
        boolean[] canBreak = new boolean[len + 1];
        canBreak[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int start = i - 1; start >= 0; start--) {
                if (canBreak[start]) {
                    String str = s.substring(start, i);
                    if (wordDict.contains(str)) {
                        canBreak[i] = true;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(canBreak));
        return canBreak[len];
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("leet");
        set.add("code");
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("", set));
        System.out.println(solution.wordBreak("leetcode", set));
    }
}
