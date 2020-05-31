package interview._0010_ii;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numWays(7));
    }

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i++) {
            a[i] = (a[i - 2] + a[i - 1]) % 1000000007;
        }
        return a[n];
    }
}
