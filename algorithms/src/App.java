import java.io.File;
import java.util.Scanner;

import two_sum.Solution;

public class App {
	public static void main(String[] args) throws Exception {
		final Solution solution = new Solution();
		final File file = new File("./input.txt");
		Scanner scanner = new Scanner(file);
		String line = scanner.nextLine();
		String[] arr = line.split(",[ ]?");
		final int[] nums = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			nums[i] = Integer.valueOf(arr[i]);
		}
		final int target = 6;

		final long start = System.currentTimeMillis();
		solution.twoSum(nums, target);
		System.out.println(System.currentTimeMillis() - start);
	}
}
