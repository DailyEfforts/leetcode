package algorithm._1450;

public class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        if (startTime == null || endTime == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        final int[] startTime = new int[]{1, 2, 3};
        final int[] endTime = new int[]{3, 2, 7};
        final int queryTime = 4;
        System.out.println(new Solution().busyStudent(startTime, endTime, queryTime));
    }
}
