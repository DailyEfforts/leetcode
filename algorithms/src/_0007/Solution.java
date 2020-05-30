package _0007;

public class Solution {

	public int reverse(int x) {
		final boolean isNegative = x < 0;
		final String str = String.valueOf(Math.abs(x));
		final StringBuilder builder = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			builder.append(str.charAt(i));
		}
		Integer value = 0;
		try {
			value = Integer.valueOf(builder.toString());
		} catch (NumberFormatException e) {
			// Let it go.
		}
		return isNegative ? -value : value;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverse(123));
		System.out.println(solution.reverse(-1230));
	}
}
