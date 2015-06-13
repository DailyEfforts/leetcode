package valid_parentheses;

import java.util.*;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }

        final int len = s.length();
        if (len == 0 || (len & 0x01) == 1) {
            return false;
        }

        final Set<Character> openSet = new HashSet<Character>(3);
        openSet.add('(');
        openSet.add('{');
        openSet.add('[');

        final Map<Character, Character> map = new HashMap<Character, Character>(3);
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        final List<Character> stack = new ArrayList<Character>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (openSet.contains(c)) {
                stack.add(c);
            } else {
                final int size = stack.size();
                if (size == 0) {
                    return false;
                }
                char out = stack.remove(size - 1);
                if (c != map.get(out)) {
                    return false;
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("(("));
    }
}
