package maximum_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        final int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        final Solution solution = new Solution();
        final int ans = solution.maxSubArray(a);
        System.out.println(ans);
    }
}
