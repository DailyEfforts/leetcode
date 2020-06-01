package algorithm._1464;

import java.util.Arrays;

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int a = nums[nums.length - 1];
        int b = nums[nums.length - 2];
        return (a - 1) * (b - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 2};
        System.out.println(new Solution().maxProduct(a));
    }
}
