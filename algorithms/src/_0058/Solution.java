package _0058;

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        final int len = s.length();
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            final char c = s.charAt(i);
            if (c == ' ') {
                break;
            }
            ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord(" a"));
    }
}
