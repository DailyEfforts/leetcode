package algorithm._1046;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(new Solution().lastStoneWeight(a));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int stone : stones) {
            q.add(stone);
        }
        while (q.size() > 1) {
            int a = q.remove();
            int b = q.remove();
            if (a > b) {
                q.add(a - b);
            } else if (a < b) {
                q.add(b - a);
            }
        }
        return q.remove();
    }
}
