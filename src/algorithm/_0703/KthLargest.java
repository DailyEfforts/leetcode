package algorithm._0703;

import java.util.PriorityQueue;

public class KthLargest {

    private final PriorityQueue<Integer> q;
    private final int k;

    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>(k);
        for (int num : nums) {
            q.add(num);
        }
        this.k = k;
        while (q.size() > k) {
            q.remove();
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3)); // 4
        System.out.println(kthLargest.add(5)); // 5
        System.out.println(kthLargest.add(10)); // 5
        System.out.println(kthLargest.add(9)); // 8
        System.out.println(kthLargest.add(4)); // 8
    }

    public int add(int val) {
        if (q.size() < this.k) {
            q.offer(val);
        } else if (val > q.peek()) {
            q.poll();
            q.offer(val);
        }
        if (q.size() > k) {
            q.remove();
        }
        return q.peek();
    }
}
