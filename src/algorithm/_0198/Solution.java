package algorithm._0198;

public class Solution {
    public static void main(String[] args) {
        final int[] a = {1, 3, 5, 2, 1};
        final Solution solution = new Solution();
        final int ans = solution.rob(a);
        System.out.println(ans);
    }

    public int rob(int[] nums) {
        final int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        final int[] table = new int[len];
        table[0] = nums[0];
        table[1] = table[0] > nums[1] ? table[0] : nums[1];
        for (int i = 2; i < len; i++) {
            final int rob = table[i - 2] + nums[i];
            table[i] = rob > table[i - 1] ? rob : table[i - 1];
        }
        return table[len - 1];
    }
}
