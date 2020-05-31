package algorithm._0121;

public class Solution {
    public static void main(String[] args) {
        final int[] prices = {9, 11, 10, 7, 6, 8, 9, 12};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }

        final int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        int min = prices[0];
        int max = 0;
        for (int i = 1; i < len; i++) {
            final int profile = prices[i] - min;
            if (profile > max) {
                max = profile;
            }
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}