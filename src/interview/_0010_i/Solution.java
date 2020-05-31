package interview._0010_i;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().fib(100));
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = (a[i - 2] + a[i - 1]) % 1000000007;
        }
        return a[n];
    }
}
