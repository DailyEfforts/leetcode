package algorithm._1431;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        final List<Boolean> ret = new ArrayList<>();
        if (candies == null || candies.length == 0) {
            return ret;
        }

        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        for (int candy : candies) {
            ret.add(candy + extraCandies >= max);
        }

        return ret;
    }

    public static void main(String[] args) {
        final int[] candies = new int[]{2, 3, 5, 1, 3};
        final int extraCandies = 3;
        System.out.println(new Solution().kidsWithCandies(candies, extraCandies));
    }
}
