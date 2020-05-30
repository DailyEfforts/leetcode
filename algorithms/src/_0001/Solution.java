package _0001;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		if (nums.length < 2) {
			throw new IllegalArgumentException(
					"The length of the array is too small.");
		}
		int index1 = -1;
		int index2 = -1;
		final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			final int needed = target - nums[i];
			if (map.containsKey(needed)) {
				index1 = map.get(needed) + 1;
				index2 = i + 1;
				break;
			}
			map.put(nums[i], i);
		}
		// System.out.println(String
		// .format("index1=%d, index2=%d", index1, index2));
		return new int[] { index1, index2 };
	}
}
