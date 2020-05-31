package algorithm._0125;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        final int len = s.length();
        if (len <= 1) {
            return true;
        }

        final MyStack<Character> stack = new MyStack<Character>();
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            final char c = Character.toLowerCase(s.charAt(i));
            if (('a' <= c && c <= 'z') || '0' <= c && c <= '9') {
                stack.push(c);
                builder.append(c);
            }
        }
        for (int i = 0, size = builder.length(); i < size; i++) {
            char c = stack.pop();
            if (c != builder.charAt(i)) {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    private class MyStack<T> {
        private final List<T> list = new ArrayList<T>();

        public void push(T t) {
            list.add(t);
        }

        public T pop() {
            final int size = list.size();
            if (size == 0) {
                return null;
            }
            return list.remove(size - 1);
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }
}
