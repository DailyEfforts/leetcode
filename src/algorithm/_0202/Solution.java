package algorithm._0202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isHappy(99);
    }

    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 0) {
            return true;
        }
        Set<Integer> set = new HashSet<Integer>();
        while (true) {
            String str = String.valueOf(n);
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += Math.pow(str.charAt(i) - '0', 2);
            }
            n = sum;
            if (set.contains(n)) {
                break;
            }
            set.add(n);
            if (n == 1) {
                return true;
            }
        }

        return false;
    }
}