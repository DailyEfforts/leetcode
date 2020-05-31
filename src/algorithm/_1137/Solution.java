package algorithm._1137;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().tribonacci(0));
        System.out.println(new Solution().tribonacci(1));
        System.out.println(new Solution().tribonacci(2));
        System.out.println(new Solution().tribonacci(3));
        System.out.println(new Solution().tribonacci(4));
    }

    public int tribonacci(int n) {
        if (n < 3) {
            return Math.min(n, 1);
        }
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        a[2] = 1;
        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 3] + a[i - 2] + a[i - 1];
        }
        return a[n];
    }
}
